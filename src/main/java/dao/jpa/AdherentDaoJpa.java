package dao.jpa;

import java.util.List;

import util.JpaUtil;
import dao.AdherentDao;
import entity.Adherent;

public class AdherentDaoJpa implements AdherentDao {
	
	@Override
	public Adherent save(Adherent entity) {
		JpaUtil.getCurrentEntityManager().persist(entity);
		return entity;
	}

	@Override
	public void update(Adherent entity) {
		JpaUtil.getCurrentEntityManager().merge(entity);
	}

	@Override
	public Adherent findOne(Integer primaryKey) {
		return JpaUtil.getCurrentEntityManager().find(Adherent.class, primaryKey);
	}

	@Override
	public List<Adherent> findAll() {
		// TODO Auto-generated method stub
		
		return JpaUtil.getCurrentEntityManager()
			.createQuery("from Adherent", Adherent.class)
			.getResultList();		
	}

	@Override
	public void delete(Adherent entity) {
		delete(entity.getId());

	}

	@Override
	public void delete(Integer id) {
		JpaUtil.getCurrentEntityManager().remove(findOne(id));
	}

	@Override
	public void delete(Iterable<Adherent> entities) {
		for(Adherent l : entities)
			delete(l);

	}


	@Override
	public boolean isPresent(Adherent adherent) {
		 return JpaUtil.getCurrentEntityManager()
				.createQuery("from Adherent where nom = :nom and email = :email", Adherent.class)
				.setParameter("nom", adherent.getNom())
				.setParameter("email", adherent.getEmail())
				.getResultList().size() == 1 ? true : false;
	}

}
