package hello.servlet.basic.reponse;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "responseHeaderServlet", urlPatterns = "/response-header")
public class ResponseHeaderServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //[STATUS-LINE]
        response.setStatus(HttpServletResponse.SC_OK);

        //[RESPONSE-HEADERS]
        //response.setHeader("Content-Type", "text/plain;charset=utf-8");
        content(response);
        cookie(response);
        redirect(response);

        response.setHeader("Cache-control", "no-cache, no-store, must-revalidate");
        response.setHeader("Pragma", "no-cache");
        response.setHeader("my-header", "hello");


        PrintWriter writer = response.getWriter();
        writer.write("ok");
    }

    //Header Utility Methods
    private void content(HttpServletResponse response) {
        //Content-Type: text/plain;charset=uft-8
        //Content-Length: 2
        response.setContentType("text/plain");
        response.setCharacterEncoding("utf-8");
        //response.setContentLength(2) (automatically created when if it's not declared)
    }

    private void cookie(HttpServletResponse response) {
        //Set-Cookie: myCookie=good; Max-Age:600;
        //response.setHeader("Set-Cookie", "myCookie=good; Max-Age=600");
        Cookie cookie = new Cookie("myCookie", "good");
        cookie.setMaxAge(600); //600sec
        response.addCookie(cookie);
    }


    private void redirect(HttpServletResponse response) throws IOException {
        //Status code 302
        //Location: /basic/hello-form.html
        //response.setStatus(HttpServletResponse.SC_FOUND);
        //response.setHeader("Location", "/basic/hello-form.html");
        response.sendRedirect("/basic/hello-form.html");
    }
}
