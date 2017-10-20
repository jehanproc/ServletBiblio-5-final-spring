package filter;

import java.io.IOException;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

import util.JpaUtil;

/**
 * Servlet Filter implementation class TransactionFilter
 */
@WebFilter(servletNames = { "adherentServlet" })
public class TransactionFilter implements Filter {

	static EntityManagerFactory emf = Persistence.createEntityManagerFactory("biblio");
	
    public TransactionFilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		EntityManager em =JpaUtil.getCurrentEntityManager();
		em.getTransaction().begin();
		chain.doFilter(request, response);
		em.getTransaction().commit();
		JpaUtil.closeCurrentEntityManager();
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
