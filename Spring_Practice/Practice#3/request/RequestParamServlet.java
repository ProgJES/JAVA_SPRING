package hello.servlet.request;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/*
* 1. Passing parameters
* http://localhost:8080/request-param?username=kim&age=20
* */
@WebServlet(name = "requestParamServlet", urlPatterns = "/request-param")
public class RequestParamServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        System.out.println("[Prints all parameters] - start");

        //paraName is the key, so to print out the value from the list, put key into request.getParameter(key) username & age = key
        request.getParameterNames().asIterator()
                        .forEachRemaining(paramName -> System.out.println(paramName + "=" + request.getParameter(paramName)));

        System.out.println("[Prints all parameters] - end");

        System.out.println("[Prints a parameter] - start");

        String name = request.getParameter("username");
        String age = request.getParameter("age");

        System.out.println("age = " + age);
        System.out.println("name = " + name);

        System.out.println("[Prints a parameter] - end");

        System.out.println("[Prints parameters that have same key name] - start");
        String[] names = request.getParameterValues("username");
        for (String nameValue : names) {
            System.out.println("nameValue = " + nameValue);
        }
        System.out.println("[Prints parameters that have same key name] - end");

        response.getWriter().write("ok ");

    }
}
