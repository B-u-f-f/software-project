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

 /**
* The CustomerSignUpServlet uses putToCustomerDB to pass the email id, phone and passwordto the database
* @author  Ritwik Sinha
* @version 1.0
*/

@WebServlet("/CustomerSignUp")
public class CustomerSignUpServlet extends HttpServlet {
    CustomerSignUpDao csu;

    /**
    * This method is a initializer function that is used to initialize the objects that we are going to use.
    * @param void
    *     There is no parameter in this method.
    * @return 
    *     The function returns a void.
    */
    public void init() {
        csu = new CustomerSignUpDao();
    }
    
    /**
    * This method is used to get the form data using the post method in the customerSignUp.jsp page and redirecting to the loginPage.
    * @param req
    *     This is a HttpServletRequest req from which we get the request info.
    * @param res
    *     This is a HttpServletResponse res through which we send the response to a webpage.
    * @return 
    *     The function is returning void.
    */
    protected void doPost(HttpServletRequest req, HttpServletResponse res) 
    throws ServletException, IOException {

        String email = req.getParameter("cust_email");
        String phone = req.getParameter("cust_phone");
		String pass = req.getParameter("password1");
        csu.putToCustomerDB(email, phone, pass);
        res.sendRedirect("loginPage.jsp");
    }
}