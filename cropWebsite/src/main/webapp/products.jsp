<%@ page language="java" contentType="text/html" pageEncoding="UTF-8" isELIgnored="false" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<%@ page import = "software.web.products.database.ProductData" %>
<%@ page import = "software.web.products.database.Category" %>
<%@ page import = "java.util.ArrayList" %>


<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Products</title>
    <link rel="stylesheet" href="style.css">
    <!-- <link rel="stylesheet" href="<link rel="preconnect" href="https://fonts.gstatic.com"> -->
    <link rel="preconnect" href="https://fonts.gstatic.com">
    <link href="https://fonts.googleapis.com/css2?family=Poppins:wght@300;400;500;600;700&display=swap"
        rel="stylesheet">">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
</head>

<body>

    <c:set var="sessionScope" value="${request.getSession()}" /> 


    <%@ include file="header.jsp" %>
    
    <div class="small-container">
        <c:set var="data" value="${sessionScope.productsArray}" />
        <c:set var="numPages" value="${sessionScope.numPages}" />
        <c:set var="numPerPage" value="${sessionScope.numPerPage}" />
        <c:set var="products" value="${sessionScope.productLength}" />
        <c:set var="numRows" value="${sessionScope.numRows}" />
    
        <div class="row row-2">
            <h2>All Products</h2>
            <form action="productShowcase" method="get">
                <select name="sortType">
                    <option value="byPrice"> Sort by price</option>
                    <option value="byRating">Sort by rating</option>
                </select>
                <input type="submit" value="Filter" />
            </form>
        </div>

        <c:if test="${numRows >= 1}">
            <c:forEach var="i" begin="1" end="${numRows}" step="1">

                <div class="row">
                    <c:set var="begVal" value="${numRows * (i - 1)}"/>
                    <c:set var="min" value="${Math.min(products - numRows * (i - 1) * 4, numRows * 4)}" />

                    <c:set var="endVal" value = "${numRows * (i - 1) + min - 1}" />
                    <c:forEach var="j" begin="${begVal}" end= "${endVal}" step="1">
                        
                        <div class="col-4">
                            <a href="product?CropID=${data[j].getCropID()}"><img src="${data[j].getImages().get(0)}"></a>
                            <h4>${data[j].getCropName()}</h4>
                            <div class="rating">
                                <c:set var="rating_value" value="${data[j].getRating()}" />

                                <c:if test="${rating_value > 0}">
                                    <c:forEach var="i" begin="1" end="${rating_value}" step="1">
                                        <i class="fa fa-star"></i>
                                    </c:forEach>    
                                </c:if>
                                
                                <c:if test="${(5 - rating_value) > 0}">
                                    <c:forEach var="i" begin="1" end="${5 - rating_value}" step="1">
                                        <i class="fa fa-star-o"></i>
                                    </c:forEach>
                                </c:if>
                            </div>
                            <p>${data[j].getPrice()} &#8377;/kg </p>
                        </div>

                    </c:forEach>
                </div>
            </c:forEach>
        </c:if>
        <!--
        <div class="row">

            <div class="col-4">
                <img src="images/pro2.PNG">
                <h4>Red Tomato</h4>
                <div class="rating">
                    <i class="fa fa-star"></i>
                    <i class="fa fa-star"></i>
                    <i class="fa fa-star"></i>
                    <i class="fa fa-star"></i>
                    <i class="fa fa-star-o"></i>
                </div>
                <p>45.00 &#8377;/kg </p>
            </div>


            <div class="col-4">
                <img src="images/pro4.PNG">
                <h4>Potato</h4>
                <div class="rating">
                    <i class="fa fa-star"></i>
                    <i class="fa fa-star"></i>
                    <i class="fa fa-star"></i>
                    <i class="fa fa-star"></i>
                    <i class="fa fa-star-o"></i>
                </div>
                <p>29.00 &#8377;/kg </p>
            </div>


            <div class="col-4">
                <img src="images/pro3.PNG">
                <h4>Onion</h4>
                <div class="rating">
                    <i class="fa fa-star"></i>
                    <i class="fa fa-star"></i>
                    <i class="fa fa-star"></i>
                    <i class="fa fa-star"></i>
                    <i class="fa fa-star-o"></i>
                </div>
                <p>19.00 &#8377;/kg </p>
            </div>


            <div class="col-4">
                <img src="images/pro5.PNG">
                <h4>Rice</h4>
                <div class="rating">
                    <i class="fa fa-star"></i>
                    <i class="fa fa-star"></i>
                    <i class="fa fa-star"></i>
                    <i class="fa fa-star"></i>
                    <i class="fa fa-star-o"></i>
                </div>
                <p>174.00 &#8377;/kg </p>
            </div>
        </div>

        <div class="row">


            <div class="col-4">
                <img src="images/pro6.PNG">
                <h4>wheat</h4>
                <div class="rating">
                    <i class="fa fa-star"></i>
                    <i class="fa fa-star"></i>
                    <i class="fa fa-star"></i>
                    <i class="fa fa-star"></i>
                    <i class="fa fa-star-o"></i>
                </div>
                <p>20.00 &#8377;/kg </p>
            </div>


            <div class="col-4">
                <img src="images/pro7.PNG">
                <h4>Sugar</h4>
                <div class="rating">
                    <i class="fa fa-star"></i>
                    <i class="fa fa-star"></i>
                    <i class="fa fa-star"></i>
                    <i class="fa fa-star"></i>
                    <i class="fa fa-star-o"></i>
                </div>
                <p>55.00 &#8377;/kg </p>
            </div>


            <div class="col-4">
                <img src="images/pro8.PNG">
                <h4>Mustard Oil</h4>
                <div class="rating">
                    <i class="fa fa-star"></i>
                    <i class="fa fa-star"></i>
                    <i class="fa fa-star"></i>
                    <i class="fa fa-star"></i>
                    <i class="fa fa-star-o"></i>
                </div>
                <p>181.00 &#8377;/L </p>
            </div>


            <div class="col-4">
                <img src="images/pro9.PNG">
                <h4>Watermelon</h4>
                <div class="rating">
                    <i class="fa fa-star"></i>
                    <i class="fa fa-star"></i>
                    <i class="fa fa-star"></i>
                    <i class="fa fa-star"></i>
                    <i class="fa fa-star-o"></i>
                </div>
                <p>40.00 &#8377;/kg </p>
            </div>
        </div>

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
        </div> -->


        <div class="page-btn">
            <c:forEach var="i" begin="1" end="${numPages}" step="1">
                <a href="/productShowcase?pageNo=${i}"><span>${i}</span></a>
            </c:forEach>
            <!-- <span>&#8594;</span> -->
        </div>



        <!--footer-->

        <%@ include file="footer.jsp" %>



        <!--js for toggle menu-->

        <script>
            var MenuItems = document.getElementById("MenuItems");

            MenuItems.style.maxHeight = "0px";

            function menutoggle() {
                if (MenuItems.style.maxHeight == "0px") {
                    MenuItems.style.maxHeight = "200px";
                }
                else {
                    MenuItems.style.maxHeight = "0px";
                }
            }
        </script>
    </div>

</body>

</html>