<%@taglib prefix="c" uri="http://www.springframework.org/tags" %>
<%@taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="c1" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="security" uri="http://www.springframework.org/security/tags" %>

<!DOCTYPE html>
<html>
<head>
 <title>Ecommerce Website</title>
 <meta charset="utf-8">
 
 <c:url value="/resources/images/" var="img"/>
 <c:url value="/resources/css/" var="css"/>
 <c:url value="/resources/js/" var="js"/>
 
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
  <link rel='stylesheet prefetch' href='https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css'>
  <link rel="stylesheet" href="${css}/style2.css">
  <link rel="stylesheet" href="${css}/style.css"/>

<style>
div.gallery {
    margin: 20px;
    border: 1px;
    float: left;
    width:220px;
    height:200px;
	margin-bottom:80px;
}

div.gallery:hover {
    border: 1px solid #777;
}

div.gallery img {
    width: 220px;
    height: 200px;
}

div.desc {
    padding: 15px;
    text-align: center;
}

li{
list-style-type: none;
}

.marker
{
padding:40px;
float:left;
margin-left:150px;
margin-right:20px;
list-style-type: none;
}

.pack{
padding:40px;
float:left;
margin-left:150px;
margin-right:20px;
list-style-type: none;
}

.sub{
padding:40px;
float:left;
margin-left:50px;
margin-right:10px;
list-style-type: none;
}

.brand{
padding:40px;
float:left;
margin-left:450px;
margin-right:20px;
list-style-type: none;
}

.method{
padding:40px;
float:left;
margin-left:150px;
margin-right:20px;
list-style-type: none;
}

.copy{
padding:20px;
align:center
margin:5px;
background-color:Tomato;
}

pack.h4{
 background-color:red;
 }
 
#para1 {
text-align: center;
color: black;
font-size:30px;
}
 
#para2{
font-style:italic;
} 
 
#para3{
font-family:Georgia;
color:Red;
font-style:oblique;
}
 
#para4{
font-family:Georgia;
font-weight:bold;
} 
 
.copy{
background-color:DodgerBlue;
}

.form-control{
align:center;
padding:10px;
}
 
</style>
</head>

<nav class="navbar navbar-default" style="background-color:#1E90FF">
  <div class="container-fluid">
    <div class="navbar-header">
      <a class="navbar-brand"></a>
    </div>
    <ul class="nav navbar-nav">
      <li class="active1"><a style="color:white; align:center">Grocery Offer Zone Top Deals & Discounts</a>
    </ul>
  </div>
</nav>

<div class="container">
<header>
<div class="col-md-2 logo_agile">
<a href="index.html">
	<img src="${img}/grocery.png" alt=" " width="160px"><br>
	<h4><span>G</span>rocery <span>S</span>hoppy</h4>
</a>
</div>
<br/>
<br/>
<br/>
<div class="col-md-8 header" style="align:center">
				<!-- header lists -->
    <div>			
		<a class="play-icon popup-with-zoom-anim" href="#small-dialog1">
		<span class="glyphicon glyphicon-map-marker"></span> Shop Locator</a>&nbsp&nbsp
								
		<a href="#" data-toggle="modal" data-target="#myModal2">
		<span class="glyphicon glyphicon-screenshot"></span>Track Order</a>&nbsp&nbsp
					
		<a href="#" data-toggle="modal" data-target="#myModal3">
		<span class="glyphicon glyphicon-earphone" aria-hidden="true"></span> 001 234 5678</a>&nbsp&nbsp
								
		<a href="#" data-toggle="modal" data-target="#myModal4">
		<span class="glyphicon glyphicon-ok-sign"></span> Sign In </a>&nbsp&nbsp
							
		<a href="#" data-toggle="modal" data-target="#myModal">
		<span class="glyphicon glyphicon-edit"></span> Sign Up </a>&nbsp&nbsp
	</div>	
