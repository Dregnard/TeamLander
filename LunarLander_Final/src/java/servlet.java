


import clases.Staff;
import com.google.gson.Gson;
import com.google.gson.JsonIOException;
import com.google.gson.JsonSyntaxException;
import com.google.gson.reflect.TypeToken;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.RandomAccessFile;
import java.io.StringWriter;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.bind.JAXB;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import java.io.FileReader;
import java.lang.reflect.Type;
import java.util.Collection;
import java.util.List;

/**
 *
 * @author dam2a26
 */

public class servlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            //Archivo donde está la config
            ServletContext context = getServletContext();
            String fullPath = context.getRealPath("/json/j.json");
            //Convertimos el fichero json a objeto con gson
            Gson gson = new Gson();

            Type listType = new TypeToken<List<Staff>>() {
            }.getType();

            List<Staff> objList = new Gson().fromJson(new FileReader(fullPath), listType);
//Convertimos el objeto en String
            String jsonInString = gson.toJson(objList);// a String

//Devolvemos al cliente el string del json
            response.setContentType("application/json");
            PrintWriter pw = response.getWriter();
            pw.println(jsonInString);

        } catch (Exception e) {

            response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            response.setContentType("application/json");
            PrintWriter pw = response.getWriter();
            pw.println("{\"error\":\"Error al cargar Configuraciones\"}");

        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            String nombre = request.getParameter("nombre");
            String dificultad = request.getParameter("dificultad");
            String modeloLuna = request.getParameter("modeloLuna");
            String modeloNave = request.getParameter("modeloNave");

            ServletContext context = getServletContext();
            String fullPath = context.getRealPath("/json/j.json");

            //Convertimos el fichero json a objeto con gson
            Gson gson = new Gson();

            //Configuraciones configs = gson.fromJson(new FileReader(fullPath), Configuraciones.class);
            Type listType = new TypeToken<List<Staff>>() {
            }.getType();

            List<Staff> configs = new Gson().fromJson(new FileReader(fullPath), listType);
            Staff c = new Staff();
            //Creamos el objeto configuracion con la configuración que nos llega
            //Configuraciones.Configuracion c = new Configuraciones.Configuracion();
            //c.setNombre(nombre);
            
            c.setNombre(nombre);
            c.setDificultad(dificultad);
            c.setModeloLuna(modeloLuna);
            c.setModeloNave(modeloNave);

            //Añadimos la configuración nueva al objeto fichero configuraciones que hemos parseado antes.
            configs.add(c);

            //Volvemos a convertir el objeto a fihero json
            //gson.toJson(configs,new FileWriter(fullPath));
//            String jsonInString = gson.toJson(configs);
            File f = new File(fullPath);
            FileWriter fw = new FileWriter(f);

            gson.toJson(configs, fw);
            fw.close();

            response.setContentType("application/json");
            PrintWriter pw = response.getWriter();
            pw.println("{\"mess\":\"Se ha guardado correctamente\"}");

        } catch (JsonIOException e) {
            response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            response.setContentType("application/json");
            PrintWriter pw = response.getWriter();
            pw.println("{\"error\":\"Error al guardar la configuración del juego\"}");
        } catch (JsonSyntaxException e) {
            response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            response.setContentType("application/json");
            PrintWriter pw = response.getWriter();
            pw.println("{\"error\":\"Error JSONSYNTAXEXCEPTION\"}");
        } catch (IOException e) {
            response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            response.setContentType("application/json");
            PrintWriter pw = response.getWriter();
            pw.println("{\"error\":\"Error IO Exception\"}");
        }
    }

}
