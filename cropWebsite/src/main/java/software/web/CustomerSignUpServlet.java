package software.web.signup;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@WebServlet("/CustomerSignUp")
public class CustomerSignUpServlet extends HttpServlet throws ServletException, IOException{
   
    
    protected void doPost(HttpServletRequest req, HttpServletResponse res) {

        String email = request.getParameter("cust_email");
        String phone = request.getParameter("cust_phone");
		String pass = request.getParameter("password1");


        customerSignUpDao csu = new customerSignUpDao();

        try{

            csu.putToCustomerDB(email, phone, pass);
            res.sendRedirect("login.jsp");

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}