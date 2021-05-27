package software.web.products;

import java.io.IOException;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.http.HttpSession;

//Project imports
import software.web.products.database.ProductDetailsDao;
import software.web.products.database.ProductData;

 /**
* The ProductDetailsServlet fetches the product data from the database using the getProductData method of the ProductsDao 
* and then passed to the Productdetails.jsp using a request dispatcher
*
* @author  Ritwik Sinha
* @version 1.0
*/


@WebServlet("/product")
public class ProductDetailsServlet extends HttpServlet {

    ProductDetailsDao pdd;
    HttpSession httpSession;

    /**
    * This method is a initializer function that is used to initialize the objects that we are going to use.
    * @param void
    *     There is no parameter in this method.
    * @return 
    *     The function returns a void.
    */
    public void init() {
        pdd = new ProductDetailsDao();
    }

    /**
    * This method is used to get the GET Request from the form in products.ksp.
    * @param req
    *     This is a HttpServletRequest req from which we get the request info.
    * @param res
    *     This is a HttpServletResponse res through which we send the response to a webpage.
    * @return 
    *     The function is returning void.
    */
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        String cropID = req.getParameter("CropID");
        ProductData pd = pdd.getProductData(cropID);

        httpSession = req.getSession();
        httpSession.setAttribute("productData", pd);

        RequestDispatcher rd = req.getRequestDispatcher("productdetails.jsp");
        rd.forward(req, res);
    }
}