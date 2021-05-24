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
        <%@ include file="header.jsp" %>
        <div class="row">
            <div class="col-2">
                <h1>Connecting Farms<br>To your home!</h1>
                <p>Farmers are the backbone of our society</p>
                <a href="" class="btn">Explore Now &#8594;</a>
            </div>
            <div class="col-2">
                <img src="https://i.ibb.co/NLsNszW/far.png">
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
    
        <!-- Other Products -->
        <h2 class="title">other products</h2>

            <c:set var="first_row" value="${sessionScope.otherProductsRowOne}" />
            <div class="row">
                <c:forEach items="${first_row}" var="product">
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
                    <img src="https://i.ibb.co/Jq7BcT1/user-1.png">
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
                    <img src="https://i.ibb.co/gWMSPX7/user-2.png">
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
                    <img src="https://i.ibb.co/tMrsSYX/user-3.png">
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
                    <img src="https://i.ibb.co/Mfkrthj/logo-2.png">
                </div>
                <div class="col-5">
                    <img src="https://i.ibb.co/NjJhT85/logo-1.png">
                </div>
                <div class="col-5">
                    <img src="https://i.ibb.co/qRbFBbX/logo-paypal.png">
                </div>
                <div class="col-5">
                    <img src="https://i.ibb.co/8bQH9Yh/gapy-logo.png">
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


</body>
</html>