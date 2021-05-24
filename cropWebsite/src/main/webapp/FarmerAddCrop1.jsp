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
    <form action="farmerAddCrop" method="post">
        Crop Name: <input type="text" name="cropName" required> <br><br>
        Quantity<input type="number" name="quantity" required> <br> <br>
        Production Date: <input type="text" name="productionDate" placeholder="2020-05-21"required><br><br>
        Expiry Date: <input type="text" name="expirationDate" placeholder="2020-05-21"><br><br>
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

        Image1 : <input type="text" name="image1" required> <br><br>
        Image2 : <input type="text" name="image2" > <br><br>
        Image3 : <input type="text" name="image3" > <br><br>
        Image4 : <input type="text" name="image4" > <br><br>

        <input type="submit" value="Add Crop"> <br><br>
    </form>
</div>
</body>
</html>