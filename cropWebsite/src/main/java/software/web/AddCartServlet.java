 package software.web.cart;


import java.io.IOException;
import java.util.ArrayList;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.http.HttpSession;

import software.web.cart.database.AddCartDao;

@WebServlet("/addCart")
public class AddCartServlet extends HttpServlet{
    AddCartDao asd;
    HttpSession httpSession;
    
    public void init(){
        asd = new AddCartDao();
    }
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
        httpSession = req.getSession();

        if(httpSession.getAttribute("userEmail") == null){
            res.sendRedirect("loginPage.jsp");
        }else {
            String cID = req.getParameter("cropID");
            int quan = Integer.parseInt(req.getParameter("quantity"));
            String email = (String) httpSession.getAttribute("userEmail");

            asd.putProductToCart(cID, email, quan);
            res.sendRedirect("/product?CropID=" + cID);


        }
    }
}