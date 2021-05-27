package software.web.products;

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
import software.web.products.database.ProductsDao;
import software.web.products.database.ProductData;


 /**
* The ProductsServlet retrives the products stored in the database and displays them in multiple pages 
* The User can navigate through these pages and is also given the option to sort the products based on the price or rating.
*
* @author  Ritwik Sinha
* @version 1.0
*/


@WebServlet("/productShowcase")
public class ProductsServlet extends HttpServlet {
    HttpSession httpSession;
    private ProductsDao pd;

    final static private int NUMPERPAGE = 3;

    public void init(){
        pd = new ProductsDao();
    }

    /**
    * This method is used to get the GET Request from the form in productdetails.jsp    
    * @param req
    *     This is a HttpServletRequest req from which we get the request info
    * @param res
    *     This is a HttpServletResponse res through which we send the response to a webpage
    * @return 
    *     The function is returning void.
    */
    public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {

        httpSession = req.getSession();
        String sortType = req.getParameter("sortType");
        int pageNumber = 1;

        if(req.getParameter("pageNo") != null){
            pageNumber = Integer.parseInt(req.getParameter("pageNo"));
        }

        int numProduct = pd.getTotalProductLength();
        int numPages =  (int)Math.ceil((double)numProduct / NUMPERPAGE);

        ProductData[] products = pd.getAllProductData(pageNumber, NUMPERPAGE);
 
        if(sortType != null){
            if(sortType.equals("byPrice")){
                ProductData.sortByPrice(products);
            }
            else if(sortType.equals("byRating")){
                ProductData.sortByRating(products);
            }
        }
        
        int numRows = (int)Math.ceil(products.length/4.0);
        
        httpSession.setAttribute("productsArray", products);
        httpSession.setAttribute("numPages", numPages);
        httpSession.setAttribute("numPerPage", NUMPERPAGE);
        httpSession.setAttribute("productLength", products.length);
        httpSession.setAttribute("pageNumber", pageNumber);
        
        httpSession.setAttribute("numRows", numRows);


        RequestDispatcher rd = req.getRequestDispatcher("products.jsp");
        rd.forward(req, res);
    }
}


