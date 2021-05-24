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
    <link rel="preconnect" href="https://fonts.gstatic.com">
    <link href="https://fonts.googleapis.com/css2?family=Poppins:wght@300;400;500;600;700&display=swap" rel="stylesheet">">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
</head>
<body>

    <%@ include file="header.jsp" %>

    <div class="account-page">
        <div class="container">
            <div class="row">
                <div class="col-2">
                    <img src="https://i.ibb.co/NLsNszW/far.png" width="100%">
                </div>
                
                <div class="col-2">
                    
                    <div class="form-container">  

                        <h2>Login</h2>

                        <form style="max-width: 100%;  width: 100%; margin-top: 180px;" action="loginPage" method="post">
                            <table style="text-align: left;">
                                <tr>
                                    <td>Email :</td>
                                    <td><input type="text" name="user_email"></td>
                                </tr>
                                <tr>
                                    <td>Password :</td>
                                    <td><input type="password" name="pass1"></td>
                                </tr>
                            </table>

                            <input style="width: 60%; margin-top: 40px; height: 50px; font-size: 24px;" class="btn" type="submit" value="Login">
                        </form>
                        
                    </div>
                </div>
            </div>
        </div>
    </div>


<!--footer-->

<%@ include file="footer.jsp" %>


</body>
</html>