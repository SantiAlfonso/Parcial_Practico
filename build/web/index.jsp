<%-- 
    Document   : index.jsp
    Created on : 27/09/2023, 5:05:08 a. m.
    Author     : Santiago199
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Captura Datos</title>
    </head>
    <body>
        <%@ page import="Controlador.recibeDatos" %>
        <h1>Hola! Proporciona tus datos:</h1>
        <form action="recibeDatos" method="post">
            <table cellspacing="3" cellpadding="3" border="1" >
                <tr>
                    <td align="right"> Nombre: </td>
                    <td><input type="text" name="nombre"></td>
                </tr>
                <tr>
                    <td align="right"> Apellidos: </td>
                    <td> <input type="text" name="apellidos"> </td>
                </tr>
                <tr>
                    <td align="right"> Promedio: </td>
                    <td> <input type="text" name="prom"> </td>
                </tr>
            </table>

            <input type="reset" value="Borrar">
            <input type="submit" value="Enviar">
        </form>
        
        <form action="alumnosRegistrados.jsp" method="post">
            <input type="submit" value="Ver alumnos">
        </form>
    </body>
</html>