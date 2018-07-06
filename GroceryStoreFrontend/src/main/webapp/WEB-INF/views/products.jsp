<%@taglib prefix="c" uri="http://www.springframework.org/tags" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="c1" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="security" uri="http://www.springframework.org/security/tags" %>

<!DOCTYPE html>
<html lang="en" >
<head>
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
width=400px; 

}

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



<!--  <div class="container-fluid" style="margin-left:0px; margin-top:0px;"> -->

<%--  <c1:forEach items="${products}" var="prod"> --%>
<!-- <div class="gallery" > -->
<%--      <img src="/project/images/${prod.getProductId()}.jpg" class="img-rounded" alt="almond"> --%>
<!-- <div class="desc"> -->
<%--  <a href="<c:url value='/addtocart/${prod.getProductId()}'/>"><button type="submit1" class="btn1"><i class="glyphicon glyphicon-shopping-cart"></i></button></a> --%>
<!--   <button type="submit1" class="btn2"><i class="glyphicon glyphicon-folder-open"></i></button> -->
<!-- </div></div> -->
<%-- </c1:forEach> --%>


<div class="container-fluid" style="margin-left:0px; margin-top:0px;">
<div class="gallery" >
     <img src="${img}/dryfruits.jpg" class="img-rounded" alt="almond">
<div class="desc">
 <button type="submit1" class="btn1"><i class="glyphicon glyphicon-shopping-cart"></i></button>
  <button type="submit1" class="btn2"><i class="glyphicon glyphicon-folder-open"></i></button>
</div></div>

<div class="gallery">
    <img src="${img}/baby2.png" class="img-rounded" alt="baby">
<div class="desc"> 
 <button type="submit2" class="btn1" ><i class="glyphicon glyphicon-shopping-cart"></i></button>
  <button type="submit2" class="btn2"><i class="glyphicon glyphicon-folder-open"></i></button>
  </div>
</div>

<div class="gallery">
    <img src="${img}/vegetable.jpg" class="img-rounded" alt="hamper" width="200px" height="200px">
<div class="desc">
<button type="submit2" class="btn1" ><i class="glyphicon glyphicon-shopping-cart"></i></button>
  <button type="submit2" class="btn2"><i class="glyphicon glyphicon-folder-open"></i></button>
</div></div>
  
<div class="gallery">
    <img src="${img}/oil.jpeg" class="img-rounded" alt="oil">
<div class="desc">
<button type="submit2" class="btn1" ><i class="glyphicon glyphicon-shopping-cart"></i></button>
  <button type="submit2" class="btn2"><i class="glyphicon glyphicon-folder-open"></i></button>
</div></div>
  
<div class="gallery">
    <img src="${img}/softdrinks.jpeg" class="img-rounded" alt="drinks">
<div class="desc">
<button type="submit2" class="btn1" ><i class="glyphicon glyphicon-shopping-cart"></i></button>
  <button type="submit2" class="btn2"><i class="glyphicon glyphicon-folder-open"></i></button>
</div></div>
  
<div class="gallery">
    <img src="${img}/snacks.jpeg" class="img-rounded" alt="snack">
<div class="desc">
<button type="submit2" class="btn1" ><i class="glyphicon glyphicon-shopping-cart"></i></button>
  <button type="submit2" class="btn2"><i class="glyphicon glyphicon-folder-open"></i></button>
</div></div>
</div>

</body>
</html>