<br>				
    <input type="email" class="form-control" placeholder="How can i help you today">
    <button type="button" class="btn btn-danger" style="margin-top:-60px; margin-left:750px"><span class="glyphicon glyphicon-search"></button>
  </div>
</header>
<br>
</div>


<div class="topnav">
  <a class="active" href="<c:url value='/'/>"><span class="glyphicon glyphicon-home"></span>Home</a>
  <a class="active" href="<c:url value='/contact'/>"> <span class="glyphicon glyphicon-phone"></span>Contact</a>
  <a class="active" href="<c:url value='/aboutus'/>"> <span class="glyphicon glyphicon-list"></span>About</a>
  <a class="active" href="<c:url value='/viewcart'/>" style="float:right"><span class="glyphicon glyphicon-shopping-cart">${items}</span></a>
  <c1:if test="${pageContext.request.userPrincipal.name!=null}">
  Welcome ${pageContext.request.userPrincipal.name}
  <a class="active" href="<c:url value='/j_spring_security_logout'/>" style="float:right"><span class="glyphicon glyphicon-log-out"></span>LogOut</a>
  </c1:if>
  <c1:if test="${pageContext.request.userPrincipal.name==null}">
  <a class="active" href="#"  data-toggle="modal" data-target="#myModal" style="float:right"><span class="glyphicon glyphicon-edit"></span>Signup</a>
  <a class="active" href="<c:url value='/login'/>" data-toggle="modal" data-target="#myModal1" style="float:right"><span class="glyphicon glyphicon-check"></span>Login</a>
  </c1:if>
  <a class="active" href="<c:url value='/products'/>">Products</a>
<ul class="nav navbar-nav">
  <div class="dropdown">
  <c1:if test="${pageContext.request.userPrincipal!=null}">
  <security:authorize access="hasRole('ROLE_ADMIN')">
    <a class="active" href="">Admin</a>
  <div class="dropdown-content">
    <a href="<c:url value='/category'/>">Add Category</a>
    <a href="<c:url value='/supplier'/>">Add Supplier</a>
    <a href="<c:url value='/product'/>">Add Product</a>
  </div>
  </security:authorize>
</c1:if>
</div>
</ul>
</div>

<c1:if test= "${pageContext.request.userPrincipal.name==null}">		
		<!-- Modal -->
<div class="modal fade" id="myModal" role="dialog">
    <div class="modal-dialog">
    <!-- Modal content--> 
	<div class="overlay">
	<c:url value="/addUser" var="sign"/>
    <form:form action="${sign}" method="post" commandName="user">  
   <div class="con">
   <header class="head-form">
     <h2>SIGNUP</h2>   
   </header> 
   <div class="field-set">      
    <form:input class="form-input" type="text" placeholder="FirstName" path="userName" required="required"/>
 <br>
	<form:input class="form-input" type="text" placeholder="LastName" path="userName" required="required"/>
 <br>
	<form:input class="form-input" type="password" placeholder="Password" path="userPassword" required="required"/>
 <br>
    <form:input class="form-input" type="text" placeholder="Houseno" path="userHouseno" required="required"/>
 <br>
    <form:input class="form-input" type="text" placeholder="Address" path="userAddress" required="required"/>
 <br>
    <form:input class="form-input" type="text" placeholder="Pincode" path="userPincode" required="required" pattern="[0-9]{6}" />
 <br>
    <form:input class="form-input" type="text" placeholder="Phone Number" path="userPhnno" required="required" pattern="[789][0-9]{9}"/>
 <br>
    <form:input class="form-input" type="text" placeholder="E-mail ID" path="userEmailid" required="required"/>
 <br>
      
    <button class="btn submits sign-up" type="submit"> Submit </button>
	<button class="btn submits sign-up" type="reset">Cancel</button>
</div>
</div>
</form:form>
</div>  
<script  src="js/index.js">
</script>
</div>
</div>
	  
