package software.web.signup;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import jakarta.servlet.ServletException;
import java.sql.SQLException;

//Project import
import software.web.signup.database.CustomerSignUpDao;

@WebServlet("/CustomerSignUp")
public class CustomerSignUpServlet extends HttpServlet {
    CustomerSignUpDao csu;

    public void init() {
        csu = new CustomerSignUpDao();
    }
    
    protected void doPost(HttpServletRequest req, HttpServletResponse res) 
    throws ServletException, IOException {

        String email = req.getParameter("cust_email");
        String phone = req.getParameter("cust_phone");
		String pass = req.getParameter("password1");
        csu.putToCustomerDB(email, phone, pass);
        res.sendRedirect("loginPage.jsp");
    }
}