<%@ page language="java" contentType="text/html" pageEncoding="UTF-8" errorPage="error.jsp" isELIgnored="false"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page import = "software.web.index.database.CropData" %>
<%@ page import = "java.util.ArrayList" %>

<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <title>Main</title>
        <link rel="stylesheet" href="style.css">
        <!-- <link rel="stylesheet" href="<link rel="preconnect" href="https://fonts.gstatic.com"> -->
        <link rel="preconnect" href="https://fonts.gstatic.com">
        <link href="https://fonts.googleapis.com/css2?family=Poppins:wght@300;400;500;600;700&display=swap" rel="stylesheet">">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
    </head>
<body>
    <c:set var="sessionScope" value="${request.getSession()}" /> 

    <div class="header">
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

                        <li><a href="${sessionScope.loginURL}">${sessionScope.loginText}</a></li>
                    </ul>
                </nav>
                <img src="images/images/cart.png" width="30px" height="30px">
                <img src="images/images/menu.png" class="menu-icon" onclick="menutoggle()">
            </div>
        </div>
        <div class="row">
            <div class="col-2">
                <h1>Connecting Farms<br>To your home!</h1>
                <p>Farmers are the backbone of our society</p>
                <a href="" class="btn">Explore Now &#8594;</a>
            </div>
            <div class="col-2">
                <img src="images/far.png">
            </div>
        </div>
    </div>

<!---featured categories--->

    <div class="categories">
        <div class="small-container">
            <div class="row">
                <div class="col-3">
                    <img src="images/c1 resize.jpg">
                </div>
                <div class="col-3">
                    <img src="images/c2resize.PNG" alt="">
                </div>
                <div class="col-3">
                    <img src="images/c3resize.jpg" alt="">
                </div>
            </div>
        </div>
    </div>


    <!--featured products-->
    <div class="small-container">
        <h2 class="title">featured products</h2>
        <div class="row">
            <c:set var="first_row" value="${sessionScope.featuredProducts}" />
            <c:forEach items="${first_row}" var="product">
                <div class="col-4">
                    <a href="product?CropID=${product.getCropID()}/"> 
                    <img src="${product.getImageURI()}">
                    </a>
                    <h4>${product.getCropName()}</h4>
                    <div class="rating">
                        <c:set var="rating_value" value="${product.getRating()}" />
                        <c:if test="${rating_value != 0}">
                            <c:forEach var="i" begin="1" end="${rating_value}" step="1">
                                <i class="fa fa-star"></i>
                            </c:forEach>    
                        </c:if>
                        
                        <c:if test="${(5 - rating_value) != 0}">
                            <c:forEach var="i" begin="1" end="${5 - rating_value}" step="1">
                                <i class="fa fa-star-o"></i>
                            </c:forEach>
                        </c:if>
                    </div>
                    <p>${product.getPrice()} &#8377;/kg </p>
                </div>
            </c:forEach>
        </div>
    
        <!-- Other Products -->
        <h2 class="title">other products</h2>

            <c:set var="first_row" value="${sessionScope.otherProductsRowOne}" />
            <div class="row">
                <c:forEach items="${first_row}" var="product">
                    <div class="col-4">
                        <a href="product?CropID=${product.getCropID()}/"> 
                            <img src="${product.getImageURI()}"> 
                        </a>
                        <h4>${product.getCropName()}</h4>
                        <div class="rating">
                            <c:set var="rating_value" value="${product.getRating()}" />
                            <c:if test="${rating_value != 0}">
                                <c:forEach var="i" begin="1" end="${rating_value}" step="1">
                                    <i class="fa fa-star"></i>
                                </c:forEach>    
                            </c:if>
                            
                            <c:if test="${(5 - rating_value) != 0}">
                                <c:forEach var="i" begin="1" end="${5 - rating_value}" step="1">
                                    <i class="fa fa-star-o"></i>
                                </c:forEach>
                            </c:if>
                        </div>
                        <p>${product.getPrice()} &#8377;/kg </p>
                    </div>
                </c:forEach>
            </div>

            <c:set var="second_row" value="${sessionScope.otherProductsRowTwo}" />
            <div class="row">
                <c:forEach items="${second_row}" var="product">
                    <div class="col-4">
                        <a href="product?CropID=${product.getCropID()}">
                            <img src="${product.getImageURI()}">
                        </a>

                        
                        <h4>${product.getCropName()}</h4>
                        <div class="rating">
                            <c:set var="rating_value" value="${product.getRating()}" />
                            <c:if test="${rating_value != 0}">
                                <c:forEach var="i" begin="1" end="${rating_value}" step="1">
                                    <i class="fa fa-star"></i>
                                </c:forEach>    
                            </c:if>
                            
                            <c:if test="${(5 - rating_value) != 0}">
                                <c:forEach var="i" begin="1" end="${5 - rating_value}" step="1">
                                    <i class="fa fa-star-o"></i>
                                </c:forEach>
                            </c:if>
                        </div>
                        <p>${product.getPrice()} &#8377;/kg </p>
                    </div>
                </c:forEach>
            </div>
    </div>

    <!--Seasonal offer-->

    <div class="offer">
        <div class="small-container">
            <div class="row">
                <div class="col-2">
                    <img src="${sessionScope.seasonalImage}" width="350px">
                </div>
                <div class="col-2">
                    <p>In Season Now</p>
                    <h1>${sessionScope.seasonalName}</h1>
                    <small>January-March and September-December are the ideal seasons for growing pumpkin.<br>For the rain fed crop, sowing can be started after the receipt of first few showers during May-June</small>
                    <a href="product?CropID=${sessionScope.seasonalCropID}" class="btn">Buy Now &#8594;</a>
                </div>
            </div>
        </div>
    </div>