<div class="modal fade" id="myModal1" role="dialog">
    <div class="modal-dialog">
     <!-- Modal content-->
    <div class="overlay">
    <c:url value="/j_spring_security_check" var="login"/>
<form:form action="${login}" method="post" > 
   <div class="con">
   <header class="head-form">
     <h2>LOGIN</h2>   
   </header>
<br>
   <div class="field-set">      
    <input class="form-input" type="text" placeholder="UserName" name="j_username" required="required"/>
 <br>
	<input class="form-input" type="password" placeholder="Password" name="j_password" required="required"/>
 <br>
   <button class="btn submits sign-up"> Submit </button>
   <button class="btn submits sign-up">Cancel</button>
</div>
</div>
</form:form>
</div>  
<script  src="js/index.js">
</script>
</div>
</div>
</c1:if>
		
<div class="container-fluid" style="margin-left:0px; margin-top:0px;">
  <div id="myCarousel" class="carousel slide" data-ride="carousel">
    <ol class="carousel-indicators">
      <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
      <li data-target="#myCarousel" data-slide-to="1"></li>
      <li data-target="#myCarousel" data-slide-to="2"></li>
    </ol>
<div class="carousel-inner">
   <div class="item active">
        <img src="${img}/grocery1.jpeg" alt="Los Angles" width="100%">
        <div class="carousel-caption">   
        </div>
   </div>
<div class="item">
 <img src="${img}/grocery2.jpeg" alt="chicago" width="100%">
        <div class="carousel-caption">
        </div>
</div>
 <div class="item">
   <img src="${img}/grocery3.jpeg" alt="newyork" width="100%">
        <div class="carousel-caption">
        </div>
</div>
 
<a class="left carousel-control" href="#myCarousel" data-slide="prev">
      <span class="glyphicon glyphicon-chevron-left"></span>
      <span class="sr-only">Previous</span>
 </a>
 <a class="right carousel-control" href="#myCarousel" data-slide="next">
      <span class="glyphicon glyphicon-chevron-right"></span>
      <span class="sr-only">Next</span>
 </a>
  </div>
</div>
</div>


<div class="container-fluid" style="margin-left:0px; margin-top:0px;">

 <c1:forEach items="${products}" var="prod"> 
 <div class="gallery" > 
      <img src="${img}/${prod.getProductId()}.jpg" class="img-rounded" alt="almond"> 
 <div class="desc"> 
  <a href="<c:url value='/addtocart/${prod.getProductId()}'/>"><button type="submit1" class="btn1"><i class="glyphicon glyphicon-shopping-cart"></i></button></a> 
   <button type="submit1" class="btn2"><i class="glyphicon glyphicon-folder-open"></i></button> 
 </div></div> 
 </c1:forEach> 
 </div>
 
<br>
<%-- <c1:forEach items="${products}" var="prod">  --%>
<!-- <div class="gallery" > -->
<%--      <img src="${img}/${prod.getProductId()}.jpeg" class="img-rounded" alt="almond"> --%>
<!-- <div class="desc"> -->
<%--    <a href="<c:url value='/addtocart/${prod.getProductId()}'/>"><button type="submit1" class="btn1"><i class="glyphicon glyphicon-shopping-cart"></i></button></a> --%>
<!--   <button type="submit1" class="btn2"><i class="glyphicon glyphicon-folder-open"></i></button> -->
<!-- </div></div> -->
<%-- </c1:forEach> --%>


<div class="footer-top">
	<div class="container">
		
		<h3>Get your Groceries delivered from local stores</h3>
		<p>Free Delivery on your first order!</p>
				
		<input type="email" placeholder="E-mail" name="email">
		<input type="submit" value="Subscribe">
				
		<span class="fa fa-envelope-o" aria-hidden="true"></span>
		<!--<div class="col-xs-4 w3l-rightmk" >-->
		<img src="${img}/tab3.png" alt=" " width="250px" align="right" style="margin-right:500px; margin-top:-100px">
			          
	</div>	
