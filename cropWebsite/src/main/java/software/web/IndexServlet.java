package software.web.index;

import java.util.ArrayList;
import java.io.IOException;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

//Project imports
import software.web.index.database.IndexDao;
import software.web.index.database.CropData;

@WebServlet("/index.jsp")
public class IndexServlet extends HttpServlet {
    IndexDao id;

    public void init(){
        IndexDao id = new IndexDao();
    }

    protected void service(HttpServletRequest req, HttpServletResponse res)
    throws ServletException, IOException
    {
        //ArrayList<CropData> otherProducts = ;
        //Cookie otherProductsCookie = new Cookie("otherProductsCookie", otherProducts);

        try{
            id.getCropData();
        }
        catch(Exception e){
            System.out.println(e);
        }
        /*if( != null){
            for(CropData c : otherProducts){
                System.out.println(c.toString());
            }
        }else {
            System.out.println("asd");
        }*/

        //res.addCookie(otherProductsCookie);
        res.sendRedirect("home.jsp");
    }
}