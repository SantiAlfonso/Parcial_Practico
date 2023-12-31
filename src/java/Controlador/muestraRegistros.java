/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controlador;

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import static java.lang.System.out;
import Modelo.Alumno;
import Modelo.LeeArchivo;
import jakarta.servlet.ServletContext;
import java.util.ArrayList;

/**
 *
 * @author Santiago199
 */
@WebServlet(name = "muestraRegistros", urlPatterns = {"/muestraRegistro"})
public class muestraRegistros extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try {
            ArrayList<Alumno> alumnos = new ArrayList<Alumno>();
            int cont = 0;
            String contador;
            ServletContext sc = this.getServletContext();
            String path = sc.getRealPath("/WEB-INF/Promedios.txt");
            path = path.replace('\\', '/');
            alumnos = LeeArchivo.leeAlumnos(path);
            // Resetea la variable estática
            LeeArchivo.clearCont();
            cont = LeeArchivo.getCont();
            contador = String.valueOf(cont);

            request.setAttribute("Alumnos", alumnos);
            request.setAttribute("contador", contador);
            request.getRequestDispatcher("/alumnosRegistrados.jsp").forward(request, response);

        } finally {
            out.close();
        }
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
        processRequest(request, response);
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
