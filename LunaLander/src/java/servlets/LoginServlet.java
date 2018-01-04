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
@WebServlet(name = "LoginServlet", urlPatterns = {"/LoginServlet"})
public class LoginServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            EntityManagerFactory emf = (EntityManagerFactory) getServletContext().getAttribute("emf");
            UserJpaController uc = new UserJpaController(emf);
            User u = uc.findUserByUsername(request.getParameter("userName"));
            if (u == null ) {
                Map<String, String> emess = new HashMap<>();
                emess.put("error", "User not found");

                Gson gson = new GsonBuilder().create();
                response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
                response.setContentType("application/json");
                PrintWriter pw = response.getWriter();
                pw.println(gson.toJson(emess));
            } else { 
                if (u.getPassword().equals(new Encriptacion(request.getParameter("password")).getPassEncrypt())) {
                    Map<String, String> emess = new HashMap<>();
                    emess.put("mess", "Succesfull");

                    Gson gson = new GsonBuilder().create();
                    
                    response.setContentType("application/json");
                    PrintWriter pw = response.getWriter();
                    pw.println(gson.toJson(emess));
                } else {
                    Map<String, String> emess = new HashMap<>();
                    emess.put("error", "Password not found");

                    Gson gson = new GsonBuilder().create();
                    response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
                    response.setContentType("application/json");
                    PrintWriter pw = response.getWriter();
                    pw.println(gson.toJson(emess));
                }
            }
        } catch (Exception e) {
            Map<String, String> emess = new HashMap<>();
            emess.put("error", "LoginServlet error");

            Gson gson = new GsonBuilder().create();
            response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            response.setContentType("application/json");
            PrintWriter pw = response.getWriter();
            pw.println(gson.toJson(emess));

        }
    }
}