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
import Modelo.*;
import Modelo.EscribeArchivo;
import jakarta.servlet.ServletContext;

/**
 *
 * @author Santiago199
 */
@WebServlet(name = "recibeDatos", urlPatterns = {"/recibeDatos"})
public class recibeDatos extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        try {
            String nombre = request.getParameter("nombre");
            String apellidos = request.getParameter("apellidos");
            Double promedio = Double.parseDouble(request.getParameter("promedio"));

            Alumno alumno = new Alumno(nombre, apellidos, promedio);
            ServletContext sc = this.getServletContext();
            String path = sc.getRealPath("/WEB-INF/Promedios.txt");
            path = path.replace('\\', '/');

            // Guardar en archivo
            EscribeArchivo.add(alumno, path);
            request.setAttribute("atribAlumn", alumno);
            request.getRequestDispatcher("/muestraDatos.jsp")
                    .forward(request, response);
        } finally {
            out.close();
        }

    }

    @Override
    protected void doPost(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

}
