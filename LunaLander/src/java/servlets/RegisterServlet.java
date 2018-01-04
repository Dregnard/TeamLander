package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.util.Map;
import javax.persistence.EntityManagerFactory;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Encriptacion;
import model.User;
import model.UserJpaController;

/**
 *
 * @author dam2a26
 */
@WebServlet(name = "RegisterServlet", urlPatterns = {"/RegisterServlet"})
public class RegisterServlet extends HttpServlet {
//create user with e-mail
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {
            EntityManagerFactory emf = (EntityManagerFactory) getServletContext().getAttribute("emf");
            UserJpaController uc = new UserJpaController(emf);
            if (!uc.existByUsername(request.getParameter("userName"))) {
                if (!uc.existByEmail(request.getParameter("email"))) {
                    User u = new User();

                    u.setName(request.getParameter("name"));
                    u.setUsername(request.getParameter("userName"));
                    
		    u.setPassword(new Encriptacion(request.getParameter("password")).getPassEncrypt());
                    u.setEmail(request.getParameter("email"));
                    uc.create(u);
                    Map<String, String> mess = new HashMap<>();
                    mess.put("mess", "User Created");

                    Gson gson = new GsonBuilder().create();

                    response.setContentType("application/json");
                    PrintWriter pw = response.getWriter();
                    pw.println(gson.toJson(mess));
                    
                } else {
                    Map<String, String> mess = new HashMap<>();
                    mess.put("error", "Email already exists");
                    Gson gson = new GsonBuilder().create();
                    
		    response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
                    response.setContentType("application/json");
                    PrintWriter pw = response.getWriter();
                    pw.println(gson.toJson(mess));
                }

            } else {
                Map<String, String> mess = new HashMap<>();
                mess.put("error", "This username already exists");

                Gson gson = new GsonBuilder().create();
               
		response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
                response.setContentType("application/json");
                PrintWriter pw = response.getWriter();
                pw.println(gson.toJson(mess));

            }

        } catch (Exception e) {
            Map<String, String> emess = new HashMap<>();
            emess.put("error", "RegisterServlet error");

            Gson gson = new GsonBuilder().create();
           
	    response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            response.setContentType("application/json");
            PrintWriter pw = response.getWriter();
            pw.println(gson.toJson(emess));

        }

    }

}