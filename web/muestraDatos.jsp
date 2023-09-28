<%-- 
    Document   : muestraDatos.jsp
    Created on : 27/09/2023, 5:04:54 a. m.
    Author     : Santiago199
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type"
              content="text/html; charset=UTF-8">
        <link href="CSS/Mi_Estilo.css" rel="stylesheet" type="text/css">
        <title>Muestra Datos</title>
    </head>
    <body>
        <%@ page import="Modelo.Alumno" %>
        <%
        Alumno alumno = (Alumno) request.getAttribute("atribAlumn");
        %>

        <h3> MuestraDatos.jsp</h3>

        <p> Se guardaron los siguientes datos: </p>

        <table cellspacing="3" cellpadding="3" border="1" >
            <tr>
                <td align="right"> Nombre: </td>
                <td> <%= alumno.getNombre() %> </td> 
            </tr>
            <tr>
                <td align="right"> Apellidos: </td>
              <td> <%= alumno.getApellidos() %> </td> 
            </tr>
            <tr>
                <td align="right"> Promedio: </td>
                <td><%= alumno.getPromedio() %> </td>
            </tr>
        </table>

        <form action="index.jsp" method="post">
            <input type="submit" value="Regresar">
        </form>
    </body>
</html>