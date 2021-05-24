
<c:set var="isLogin" value="${false}"/>
<c:set var="isFarmer" value="${false}"/>


<%
    boolean isLogin = false;
    boolean isFarmer = false;

    if(session.getAttribute("userEmail") != null){
        isLogin = true;
        if(session.getAttribute("userType").equals("Farmer")){
            isFarmer = true;
        }else {
            isFarmer = false;
        }
    }else {
        isLogin = false;
    }

    pageContext.setAttribute("isLogin", isLogin);
    pageContext.setAttribute("isFarmer", isFarmer);

    out.println(isLogin);
    out.println(isFarmer);
%>

<div class="container">
    <div class="navbar">
        <div class="logo">
            <img src="https://i.ibb.co/LxVwW7x/cs.png" width="165px">
        </div>
        <nav>
            <ul id="MenuItems">
                <li><a href="index.jsp">Home</a></li>
                <li><a href="/productShowcase">Products</a></li>
                
                <c:if test="${isLogin && isFarmer}">
                    <li><a href="FarmerAddCrop.jsp"> Add Crop </a></li>
                </c:if>

                <c:if test="${isLogin && !isFarmer}">
                    <li><a href="/cart">Check Cart</a></li>
                </c:if>

                <c:if test="${!isLogin}">
                    <li><a href="farmerSignUp.jsp">Sign Up As Farmer</a></li>
                    <li><a href="customerSignUp.jsp">Sign Up As Customer</a></li>
                    <li><a href="loginPage.jsp">Login</a></li>
                </c:if>

                <c:if test="${isLogin}">
                    <li><a href="/logout">Logout</a></li>
                </c:if>
            </ul>
        </nav>
        <img src="https://i.ibb.co/zb8qBs2/menu.png" width="30px" height="30px">
    </div>
</div>