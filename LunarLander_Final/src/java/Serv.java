/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.RandomAccessFile;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author dam2a07
 */
@WebServlet(urlPatterns = {"/Serv"})
public class Serv extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        ServletContext context = getServletContext();
        String fullPath = context.getRealPath("j.json");

//Create File object
        File f = new File(fullPath);
        String jsonString = null;

        try (
                RandomAccessFile frar = new RandomAccessFile(f, "r")) {
            jsonString = frar.readLine();
            frar.close();
            response.setContentType("application/json");
            PrintWriter pw = response.getWriter();
            pw.println(jsonString);
        } catch (Exception e) {
            //manage error
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
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            String dificultad = request.getParameter("dificultad");
            String modeloLuna = request.getParameter("modeloLuna");
            String modeloNave = request.getParameter("modeloNave");

            ServletContext context = getServletContext();
            String fullPath = context.getRealPath("j.json");

            String filecontent = "{\"dificultad\":\"" + dificultad + "\",\"modeloLuna\":\"" + modeloLuna + "\",\"modeloNave\":\"" + modeloNave + "\"}";

            //Create File object
            File f = new File(fullPath);
            try (FileWriter fw = new FileWriter(f)) {
                fw.write(filecontent);
            }

            response.setContentType("json");
            PrintWriter pw = response.getWriter();
            pw.println("{\"mess\":\"El fichero ha sido guardado correctamente\"}");

        } catch (IOException e) {

            response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            response.setContentType("application/json");
            PrintWriter pw = response.getWriter();
            pw.println("{\"error\":\"Ha sido imposible guardar los datos\"}");

        }
        processRequest(request, response);
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
