<!DOCTYPE html>
<html>

<head>
    <meta charset='utf-8'>
    <meta http-equiv='X-UA-Compatible' content='IE=edge'>
    <title>Farmer SignUp</title>
    <meta name='viewport' content='width=device-width, initial-scale=1'>
</head>

<body>
    <div style="text-align: center;">
        <h1>Farmer SignUp</h1>
        <form action="farmerSignUp" method="post">
            First Name: <input type="text" name="fname"><br><br>
            Last Name: <input type="text" name="lname"> <br><br>
            Phone Number: <input type="number" name="phNumber"><br><br>
            Email: <input type="email" name="farmer_email"><br><br>
            Address: <input type="text" name="address"><br><br>
            Password : <input type="password" name="password1"> <br><br>
            Re-enter Password : <input type="password" name="password2"><br><br>

            <input type="submit" value="Sign Up">
        </form>
    </div>
</body>

</html>