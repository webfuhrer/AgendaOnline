<%-- 
    Document   : listar_contactos
    Created on : 24-nov-2017, 12:01:16
    Author     : luis
--%>

<%@page import="paqueteagenda.CrearHTML"%>
<%@page import="java.util.ArrayList"%>
<%@page import="paqueteagenda.Contacto"%>
<%@page import="paqueteagenda.AccesoBD"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    ArrayList<Contacto> lista=AccesoBD.devolverContactos();
    String html_tabla=CrearHTML.crearTabla(lista);
    %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Lista de contactos:</h1>
        <%=html_tabla%>
    </body>
</html>
