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

@WebServlet("/productShowcase")
public class ProductsServlet extends HttpServlet {
    HttpSession httpSession;
    private ProductsDao pd;

    final static private int NUMPERPAGE = 3;

    public void init(){
        pd = new ProductsDao();
    }

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
        
        // System.out.println(numRows);
        // System.out.println(products.length);
        // System.out.println(numPages);

        httpSession.setAttribute("numRows", numRows);


        RequestDispatcher rd = req.getRequestDispatcher("products.jsp");
        rd.forward(req, res);
    }
}


