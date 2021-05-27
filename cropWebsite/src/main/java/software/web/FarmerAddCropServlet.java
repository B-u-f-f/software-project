package software.web.farmercrop;

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

//Project import
import software.web.farmercrop.database.FarmerAddCropDao;

@WebServlet("/farmerAddCrop")
public class FarmerAddCropServlet extends HttpServlet {
    HttpSession httpSession;
    FarmerAddCropDao fad;

    /**
    * This method is used to get the form data using the post method in the FarmerAddCrop.jsp page and then redirecting to the index.jsp page.
    * @param req
    *     This is a HttpServletRequest req from which we get the request info.
    * @param res
    *     This is a HttpServletResponse res through which we send the response to a webpage.
    * @return 
    *     The function is returning void.
    */
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        res.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
        res.setHeader("Pragma", "no-cache");
        res.setHeader("Expires", "0");


        httpSession = req.getSession();
        fad = new FarmerAddCropDao();

        if(httpSession.getAttribute("userEmail") == null){
            res.sendRedirect("/loginPage");
        } else if (!httpSession.getAttribute("userType").equals("Farmer")){
            res.sendRedirect("index.jsp");
        }
        
        String cropName = req.getParameter("cropName");
        int quantity = Integer.parseInt(req.getParameter("quantity"));
        String productionDate = req.getParameter("productionDate");
        String expirationDate = req.getParameter("expirationDate"); //optional
        int price = Integer.parseInt(req.getParameter("price"));
        String cropType = req.getParameter("type");
        String season = req.getParameter("season");

        ArrayList<String> images = new ArrayList<String>();
        images.add(req.getParameter("image1"));
        String tmp;
        for(int i = 2; i <= 4; i++){
            tmp = req.getParameter("image" + i);
            if(tmp != null && !tmp.equals("")){
                images.add(tmp);
            }
        }
        
        if(expirationDate == null){
            expirationDate = "2021-05-08";
        }
        
        String email = (String) httpSession.getAttribute("userEmail");
        fad.addCrop(cropName, quantity, productionDate, expirationDate, price, cropType, season, images, email);

        res.sendRedirect("index.jsp");
        
    

    }
}