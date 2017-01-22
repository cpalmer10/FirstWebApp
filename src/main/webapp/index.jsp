<%-- 
    Document   : index
    Created on : Aug 29, 2016, 9:08:21 PM
    Author     : jlombardo
--%>

<%@page import="java.util.Date"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Welcome Service</title>
    </head>
    <!-- This is a comment -->
    <body>
        <h2>Instructions</h2>
        <p>Click on the link below to tell us your name</p>
        <p><a href="welcomeForm.jsp">Click here</a></p>
        <p><a href="HelloController?myName=Bob&age=5">Click here for QueryString version</a></p>
        <p>
            <%
                
                Date date = new Date();
                out.println(date);
            %>    
        </p>
    </body>
</html>
