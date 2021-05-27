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

//Project imports
import software.web.index.database.CropData;
import software.web.cart.database.CartDao;

@WebServlet("/cart")
public class CartServlet extends HttpServlet{
    CartDao cd;
    HttpSession httpSession;

    /**
    * This method is a initializer function that is used to initialize the objects that we are going to use.
    * @param void
    *     There is no parameter in this method.
    * @return 
    *     The function returns a void.
    */
    public void init() {
        cd = new CartDao();
    }
    
    /**
    * This method is used to get the information that we are going to show in the cart.jsp page.
    * @param req
    *     This is a HttpServletRequest req from which we get the request info.
    * @param res
    *     This is a HttpServletResponse res through which we send the response to a webpage.
    * @return 
    *     The function is returning void.
    */
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        res.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
        res.setHeader("Pragma", "no-cache");
        res.setHeader("Expires", "0");
        
        httpSession = req.getSession();

        if(httpSession.getAttribute("userEmail") == null)
            res.sendRedirect("loginPage.jsp");

        String email = (String)httpSession.getAttribute("userEmail");
        ArrayList<CropData> cropData = cd.getCartData(email);        
        httpSession.setAttribute("cropData", cropData);

        RequestDispatcher rd = req.getRequestDispatcher("cart.jsp");
        rd.forward(req,res);
    }

}