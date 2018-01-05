package servlet;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import clases.SQL;
import clases.MysqlConnectionHandler;
import clases.User;
import servlet.Login;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author dam2a07
 */
public class Cookies extends HttpServlet {

    @Override
    public void init() throws ServletException {
        //To change body of generated methods, choose Tools | Templates.
        createDB();

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        RequestDispatcher rd = request.getRequestDispatcher("/index.html");
        rd.forward(request, response);

        String cookieName = "uC";
        String cookieUsername = "uNC";
        String cookiePass = "passC";

        Cookie[] cookies = request.getCookies();

        String nameC = null;
        String usernameC = null;
        String passwordC = null;

        if (cookies != null) {
            for (int i = 0; i < cookies.length; i++) {
                Cookie cookie = cookies[i];
                if (cookieName.equals(cookie.getName())) {
                    usernameC = cookie.getValue();
                }
                if (cookieUsername.equals(cookie.getName())) {
                    nameC = cookie.getValue();
                }
                if (cookiePass.equals(cookie.getName())) {
                    passwordC = cookie.getValue();
                }
            }
            if (nameC == null || usernameC == null || passwordC == null) {
                RequestDispatcher a = request.getRequestDispatcher("/index.html");
                a.forward(request, response);
            } else {
                MysqlConnectionHandler ms = new MysqlConnectionHandler();
                Connection conn = ms.doConnection();
                try {
                    SQL cons = new SQL();
                    User user = cons.GetUserById(conn, nameC);
                    if (user.getName().equals(nameC) && user.getPassword().equals(passwordC)) {

                        request.setAttribute("username", user);
                        RequestDispatcher a = request.getRequestDispatcher("/game.jsp");
                        a.forward(request, response);

                    } else {
                        RequestDispatcher a = request.getRequestDispatcher("/index.html");
                        a.forward(request, response);

                    }
                } catch (IOException | SQLException | ServletException ex) {
                    ex.printStackTrace();
                } finally {
                    ms.closeConnection();
                }
            }

        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    public void createDB() {
        System.out.println("INIT");
        MysqlConnectionHandler ms = new MysqlConnectionHandler();

        String sql = "CREATE TABLE User (\n"
                + "  id int(11) NOT NULL AUTO_INCREMENT,\n"
                + "  nombre varchar(20) NOT NULL,\n"
                + "  username varchar(20) NOT NULL,\n"
                + "  password varchar(255) NOT NULL,\n"
                + "  PRIMARY KEY (id)\n"
                + ") ENGINE=MyISAM  DEFAULT CHARSET=latin1";
        String sql1 = "CREATE TABLE Configuration (id int(11) NOT NULL AUTO_INCREMENT,user_id int(11) NOT NULL,dif_id int(11) NOT NULL, nave_id int(11) NOT NULL,\n"
                + "luna_id int(11) NOT NULL,\n"
                + "PRIMARY KEY (id),\n"
                + "FOREIGN KEY (user_id) REFERENCES Configuration(id)\n"
                + ") ENGINE=MyISAM  DEFAULT CHARSET=latin1";
        String sql2 = "CREATE TABLE Score (\n"
                + "  id int(11) NOT NULL AUTO_INCREMENT,\n"
                + "  conf_id int(11) NOT NULL,\n"
                + "  speed float NOT NULL,\n"
                + "  fuel float NOT NULL,\n"
                + "  iniTime time NOT NULL,\n"
                + "  endTime time NOT NULL,\n"
                + "  PRIMARY KEY (id),\n"
                + "  FOREIGN KEY (conf_id) REFERENCES Configuration(id)\n"
                + ") ENGINE=MyISAM  DEFAULT CHARSET=latin1";

        String insert1 = "INSERT INTO User (id, nombre, username, password) VALUES(1, 'Fabian', 'Toki', 'mal')";
        String insert2 = "INSERT INTO Configuration (id, user_id, dif_id, nave_id, luna_id) VALUES (1, 1, 3, 2, 2)";
        String insert3 = "INSERT INTO Score (id, conf_id, speed, fuel, iniTime, endTime) VALUES (1, 1, 5.5, 20.1, '19:00:00', '19:02:20'),(2, 1, 5.6, 20.2, '19:00:00', '19:03:20'), (3, 1, 5.7, 20.3, '19:00:00', '19:04:20')";

        Connection conn = ms.doConnection();
        ms.exQueryPS((com.mysql.jdbc.Connection) conn, sql);
        ms.exQueryPS((com.mysql.jdbc.Connection) conn, insert1);

        ms.exQueryPS((com.mysql.jdbc.Connection) conn, sql1);
        ms.exQueryPS((com.mysql.jdbc.Connection) conn, insert2);

        ms.exQueryPS((com.mysql.jdbc.Connection) conn, sql2);
        ms.exQueryPS((com.mysql.jdbc.Connection) conn, insert3);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
