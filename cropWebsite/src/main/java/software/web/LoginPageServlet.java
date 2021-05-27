package software.web.login;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import jakarta.servlet.ServletException;
import java.sql.SQLException;

//Project Import
import software.web.login.database.LoginPageDao;

@WebServlet("/loginPage") 
public class LoginPageServlet extends HttpServlet {

    HttpSession session;

    protected void doPost(HttpServletRequest req, HttpServletResponse res)  throws ServletException, IOException{
        session = req.getSession();

        if(session.getAttribute("userEmail") != null){
            res.sendRedirect("index.jsp");
        }


        String email = req.getParameter("user_email");
        String pass = req.getParameter("pass1");

        LoginPageDao lpd = new LoginPageDao();
        String userType = lpd.check(email, pass);
        
        if(userType != null) {
            session.setAttribute("userEmail", email);
            session.setAttribute("userType", userType);
            
            res.sendRedirect("index.jsp");
        } else {				
            res.sendRedirect("loginPage.jsp");			
        }

    }
}