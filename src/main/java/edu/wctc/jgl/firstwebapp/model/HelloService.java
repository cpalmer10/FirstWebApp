package edu.wctc.jgl.firstwebapp.model;

/**
 * The "model" in MVC is where the "business logic" is written. Business logic 
 * is the code that does the work (it's business) of the application. This class
 * is a very simple hello service. Service classes are the facades of the
 * model package, often delegating work to many other classes in this layer.
 * 
 * @author jlombardo
 */
public class HelloService {
    
    public String sayHello(String name) {
        if(name == null || name.isEmpty()) {
            throw new IllegalArgumentException("name is mandatory");
        }
        return "Hello " + name + ", isn't Java Web Development great!";
    }
}
