<!DOCTYPE html>
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
        <h2 class="title">other products</h2>
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

    <!--Seasonal offer-->

    <div class="offer">
        <div class="small-container">
            <div class="row">
                <div class="col-2">
                    <img src="images/seasonal.PNG" width="350px">
                </div>
                <div class="col-2">
                    <p>In Season Now</p>
                    <h1>Pumpkin</h1>
                    <small>January-March and September-December are the ideal seasons for growing pumpkin.<br>For the rain fed crop, sowing can be started after the receipt of first few showers during May-June</small>
                    <a href="" class="btn">Buy Now &#8594;</a>
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