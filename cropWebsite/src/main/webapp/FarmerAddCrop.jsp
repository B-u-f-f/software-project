<!DOCTYPE html>
<html>

<head>
    <meta charset='utf-8'>
    <meta http-equiv='X-UA-Compatible' content='IE=edge'>
    <title>Farmer SignUp</title>
    <meta name='viewport' content='width=device-width, initial-scale=1'>
</head>

<body>
    <form action="" method="post">
        Crop Name: <input type="text" name="cropName" required> <br><br>
        Quantity<input type="number" name="quantity" required> <br> <br>
        Production Data: <input type="date" name="productionDate" required><br><br>
        Expiry Date: <input type="date" name="expirationDate"><br><br>
        Price: <input type="text" name="price"> <br><br>
        Crop type: <select name ="type" >
            <option value="Fruits">Fruits</option>
            <option value="Vegetables">Vegetables</option>
            <option value="Grain">Grain</option>
        </select> <br><br>

        Season: <select name ="season" >
            <option value="Winter">Winter</option>
            <option value="Summer">Summer</option>
            <option value="Spring">Spring</option>
            <option value="Autumn">Autumn</option>
        </select> <br><br>
        <input type="submit" value="Add Crop"> <br><br>
    </form>
</body>
</html>