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


 /**
* The AddCardServlet calls the putProductToCart method of the AddCardServletDao 
* Here we also check whether using is logged in to the session.  
* If no, the user will be redirected to the login page else he will be shown the product he is about to add to card 
*
* @author  Ritwik Sinha
* @version 1.0
*/

@WebServlet("/addCart")
public class AddCartServlet extends HttpServlet{
    AddCartDao asd;
    HttpSession httpSession;
    
    /**
    * This method is a initializer function that is used to initialize the objects that we are going to use.
    * @param void
    *     There is no parameter in this method.
    * @return 
    *     The function returns a void.
    */
    public void init(){
        asd = new AddCartDao();
    }

    /**
    * This method is used to get the form data using the post method in the products.jsp page.
    * @param req
    *     This is a HttpServletRequest req from which we get the request info.
    * @param res
    *     This is a HttpServletResponse res through which we send the response to a webpage.
    * @return 
    *     The function is returning void.
    */
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