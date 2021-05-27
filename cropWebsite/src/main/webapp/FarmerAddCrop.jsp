<%@ page language="java" contentType="text/html" pageEncoding="UTF-8" errorPage="error.jsp" isELIgnored="false"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

        <!DOCTYPE html>
        <html lang="en">


        <head>
            <meta charset="UTF-8">
            <meta name="viewport" content="width=device-width, initial-scale=1.0">
            <meta http-equiv="X-UA-Compatible" content="IE=edge">
            <meta name="viewport" content="width=device-width, initial-scale=1.0">
            <title>All products - cropseeds</title>
            <link rel="stylesheet" href="style.css">
            <!-- <link rel="stylesheet" href="<link rel="preconnect" href="https://fonts.gstatic.com"> -->
            <link rel="stylesheet" href="https://fonts.gstatic.com">
            <link href="https://fonts.googleapis.com/css2?family=Poppins:wght@300;400;500;600;700&display=swap"
                rel="stylesheet">
            <link rel="stylesheet"
                href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
        </head>

        <body>

            <%@ include file="header.jsp" %>


                <!--add crop-->

                <div class="add-crop">
                    <div class="container">
                        <div class="row">
                            <div class="col-2">
                                <img src="https://i.ibb.co/kKbsF35/farmer.png" width="100%">
                            </div>
                            <div class="col-2">
                                <div style="height: 830px" class="form-container">
                                    <div>
                                        <form style="max-width: 100%; top: 10px; width: 100%;" action="farmerAddCrop"
                                            method="post">
                                            <h2>Add Crop</h2>
                                            <table style="text-align: left">
                                                <tr>
                                                    <td>Crop Name:</td>
                                                    <span id="inp"><td><input type="text" name="cropName" required></td></span>
                                                </tr>

                                                <tr>
                                                    <td>Quantity: </td>
                                                    <td><input type="number" name="quantity" required></td>

                                                </tr>

                                                <tr>
                                                    <td>Production Date:</td>
                                                    <td><input type="text" name="productionDate" placeholder="2020-05-21" required></td>

                                                </tr>

                                                <tr>
                                                    <td>Expiry Date:</td>
                                                    <td><input type="text" name="expirationDate" placeholder="2020-05-21"></td>
                                                </tr>

                                                <tr>
                                                    <td>Price:</td>
                                                    <td><input type="text" name="price"></td>
                                                </tr>

                                                <tr>
                                                    <td>Crop type:</td>
                                                    <td><select name="type">
                                                        <option value="Fruits">Fruits</option>
                                                        <option value="Vegetables">Vegetables</option>
                                                        <option value="Grain">Grain</option>
                                                        </select> </td>
                                                </tr>
                                                <tr>
                                                    <td>Season:</td>
                                                    <td><select name="season">
                                                        <option value="Winter">Winter</option>
                                                        <option value="Summer">Summer</option>
                                                        <option value="Spring">Spring</option>
                                                        <option value="Autumn">Autumn</option>
                                                        </select></td>
                                                </tr>
                                                
                                                <tr>
                                                    <td>Image1 :</td>
                                                    <td><input type="text" name="image1" required></td>
                                                </tr>
                                                <tr>
                                                    <td>Image2 :</td>
                                                    <td><input type="text" name="image2"></td>
                                                </tr>

                                                <tr>
                                                    <td>Image3 :</td>
                                                    <td><input type="text" name="image3"></td>
                                                </tr>

                                                <tr>
                                                    <td>Image4 :</td>
                                                    <td><input type="text" name="image4"></td>
                                                </tr>
                                            </table>
                                                
                                            <input style="height: 50px; font-size: 24px;" class="btn" type="submit" value="Add Crop"> <br>
                                            
                                        </form>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>





                <!--footer-->
                <%@ include file="footer.jsp" %>
        </body>

        </html>