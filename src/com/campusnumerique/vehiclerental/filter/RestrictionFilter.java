package com.campusnumerique.vehiclerental.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.campusnumerique.vehiclerental.bean.ClientBean;

public class RestrictionFilter implements Filter {

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest arg0, ServletResponse arg1, FilterChain arg2)
			throws IOException, ServletException {
        /* Cast des objets request et response */
        HttpServletRequest request = (HttpServletRequest) arg0;
        HttpServletResponse response = (HttpServletResponse) arg1;

        /* Récupération de la session depuis la requête */
        HttpSession session = request.getSession();

        /**
         * Si l'objet utilisateur n'existe pas dans la session en cours, alors
         * l'utilisateur n'est pas connecté.
         */

        if ( session.getAttribute( "client" ) == null ) {
            /* Redirection vers la page publique */
        	System.out.println(request.getContextPath());
            response.sendRedirect( request.getContextPath() + "/login" );
        } else {
            if ( ((ClientBean) session.getAttribute( "client" )).getFirstName() == null ) {
                /* Redirection vers la page publique */
            	System.out.println(request.getContextPath());
                response.sendRedirect( request.getContextPath() + "/login" );
            /* Affichage de la page restreinte */
            } else {
            	arg2.doFilter( request, response );
            }
        }

		
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
	}

}
