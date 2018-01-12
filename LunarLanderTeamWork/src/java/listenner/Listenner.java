/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package listenner;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 *
 * @author dam2a26
 */
public class Listenner implements ServletContextListener{

    @Override
    public void contextInitialized(ServletContextEvent sce) {
          EntityManagerFactory emf = Persistence.createEntityManagerFactory("TeamWorkLander");
        sce.getServletContext().setAttribute("emf", emf);
     }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
         EntityManagerFactory emf = (EntityManagerFactory) sce.getServletContext().getAttribute("emf");
        emf.close();
        
    }
 
    
}
