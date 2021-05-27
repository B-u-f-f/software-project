<%@ page language="java" contentType="text/html" pageEncoding="UTF-8" errorPage="error.jsp" isELIgnored="false"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import = "java.util.ArrayList" %>
<%@ page import = "software.web.index.database.CropData" %> 


<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Cart</title>
    <link rel="stylesheet" href="style.css">
    <!-- <link rel="stylesheet" href="<link rel="preconnect" href="https://fonts.gstatic.com"> -->
    <link rel="preconnect" href="https://fonts.gstatic.com">
    <link href="https://fonts.googleapis.com/css2?family=Poppins:wght@300;400;500;600;700&display=swap"
        rel="stylesheet">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
</head>

<body>
    <c:set var="sessionScope" value="${request.getSession()}" />
    <c:set var="data" value="${sessionScope.cropData}" />

    <%@ include file="header.jsp" %>



    <!--cart items details-->


    <div class="smart-container cart-page">
        <table>
            <tr>
                <th>Product</th>
                <th>Quantity</th>
                <th>Subtotal</th>
            </tr>
            
            <c:set var="total" value="0" />
            <c:forEach items="${data}" var="item">
                <tr>
                    <td>
                        <div class="cart-info">
                            <img src="${item.getImageURI()}">
                            <div>
                                <p></p>
                                <small>${item.getPrice()} &#8377;/kg</small>
                                <br>
                                <a href="/removeCartItem?CropID=${item.getCropID()}">Remove</a>
                            </div>
                        </div>
                    </td>
                    <td><input type="text" value="${item.getQuantity()}" width="100px" disabled></td>
                    <c:set var="total" value="${total + item.getQuantity() * item.getPrice()}" />
                    <td>${item.getQuantity() * item.getPrice()} &#8377;/kg</td>
                </tr>
            </c:forEach>

        </table>


        <div class="total-price">

            <table>
                <tr>
                    <td>Subtotal</td>
                    <td>${total} &#8377;</td>
                </tr>
                <tr>
                    <td>Tax</td>
                    <td>${total * 0.2} &#8377;</td>
                </tr>
                <tr>
                    <td>Subtotal</td>
                    <td>${total * 1.2} &#8377;</td>
                </tr>
            </table>

        </div>

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


</body>

</html>