</div>


<footer>
	<a id="para1">"Grocery Shoppy"</a><p id="para2"> A grocery store is a retail store that primarily sells food. A grocer is a bulk seller of food.Grocery stores often offer non-perishable food that is packaged in bottles, boxes, and cans; some also have bakeries, butchers, delis, and fresh produce. 
	Large grocery stores that stock significant amounts of non-food products, such as clothing and household items, are called supermarkets. 
	Some large supermarkets also include a pharmacy, and customer service, redemption, and electronics sections..</p>
	<div class="container">
			
	    <div class="marker">
			<h5 style="color:Red;"><span id="para3" class="glyphicon glyphicon-map-marker"></span>Track Your Order</h5></a>
        </div>
            
        <div class="marker">
		    <h5 style="color:Red;"><span id="para3" class="glyphicon glyphicon-refresh"></span>Free & Easy Returns</h5></a>
        </div>
            
        <div class="marker">
			<h5 style="color:Red;"><span id="para3" class="glyphicon glyphicon-remove"></span>Online cancellation </h5></a>
		</div>
            			
	<hr/>
	</div>
<br>	

	
<div class="category2">
    <div class="pack">
		<h4 id="para4" style="color:DodgerBlue;">CATEGORIES</h4>			
			<ul style="color:LimeGreen;">
			<li>
				<a href="product.html" ><i>Grocery</i></a>
			</li>
			<li>
				<a href="product.html"><i>Fruits</i></a>
			</li>
			<li>
				<a href="product.html"><i>Soft Drinks</i></a>
			</li>
			<li>
				<a href="product.html"><i>Dishwashers</i></a>
			</li>
			<li>
				<a href="product.html"><i>Biscuits & Cookies</i></a>
			</li>
			<li>
			    <a href="product.html"><i>Baby Diapers</i></a>
			</li>
			</ul>
	</div>
	<div class="pack">
		<h4 id="para4" style="color:DodgerBlue;">QUICK LINKS</h4>
			<ul style="color:LimeGreen;">
			<li>
				<a href=""><i>About Us</i></a>
			</li>
			<li>
				<a href=""><i>Contact Us</i></a>
			</li>
			<li>
				<a href=""><i>Help</i></a>
			</li>
			<li>
				<a href=""><i>Terms of use</i></a>
			</li>
			<li>
				<a href=""><i>Privacy Policy</i></a>
			</li>
			</ul>
	</div>
	<div class="pack">
		<h4 id="para4" style="color:DodgerBlue;">GET IN TOUCH</h4>
			<ul style="color:LimeGreen;">
			<li><a class="glyphicon glyphicon-map-marker"></a> Rajajinagar,Bangalore</li>
			<li><a class="glyphicon glyphicon-phone"></a>+91 9000000009</li>
			<li><a class="glyphicon glyphicon-earphone"></a> 080-23300078 </li>
			<li><a class="glyphicon glyphicon-envelope"></a>
				<a href="mailto:example@mail.com"> mail@example.com</a>
			</li>
			</ul>
	</div>
</div>

<div class="agile-sometext">
	<div class="sub">
		<h4 style="color:Chocolate;"><b>Shop online with the best deals & offers<b></h4>
		<p style="color:Coral;"><i>Now Get Upto 40% Off On Everyday Essential Products Shown On The Offer Page. The range includes Grocery, Personal Care,
						Baby Care, Pet Supplies, Healthcare and Other Daily Need Products. Discount May Vary From Product To Product.</i></p>
	</div>
</div>   	
</footer>
<br>
<br>

	
<footer>
<div class="copy-right">
    <div class="copy">
		<p>© 2018 Grocery Shoppy. All rights reserved | Design by
			<a href="http://w3layouts.com"> W3layouts.</a>
		</p>
	</div>
</div>
</footer>
</body>
</html>

