package software.web.cart.remove;

import java.io.IOException;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.http.HttpSession;

//Project imports
import software.web.cart.database.RemoveCartItemDao;

 /**
* The RemoveCartItemServlet calls the function "removeItemCart" of the RemoveCartItemDao and upon successful completion shows the user the updated cart
* If user is not logged into the system he will be redirected to the homepage else he will be shown the updated cart
*
* @author  Ritwik Sinha
* @version 1.0
*/


@WebServlet("/removeCartItem")
public class RemoveCartItemServlet extends HttpServlet {

    RemoveCartItemDao rcid;
    HttpSession httpSession;

    /**
    * This method is a initializer function that is used to initialize the objects that we are going to use.
    * @param void
    *     There is no parameter in this method.
    * @return 
    *     The function returns a void.
    */
    public void init() {
        rcid = new RemoveCartItemDao();
    }

    /**
    * This method is used to get the GET Request from the form in cart.jsp.
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

        if(httpSession.getAttribute("userEmail") != null){    
            String cropID = req.getParameter("CropID");
            String emailID = (String) httpSession.getAttribute("userEmail");
        
            rcid.removeItemCart(cropID, emailID);
            res.sendRedirect("/cart");
        }
        else {
            res.sendRedirect("/index.jsp");   
        }
    }
}