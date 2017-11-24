<%-- 
    Document   : resultadobusqueda
    Created on : 24-nov-2017, 12:37:32
    Author     : luis
--%>

<%@page import="paqueteagenda.CrearHTML"%>
<%@page import="java.util.ArrayList"%>
<%@page import="paqueteagenda.Contacto"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
    ArrayList<Contacto> lista=(ArrayList<Contacto>)request.getAttribute("lista_contactos");
    String html_tabla=CrearHTML.crearTabla(lista);
    %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        <%=html_tabla%>
    </body>
</html>
