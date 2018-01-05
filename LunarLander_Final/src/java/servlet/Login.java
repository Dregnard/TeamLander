/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import clases.SQL;
import clases.User;
import clases.MysqlConnectionHandler;
import java.io.IOException;
import java.io.PrintWriter;
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
public class Login extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        MysqlConnectionHandler ms = new MysqlConnectionHandler();
        Connection conn = ms.doConnection();
        try {

            SQL cons = new SQL();
            if (cons.comprobarLogUser(conn, username)) {
                User user = cons.GetUser(conn, username);
                if (user.getPassword().equals(password)) {

                    Cookie userCookie = new Cookie("uC", Integer.toString(user.getId()));
                    Cookie usernameCookie = new Cookie("uNC", username);
                    Cookie pwdCookie = new Cookie("passC", password);

                    userCookie.setMaxAge(60 * 60 * 24 * 365);
                    usernameCookie.setMaxAge(60 * 60 * 24 * 365);
                    pwdCookie.setMaxAge(60 * 60 * 24 * 365);

                    userCookie.setPath("/");
                    usernameCookie.setPath("/");
                    pwdCookie.setPath("/");

                    response.addCookie(userCookie);
                    response.addCookie(usernameCookie);
                    response.addCookie(pwdCookie);

                    RequestDispatcher a = request.getRequestDispatcher("game.jsp");
                    a.forward(request, response);

                } else {
                    response.setContentType("application/json");
                    PrintWriter pw = response.getWriter();
                    pw.println("{\"mess\":\"La contraseña introducida es erronea\"}");
                }
            } else {
                response.setContentType("application/json");
                PrintWriter pw = response.getWriter();
                pw.println("{\"mess\":\"El usuario introducido no existe\"}");
            }
        } catch (SQLException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
            response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            response.setContentType("application/json");
            PrintWriter pw = response.getWriter();
            pw.println("{\"error\":\"Error al crear el usuario\"}");
        } finally {
            ms.closeConnection();
        }

    }
}
