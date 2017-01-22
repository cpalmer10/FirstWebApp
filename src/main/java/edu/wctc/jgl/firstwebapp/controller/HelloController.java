package edu.wctc.jgl.firstwebapp.controller;

import edu.wctc.jgl.firstwebapp.model.HelloService;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * An HttpServlet acts as a controller in MVC. It's only job is to control
 * the flow of data to and from the VIEW and MODEL. No business logic should
 * be performed here. A java web app will typically have more than one
 * controller ... remember ... Single Responsibility Principle! You can even
 * have sub-controllers, where one controller delegates to others, for even
 * finer grained control.
 * 
 * Also, notice that the class is annotated with @WebServlet. This is a shortcut
 * that became available in JEE v6 and removes the need for configuration in
 * <app name>/WEB-INF/web.xml. However, that option is useful and will be
 * demonstrated later.
 * 
 * @author jlombardo
 */
@WebServlet(name = "HelloController", urlPatterns = {"/HelloController"})
public class HelloController extends HttpServlet {
    /*
       Always remember that Servlets are Singletons. For every request that
       comes in a separate thread is created by the app server to process
       that request using the methods below. But since this is a Singleton
       all classs and instance properties are global, whether they are
       declared static of not. So they are not thread safe. The same is true
       for methods. To make code in a method thread safe you must use the
       synchronized keyword.
    */
    
    // Here is an example of a instance property that is NOT thread safe.
    // Because this servlet is a Singleton there is only one object with only
    // one copy of this property ... shared by all request threads. If two or
    // more threads try to modify this property there will either be a
    // collision or data will be in an inconsistent state between requests.
    // To solve this you must make this work atomically. Examples to come later.
    // For now, don't use ANY properties that are not thread safe.
    private int requestCount = 0;


    // Avoid magic numbers by using lots of constants for string values
    // Because these are constants they are thread safe.
    private static final String WELCOME_FORM = "/welcomeForm.jsp";
    private static final String HELLO_RESPONSE = "/helloResponse.jsp";
    
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods. This method is NOT inherited from HttpServlet. It is a custom
     * method that Netbeans creates as a convenience to the programmer, 
     * eliminating the need to write controller code in both the doGet() and
     * doPost() methods below. Instead, those methods delegate to this method.
     * This may not be appropriate for all situations. Sometimes you may want
     * to perform different operations in doGet() vs doPost(). In that case,
     * you would not use this method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        // defaults are text/html and ISO-8859-1
        // should always use this...
        response.setContentType("text/html;charset=UTF-8");
        
        // Set a default destination
        String destination = HELLO_RESPONSE;
        
        // Always catch exceptions and forward error messages to the VIEW.
        try {
            // Works for QueryString parameters and form parameters. Parameters
            // are read-only (not setter method).
            String name = request.getParameter("myName");

            // This is the right thing to do ... delegate to a model object
            // to do the data processing.
            HelloService service = new HelloService();
            String responseMsg = service.sayHello(name);

            // Any data that needs to go to the VIEW can be stored in the
            // request object and retrieved by a JSP page (or another controller)
            // You can only set attributes. Parameters are read-only.
            request.setAttribute("msg", responseMsg);
            
        } catch (Exception e) {
            destination = WELCOME_FORM;
            request.setAttribute("errMsg", e.getMessage());
        }
        
        // To send any data to the VIEW you must use this to forward the
        // request object, which contains the data, to the destination. The
        // destination can be a JSP or another Controller, but cannot be an html page.
        RequestDispatcher view =
                request.getRequestDispatcher(destination);
        view.forward(request, response);
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method. Typically this happens when
     * you request a URL with a set of QueryString parameters. For example:
     * 
     * http://localhost:8080/FirstWebApp/HelloController?myName=Bob
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // if we use the next line we don't need any other code here!
        //processRequest(request, response);
        
        // defaults are text/html and ISO-8859-1
        // should always use this...
        response.setContentType("text/html;charset=UTF-8");

        // set a default
        String destination = HELLO_RESPONSE;
        
        // Always catch exceptions and forward error messages to the VIEW.
        try {
            // Works for QueryString parameters and form parameters. Parameters
            // are read-only (not setter method).
            String name = request.getParameter("myName");

            // This is the right thing to do ... delegate to a model object
            // to do the data processing.
            HelloService service = new HelloService();
            String responseMsg = service.sayHello(name);

            // Any data that needs to go to the VIEW can be stored in the
            // request object and retrieved by a JSP page (or another controller)
            // You can only set attributes. Parameters are read-only.
            request.setAttribute("msg", responseMsg);
            
        } catch (Exception e) {
            destination = WELCOME_FORM;
            request.setAttribute("errMsg", e.getMessage());
        }
        
        // To send any data to the VIEW you must use this to forward the
        // request object, which contains the data, to the destination. The
        // destination can be a JSP or another Controller, but cannot be an html page.
        RequestDispatcher view =
                request.getRequestDispatcher(destination);
        view.forward(request, response);
        
    }

    /**
     * Handles the HTTP <code>POST</code> method. Typically this happens 
     * when you submit a form.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // if we use the next line we don't need any other code here!
        //processRequest(request, response);
        
        // defaults are text/html and ISO-8859-1
        // should always use this...
        response.setContentType("text/html;charset=UTF-8");

        // Set a default
        String destination = HELLO_RESPONSE;
        
        // Always catch exceptions and forward error messages to the VIEW.
        try {
            // Works for QueryString parameters and form parameters. Parameters
            // are read-only (not setter method).
            String name = request.getParameter("myName");


            // This violates the role of the controller. Here we are doing
            // some simple business logic (data processing). That is the job
            // for a MODEL object. The Controller should only direct data flow
            // between VIEW and MODEL.
            String responseMsg = "Hello " + name + " isn't Java Web Development Great!";
              
            // Any data that needs to go to the VIEW can be stored in the
            // request object and retrieved by a JSP page (or another controller)
            // You can only set attributes. Parameters are read-only.
            request.setAttribute("msg", responseMsg);
            
        } catch (Exception e) {
            destination = WELCOME_FORM;
            request.setAttribute("errMsg", e.getMessage());
        }
        
        // To send any data to the VIEW you must use this to forward the
        // request object, which contains the data, to the destination. The
        // destination can be a JSP or another Controller, but cannot be an html page.
        RequestDispatcher view =
                request.getRequestDispatcher(destination);
        view.forward(request, response);
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
