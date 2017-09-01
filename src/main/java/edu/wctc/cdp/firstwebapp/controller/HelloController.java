package edu.wctc.cdp.firstwebapp.controller;

import edu.wctc.cdp.firstwebapp.model.HelloService;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(name = "HelloController", urlPatterns = {"/HelloController"})
public class HelloController extends HttpServlet {
    
    private int requestCount = 0;
    
    private static final String WELCOME_FORM = "/welcomeForm.jsp";
    private static final String HELLO_RESPONSE = "/helloResponse.jsp";
    

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        response.setContentType("text/html;charset=UTF-8");
        
        String destination = HELLO_RESPONSE;
               
        try {                
            String name = request.getParameter("myName");                       
            HelloService service = new HelloService();
            String responseMsg = service.sayHello(name);

            request.setAttribute("msg", responseMsg);
            
        } catch (Exception e) {
            destination = WELCOME_FORM;
            request.setAttribute("errMsg", e.getMessage());
        }
        
        RequestDispatcher view =
                request.getRequestDispatcher(destination);
        view.forward(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // if we use the next line we don't need any other code here!
        //processRequest(request, response);
              
        response.setContentType("text/html;charset=UTF-8");
        
        String destination = HELLO_RESPONSE;
        
        try {                  
            String name = request.getParameter("myName");                      
            HelloService service = new HelloService();
            String responseMsg = service.sayHello(name);
                                    
            request.setAttribute("msg", responseMsg);
            
        } catch (Exception e) {
            destination = WELCOME_FORM;
            request.setAttribute("errMsg", e.getMessage());
        }
        
        RequestDispatcher view =
                request.getRequestDispatcher(destination);
        view.forward(request, response);
        
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // if we use the next line we don't need any other code here!
        //processRequest(request, response);
                
        response.setContentType("text/html;charset=UTF-8");
        
        String destination = HELLO_RESPONSE;
        
        try {                
            String name = request.getParameter("myName");           
            String responseMsg = "Hello " + name + ", isn't Java Web Development Great!";
            
            request.setAttribute("msg", responseMsg);
            
        } catch (Exception e) {
            destination = WELCOME_FORM;
            request.setAttribute("errMsg", e.getMessage());
        }
        
        RequestDispatcher view =
                request.getRequestDispatcher(destination);
        view.forward(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
