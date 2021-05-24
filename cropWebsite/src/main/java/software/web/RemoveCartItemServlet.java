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


@WebServlet("/removeCartItem")
public class RemoveCartItemServlet extends HttpServlet {

    RemoveCartItemDao rcid;
    HttpSession httpSession;

    public void init() {
        rcid = new RemoveCartItemDao();
    }

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