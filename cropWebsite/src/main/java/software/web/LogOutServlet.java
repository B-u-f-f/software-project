package software.web.logout;

import java.io.IOException;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.http.HttpSession;

@WebServlet("/logout")
public class LogOutServlet extends HttpServlet{
    
    HttpSession httpSession;

    protected void service(HttpServletRequest req,HttpServletResponse res) throws IOException, ServletException{

        res.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
        res.setHeader("Pragma", "no-cache");
        res.setHeader("Expires", "0");

        httpSession = req.getSession();
        
        if(httpSession.getAttribute("userEmail") != null){
            httpSession.removeAttribute("userEmail");
            httpSession.invalidate();
        }

        res.sendRedirect("/index.jsp");    
    }

}



