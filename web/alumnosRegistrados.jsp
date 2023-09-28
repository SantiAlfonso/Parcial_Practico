<%-- 
    Document   : alumnosRegistrados.jsp
    Created on : 27/09/2023, 5:05:40 a. m.
    Author     : Santiago199
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type"
              content="text/html; charset=UTF-8">
        <link href="CSS/Mi_Estilo.css" rel="stylesheet" type="text/css">
        <title>Alumnos Registrados</title>
    </head>
    <body>
        <%@ page import="Modelo.Alumno, java.util.ArrayList" %>
        <h2>Los alumnos que están registrados son: </h2>
        <%
        ArrayList<Alumno> alumnos = null;
        alumnos =
        (ArrayList<Alumno>)request.getAttribute("Alumnos");
        String numReg= (String) request.getAttribute("contador");
        int numRegistros = Integer.parseInt(numReg);%>
        <table border="1">
            <tr>
                <th>Nombre</th>
                <th>Apellidos</th>
                <th>Promedio</th>
            </tr>
            <%
            for (Alumno alumno: alumnos)
            {
            %>
            <tr valign="top">
                <td><%=alumno.getNombre() %></td>
                <td><%=alumno.getApellidos() %></td>
                <td><%=alumno.getPromedio() %></td>

            </tr>

            <% } %>
            <% alumnos.clear();%>
        </table>
        <p> Numero de registros : <%= numRegistros %></p>
        <br>
        <form action="index.jsp" method="post">
            <input class="button" type="submit" value="Regresar">
        </form>

    </body>
</html>
