<%@taglib prefix="c" uri="http://www.springframework.org/tags" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="c1" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="security" uri="http://www.springframework.org/security/tags" %>

<!DOCTYPE html>
<html lang="en">
<head>
  <title>Cart</title>    
 <c:url value="/resources/images/" var="img"/>
 <c:url value="/resources/css/" var="css"/>
 <c:url value="/resources/js/" var="js"/>  
 <link rel="stylesheet" href="${css}/style2.css"/>
</head>

<style>
.fieldset
{
float:right;
border:1px solid black;
margin:10px 50px;
margin-right:100px;
}
 
.container {
 position: relative;
 left:25px;
}

.topright {
   position: absolute
   top: 8px;
   float:right;
   margin-top:10px;
   right: 26px;
  font-size: 18px;
}

img{
float:left;
}

.btn1{
float:left;
margin-left:-180px;
width=50%;
margin-top:300px;
border:3px solid #ffb3bf;
width:90px;

}

.btn2{
float:left;
margin-left:-80px;
margin-top:300px;
border:3px solid #ffb3bf;
width:60px;
}	
form {
    width: 400px;
    min-height: 450px;
    height: auto;
    border-radius: 5px;
    margin: 0% auto;
    box-shadow: 0 9px 50px hsla(20, 67%, 75%, 0.31);
    padding: 2%;
    background-image: linear-gradient(-225deg, #E3FDF5 50%, #FFE6FA 50%);
	float:left;
	margin-left:120px;
	margin-right:20px;
	
}
</style>


<body>
<%@ include file="header.jsp" %>
<br>
<div class="img">
  <c:url value="/singlepage" var="single"/>
<form:form action="${single}" method="post" commandName="singlepage">  
<div class="container">
  <h4>BabyCare</h4>
 <img src="${img}/johnsons1.jpeg" class="img-rounded" alt="johnsons" width="250px">
  <button type="submit2" class="btn1" >Add to Cart</button>

  <button type="submit2" class="btn2" >Buy</button>
</div>
</form:form>
</div>

<div>
<form>
<fieldset>
<br>
<br>
<legend><b><h4>BabyCare</h4></b></legend>

 <p>Keep your baby happy, healthy and smelling baby fresh with an assortment
 of mum-trusted products from Johnsons.</p> 
 Baby Shampoo : 300ml<br>
 Baby Wipes : 72<br>
 Baby Soap : 100g<br>
 Baby Lotion : 300ml<br>
 Baby Oil : 300ml<br>
 Bedtime Bath : 300ml<br>
 Top to Toe Wash : 300ml<br>
 Cotton buds : 100s <br>
 Baby Bath : 500ml<br>
 Baby Powder : 100g <br>
 Price : Rs.1350
</fieldset>
</form>
</div>

</body>
</html>