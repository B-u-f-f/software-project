package software.web.index;

import java.util.ArrayList;
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
import software.web.index.database.IndexDao;
import software.web.index.database.CropData;

@WebServlet("/index.jsp")
public class IndexServlet extends HttpServlet {
    IndexDao id;
    HttpSession httpSession;

    public void init(){
        id = new IndexDao();
    }

    protected void service(HttpServletRequest req, HttpServletResponse res)
    throws ServletException, IOException
    {
        ArrayList<CropData> otherProducts1 = id.getCropData();
        ArrayList<CropData> otherProducts2 = new ArrayList<CropData>();

        if(otherProducts1.size() < 8) {
            for(int i = otherProducts1.size(); i < 8; i++) {
                otherProducts1.add(CropData.returnEmptyCropData());
            }
        }

        for(int i = 4; i < 8; i++) {
            otherProducts2.add(otherProducts1.get(4));
            otherProducts1.remove(4);
        }
        
        ArrayList<CropData> featuredProducts = id.getFeaturedCropData();

        if(featuredProducts.size() < 4){
            for(int i = featuredProducts.size(); i < 4; i++){
                featuredProducts.add(CropData.returnEmptyCropData());
            }
        }
        
        String seasonalCrop[] = id.getSeasonalCrop();
        httpSession = req.getSession();

        httpSession.setAttribute("otherProductsRowOne", otherProducts1);
        httpSession.setAttribute("otherProductsRowTwo", otherProducts2);
        httpSession.setAttribute("featuredProducts", featuredProducts);
        httpSession.setAttribute("seasonalName", seasonalCrop[0]);
        httpSession.setAttribute("seasonalImage", seasonalCrop[1]);
        httpSession.setAttribute("seasonalCropID", seasonalCrop[2]);

        RequestDispatcher rd = req.getRequestDispatcher("home.jsp");
        rd.forward(req, res);        
    }
}