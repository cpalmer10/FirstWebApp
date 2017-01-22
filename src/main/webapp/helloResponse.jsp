<%-- 
    Document   : helloResponse
    Created on : Aug 31, 2016, 8:25:34 PM
    Author     : jlombardo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Hello Response</title>
    </head>
    <body>
        <h1>Hello Response</h1>

        <!--
            In a JSP page you use this technique to use Java code (called a
            "Scriptlet") to dynamically modify the HTML in the page. This code
            is processed on the server BEFORE the html is rendered by your browser.
            Notice we have access to the request object which was forwared to
            this page by the Controller.
        -->
        <%
           Object obj = request.getAttribute("msg");
           String msg = "Unknown";
           if(obj != null) {
               msg = obj.toString();
           }
           
           // Output html which gets added to the existing html in this position.
           out.println("<p style='color:blue;font-weight:bold;'>" + msg + "</p>");

        %>
    </body>
</html>