<!-- testimonial -->

    <div class="testimonial">
        <div class="small-container">
            <div class="row">
                <div class="col-3">
                    <i class="fa fa-quote-left"></i>
                    <p>Lorem ipsum dolor sit amet consectetur adipisicing elit. Error non ratione porro perferendis deserunt illo, cumque deleniti dignissimos qui fugit!</p>
                    <div class="rating">
                        <i class="fa fa-star"></i>
                        <i class="fa fa-star"></i>
                        <i class="fa fa-star"></i>
                        <i class="fa fa-star-half-o"></i>
                        <i class="fa fa-star-o"></i>
                    </div>
                    <img src="images/user-1.png">
                    <h3>Sean Parker</h3>
                </div>
                <div class="col-3">
                    <i class="fa fa-quote-left"></i>
                    <p>Lorem ipsum dolor sit amet consectetur adipisicing elit. Error non ratione porro perferendis deserunt illo, cumque deleniti dignissimos qui fugit!</p>
                    <div class="rating">
                        <i class="fa fa-star"></i>
                        <i class="fa fa-star"></i>
                        <i class="fa fa-star"></i>
                        <i class="fa fa-star-half-o"></i>
                        <i class="fa fa-star-o"></i>
                    </div>
                    <img src="images/user-2.png">
                    <h3>Rizwan hussain</h3>
                </div>
                <div class="col-3">
                    <i class="fa fa-quote-left"></i>
                    <p>Lorem ipsum dolor sit amet consectetur adipisicing elit. Error non ratione porro perferendis deserunt illo, cumque deleniti dignissimos qui fugit!</p>
                    <div class="rating">
                        <i class="fa fa-star"></i>
                        <i class="fa fa-star"></i>
                        <i class="fa fa-star"></i>
                        <i class="fa fa-star"></i>
                        <i class="fa fa-star-o"></i>
                    </div>
                    <img src="images/user-3.png">
                    <h3>Mobel Joe</h3>
                </div>
            </div>
        </div>
    </div>

<!--brands-->

    <div class="brands">
        <div class="small-container">
            <div class="row">
                <div class="col-5">
                    <img src="images/logo 1.png">
                </div>
                <div class="col-5">
                    <img src="images/logo-paypal.png">
                </div>
                <div class="col-5">
                    <img src="images/logo 2.png">
                </div>
                <div class="col-5">
                    <img src="images/gapy logo.png">
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


</body>
</html>