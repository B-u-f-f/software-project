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

        <div class="container">
            <div class="navbar">
                <div class="logo">
                    <img src="images/cs.PNG" width="165px">
                </div>
                <nav>
                    <ul id="MenuItems">
                        <li><a href="">Home</a></li>
                        <li><a href="">Products</a></li>
                        <li><a href="">About</a></li>
                        <li><a href="">Contact</a></li>
                        <li><a href="">Account</a></li>
                    </ul>
                </nav>
                <img src="images/images/cart.png" width="30px" height="30px">
                <img src="images/images/menu.png" class="menu-icon" onclick="menutoggle()">
            </div>
        </div>


        <!--single product details-->

        <div class="small-container single-product">
            <div class="row">
                <div class="col-2">
                    <c:set var = "imageList" value = "${data.getImages()}" />
                    <c:set var="img_src" value="" />
                    <c:set var="img_src" value = "${imageList.get(0)}"/>
                    <img src="${img_src}" width="60%" id="productimg">
                

                    <div class="small-img-row">
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
                        <input type="hidden" name="cropID" value="${sessionScope.cropID}">
                        <input type="number" name="quantity" value="5">
                        <input type="submit" value="Add to Cart">
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


        <div class="small-container">
            <div class="row row-2">
                <h2>Related Products</h2>
                <p>View More</p>
            </div>
        </div>


        <div class="small-container">
            <div class="row">
                <div class="col-4">
                    <img src="images/pro10.PNG">
                    <h4>Brinjal</h4>
                    <div class="rating">
                        <i class="fa fa-star"></i>
                        <i class="fa fa-star"></i>
                        <i class="fa fa-star"></i>
                        <i class="fa fa-star"></i>
                        <i class="fa fa-star-half-o"></i>
                    </div>
                    <p>21.00 &#8377;/kg </p>
                </div>
                <div class="col-4">
                    <img src="images/pro11.PNG">
                    <h4>Pulses</h4>
                    <div class="rating">
                        <i class="fa fa-star"></i>
                        <i class="fa fa-star"></i>
                        <i class="fa fa-star"></i>
                        <i class="fa fa-star"></i>
                        <i class="fa fa-star-o"></i>
                    </div>
                    <p>29.00-120 &#8377;/kg </p>
                </div>
                <div class="col-4">
                    <img src="images/pro12.PNG">
                    <h4>Cotton</h4>
                    <div class="rating">
                        <i class="fa fa-star"></i>
                        <i class="fa fa-star"></i>
                        <i class="fa fa-star"></i>
                        <i class="fa fa-star"></i>
                        <i class="fa fa-star-half-o"></i>
                    </div>
                    <p>700.00 &#8377;/kg </p>
                </div>
                <div class="col-4">
                    <img src="images/pro1.PNG">
                    <h4>Moong dal</h4>
                    <div class="rating">
                        <i class="fa fa-star"></i>
                        <i class="fa fa-star"></i>
                        <i class="fa fa-star"></i>
                        <i class="fa fa-star-half-o"></i>
                        <i class="fa fa-star-o"></i>
                    </div>
                    <p>165.00 &#8377;/kg </p>
                </div>
            </div>
        </div>
    </div>




    <!--footer-->

        <div class="footer">
            <div class="container">
                <div class="row">
                    <div class="footer-col-1">
                        <h3>Download our App</h3>
                        <p>Download App for Android and Ios mobile phone.</p>
                        <div class="app-logo">
                            <img src="images/play-store.png">
                            <img src="images/app-store.png">
                        </div>
                    </div>
                    <div class="footer-col-2">
                        <img src="images/cs.PNG">
                        <p>Our purpose is to connect farmers directly to the people</p>
                    </div>
                    <div class="footer-col-3">
                        <h3>Useful links</h3>
                        <ul>
                            <li>Coupons</li>
                            <li>Blog Post</li>
                            <li>Return policy</li>
                            <li>Join Affiliate</li>
                        </ul>
                    </div>
                    <div class="footer-col-4">
                        <h3>Follow us</h3>
                        <ul>
                            <li>Facebook</li>
                            <li>Twitter</li>
                            <li>Instagram</li>
                            <li>YouTube</li>
                        </ul>
                    </div>
                </div>
                <hr>
                <p class="copy-right">Copyright 2020</p>
            </div>
        </div>


        
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