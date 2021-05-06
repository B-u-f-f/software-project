package software.web.signup;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;

@WebServlet("/farmerSignUp") 
public class CustomerSignUpServlet extends HttpServlet throws ServletException, IOException {
    
    
    protected void doPost(HttpServletRequest req, HttpServletResponse res){
        
        String fname = req.getParameter("fname");
        String lname = req.getParameter("lname");
        int phoneNo = Integer.parseInt(req.getParameter("phNumber"));
        String email =  req.getParameter("farmer_email");
        String address = req.getParameter("address");
        String password = req.getParameter("password1");

        Date date = new Date();
        java.sql.Date timeNow = new Date(Calendar.getInstance().getTimeInMillis());

        farmerSignUpDao fsu = new farmerSignUpDao();

        try {

            fsu.putToCustomerDB(email, phoneNo, password, fname, lname, timeNow, address);
            res.sendRedirect("loginPage.jsp");

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}