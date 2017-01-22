<%-- 
    Document   : welcomeForm
    Created on : Aug 29, 2016, 9:32:10 PM
    Author     : jlombardo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Welcome Form</title>
    </head>
    <body>
        <h2>Please enter your name</h2>
        <form id="helloForm" name="helloForm" method="POST" action="HelloController">
            
            <!--
                Note that the "name" attribute is a parameter key used in the
                servlet controller to retrieve the value of this input control
            -->
            Name:<input type="text" name="myName" value=""/><br>
            <input type="submit" name="submit" value="submit"/>
            
        </form>
        <p><a href="index.jsp">Back to  Home</a></p>
        <h1>Hello Response</h1>
        
        <!--
            In a JSP page you use this technique to use Java code (called a
            "Scriptlet") to dynamically modify the HTML in the page. This code
            is processed on the server BEFORE the html is rendered by your browser.
            Notice we have access to the request object which was forwarded to
            this page by the Controller.
        -->
        <%
           Object msgObj = request.getAttribute("msg");
           Object errObj = request.getAttribute("errMsg");
           String color = "blue";
           String msg = "";
           
           if(msgObj != null) {
               msg = msgObj.toString();
               
           } else if(errObj != null) {
               msg = errObj.toString();
               color = "red";
           }
           
           // Output html which gets added to the existing html in this position.
           out.println("<p style='color:" + color 
                   + ";font-weight:bold;'>" + msg + "</p>");

        %>
    </body>
</html>
