package software.web.signup;

import java.util.Date;
import java.text.SimpleDateFormat;
import java.io.IOException;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.ServletException;


import java.sql.SQLException;

//Project import
import software.web.signup.database.FarmerSignUpDao;

@WebServlet("/farmerSignUp") 
public class FarmerSignUpServlet extends HttpServlet  {
    
    
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
        
        String fname = req.getParameter("fname");
        String lname = req.getParameter("lname");
        String phoneNo = req.getParameter("phNumber");
        String email =  req.getParameter("farmer_email");
        String address = req.getParameter("address");
        String password = req.getParameter("password1");

        Date date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        String strDate = formatter.format(date);

        FarmerSignUpDao fsu = new FarmerSignUpDao();

        fsu.putToFarmerDB(email, phoneNo, password, fname, lname, strDate.toString(), address);
        res.sendRedirect("loginPage.jsp");

    }
}