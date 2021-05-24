<%@ page language="java" contentType="text/html" pageEncoding="UTF-8" errorPage="error.jsp" isELIgnored="false"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page import = "software.web.products.database.ProductData" %>
<%@ page import = "software.web.products.database.Category" %>
<%@ page import = "java.util.ArrayList" %>

<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <title>Productdetails</title>
        <link rel="stylesheet" href="style.css">
        <!-- <link rel="stylesheet" href="<link rel="preconnect" href="https://fonts.gstatic.com"> -->
        <link rel="preconnect" href="https://fonts.gstatic.com">
        <link href="https://fonts.googleapis.com/css2?family=Poppins:wght@300;400;500;600;700&display=swap" rel="stylesheet">">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
    </head>
    <body>
        <c:set var="sessionScope" value="${request.getSession()}" /> 
        <c:set var="data" value="${sessionScope.productData}" />

        <%@ include file="header.jsp" %>


        <!--single product details-->

        <div class="small-container single-product">
            <div class="row">
                <div class="col-2" style="width: 60%;">
                    <c:set var = "imageList" value = "${data.getImages()}" />
                    <c:set var="img_src" value="" />
                    <c:set var="img_src" value = "${imageList.get(0)}"/>
                    <img src="${img_src}" id="productimg" width="250px" height="250px">
                

                    <div class="small-img-row" style="width: 150px; height: 150px;">
                        <c:if test = "${imageList.size() > 1}">
                            <c:forEach var="i" begin="1" end="${imageList.size() - 1}" step="1">
                                <img src="${imageList.get(i)}" width="100%" class="small-img">
                            </c:forEach>
                            <div class="small-img-col">
                            </div>
                        </c:if>
        
                    </div>



                </div>
                <div class="col-2">
                    <h1>${data.getCropName()}</h1>
                    <h4>${data.getPrice()} &#8377;/kg</h4> 
                    
                    <form action="addCart" method="POST">
                        <input type="hidden" name="cropID" value="${data.getCropID()}">
                        <input style="width: 100px;" type="number" name="quantity" value="5">
                        <input type="submit" class="btn" value="Add to Cart">
                    </form>
                
               
                    <!-- <a href="" class="btn">Add to cart</a> -->
                    <h3>Product Details <i class="fa fa-indent"></i></h3>
                    <br>
                    <p>Production Date: ${data.getProductionDate()}</p>
                    <p>Expiration Date: ${data.getExpirationDate()}</p>
                    <p>Max Quantities: ${data.getMaxQuantity()}</p>
                    <c:set var="catList" value="${data.getCategories()}"/>
                    <c:forEach items="${catList}" var="catItem">
                        <p>${catItem.getCategoryType()} ${catItem.getValue()}</p>
                    </c:forEach>
                </div>
            </div>
        </div>
    </div>




    <!--footer-->
    <%@ include file="footer.jsp" %>

        
    <!--js for toggle menu-->

    <script>
        var MenuItems = document.getElementById("MenuItems");

        MenuItems.style.maxHeight="0px";

        function menutoggle(){
            if(MenuItems.style.maxHeight == "0px")
            {
                MenuItems.style.maxHeight = "200px";
            }
        else{
            MenuItems.style.maxHeight = "0px";
        }
        }
    </script>

    <!-----------js for product gallery------->

    <script>
        var productimg = document.getElementById("productimg");
        var smallimg = document.getElementById("small-img")

        smallimg[0].onclick = function(){
            productimg.src = smallimg[0].src;
        }

        smallimg[1].onclick = function(){
            productimg.src = smallimg[1].src;
        }

        smallimg[2].onclick = function(){
            productimg.src = smallimg[2].src;
        }

        smallimg[3].onclick = function(){
            productimg.src = smallimg[3].src;
        }

    </script>

    </body>
</html>