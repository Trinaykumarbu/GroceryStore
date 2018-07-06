<%@taglib prefix="c" uri="http://www.springframework.org/tags" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="c1" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="security" uri="http://www.springframework.org/security/tags" %>

<!DOCTYPE html>
<html lang="en" >
<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  
  <c:url value="/resources/images/" var="img"/>
 <c:url value="/resources/css/" var="css"/>
 <c:url value="/resources/js/" var="js"/>
 <link rel="stylesheet" href="${css}/style3.css">
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/normalize/5.0.0/normalize.min.css">

  <link rel='stylesheet prefetch' href='http://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.3.0/css/font-awesome.min.css'>
 
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
  <link rel='stylesheet prefetch' href='https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css'>
  <link rel="stylesheet" href="${css}/style2.css">
  
  
     
      
</head>

<style>
a.active{
	background-color: #ffcccc;
	overflow:hidden;
}
nav.navbar navbar-default{
	background-color:pink;
	overflow:hidden;
}
ul.nav navbar-nav{
	overflow:hidden;
}
.dropbtn{
	overflow:hidden;
}
.topnav {
    background-color:  #ffcccc;
    overflow:hidden;
}
.topnav a {
    float: left;
    color: black;
    text-align: center;
    padding: 24px 32px;
    text-decoration: none;
    font-size: 17px;
	}

.topnav a:hover {
    background-color:pink;
    color: white;
}


.topnav a:active {
    background-color:#ffccdd;
    color: red;
}
.dropbtn {
     background-color:pink;
    color: white;
    padding: 25px;
    font-size: 16px;
    border: none;
    cursor: pointer;
}

.dropdown {
    position: absolute;
    display: inline-block;
}

.dropdown-content {
    display: none;
    position: absolute;
    margin-top:50px;
    background-color: LightBlue;
    min-width: 160px;
    box-shadow: 0px 8px 16px 0px rgba(0,0,0,0.2);
    z-index: 1;
}

.dropdown-content a {
    color: black;
    padding: 12px 16px;
    text-decoration: none;
    display: block;
}

.dropdown-content a:hover {background-color: #f1f1f1}

.dropdown:hover .dropdown-content {
    display: block;
}

.dropdown:hover .dropbtn {
    background-color: pink;
}


.row1{
width:400px; 
}

body {
    background-image: url("${img}/thank1.jpg");
    background-size:1300px; ;
}

</style>
<body>
 
<nav class="navbar navbar-default" style="background-color:#1E90FF">
  <div class="container-fluid">
    <div class="navbar-header">
      <a class="navbar-brand"></a>
    </div>
    <ul class="nav navbar-nav">
      <li class="active1"><a style="color:white" "align:center">Grocery Offer Zone Top Deals & Discounts</a>
    </ul>
  </div>
</nav>
  
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
<br>


<section class='rating-widget'>
  
  <!-- Rating Stars Box -->
  <div class='rating-stars text-center'>
    <ul id='stars'>
      <li class='star' title='Poor' data-value='1'>
        <i class='fa fa-star fa-fw'></i>
      </li>
      <li class='star' title='Fair' data-value='2'>
        <i class='fa fa-star fa-fw'></i>
      </li>
      <li class='star' title='Good' data-value='3'>
        <i class='fa fa-star fa-fw'></i>
      </li>
      <li class='star' title='Excellent' data-value='4'>
        <i class='fa fa-star fa-fw'></i>
      </li>
      <li class='star' title='WOW!!!' data-value='5'>
        <i class='fa fa-star fa-fw'></i>
      </li>
    </ul>
  </div>
  
  <div class='success-box'>
    <div class='clearfix'></div>
    <img alt='tick image' width='32' src='https://i.imgur.com/3C3apOp.png'/>
    <div class='text-message'></div>
    <div class='clearfix'></div>
  </div>
  
  
  
</section>




  <script src='http://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js'></script>

  

    <script  src="${js}/index.js"></script>




</body>
</html>