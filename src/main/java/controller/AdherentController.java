package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import entity.Adherent;
import service.Bibliotheque;



@Controller
@RequestMapping("/adherent")
public class AdherentController {
	@Autowired
	Bibliotheque biblio;
	
	@RequestMapping("/lister")
	public String afficherAdherent(Model model) {
		model.addAttribute("adherents", biblio.getAdherentDao().findAll());
		return "adherents";
	}
	
	@RequestMapping("/editer")
	public String editerAdherent(@RequestParam int id, Model model) {
		if(id!=0)model.addAttribute("adherent", biblio.getAdherentDao().findOne(id));
		else model.addAttribute("adherent", new Adherent());
		return "adherent";
	}
	
	
	
	
	@RequestMapping("/action")
	public String editerAdherent(@RequestParam String action,  Adherent adherent,  Model model) {
		switch (action) {
		case "create" :
			biblio.ajouterAdherent(adherent);
			break;
		case "update" :
			biblio.getAdherentDao().update(adherent);
			break;
		case "delete" :
			biblio.retirerAdherent(adherent.getId());
			break;
		}
		
		return "redirect:lister.spring";
	}

}
