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


@WebServlet("/product")
public class ProductDetailsServlet extends HttpServlet {

    ProductDetailsDao pdd;
    HttpSession httpSession;

    public void init() {
        pdd = new ProductDetailsDao();
    }

    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        String cropID = req.getParameter("CropID");
        ProductData pd = pdd.getProductData(cropID);

        httpSession = req.getSession();
        httpSession.setAttribute("productData", pd);

        RequestDispatcher rd = req.getRequestDispatcher("productdetails.jsp");
        rd.forward(req, res);
    }
}