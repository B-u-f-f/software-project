package software.web.signup;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/loginPage") 
public class loginPageServlet extends HttpServlet throws ServletException, IOException {

    protected void doPost(HttpServletRequest req, HttpServletResponse res) {

        String email = req.getParameter("user_email");
        String pass = req.getParameter("pass1");

        loginPageDao lpd = new loginPageDao();

        try {

            if(lpd.check(uname, pass)) {
				HttpSession session = request.getSession();
				session.setAttribute("userEmail", email);
				
				response.sendRedirect("index.jsp");
			} else {				
				response.sendRedirect("login.jsp");				
			}

        } catch(SQLException e) {
            e.printStackTrace();
        }

    }

}