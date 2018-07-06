<%@taglib prefix="c" uri="http://www.springframework.org/tags" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="c1" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="security" uri="http://www.springframework.org/security/tags" %>

<!DOCTYPE html>
<html lang="en" >
<head>
  <meta charset="UTF-8">
  <title>Payment</title>
  <link rel='stylesheet prefetch' href='https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css'>
  <link rel="stylesheet" href="${css}/style2.css">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
  <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.4.8/angular.min.js"></script>
  <script>
  var app=angular.module('myApp',[]);
  app.controller('myCtrl',function($scope,$http){
	  $http.get("http://localhost:8080/GroceryStoreFrontend/SendMail")
  });
  </script>
 
  <c:url value="/resources/images/" var="img"/>
 <c:url value="/resources/css/" var="css"/>
 <c:url value="/resources/js/" var="js"/>  
 </head>
 
 <style>
.button {
    background-color: #ffb3b3;
	width:15%;
    border: none;
    color: white;
    padding: 15px 32px;
    text-align: center;
    text-decoration: none;
    display: inline-block;
    font-size: 16px;
    margin: 4px 2px;
    cursor: pointer;
}

form {
    width: 250px;
    min-height: 150px;
    height: auto;
    border-radius: 3px;
    margin: 2% auto;
    box-shadow: 0 9px 50px hsla(20, 67%, 75%, 0.31);
    padding: 2%;
    background-image: linear-gradient(-225deg, #E3FDF5 50%, #FFE6FA 50%);
	float:left;
	margin-left:150px;
	margin-right:100px;
}

.button1 {
    background-color: #ffb3b3;
	width:25%;
	align:center;
	margin-right:100px;
	float:right;
}
</style>
 <br>
 
 <body  ng-app="myApp" ng-controller="myCtrl">
 <%@ include file="header.jsp" %>
 <br> 
 <div class="container">
  <div class="panel-group" id="accordion">
    <div class="panel panel-default">
      <div class="panel-heading">
        <h4 class="panel-title">
          <a data-toggle="collapse" data-parent="#accordion" href="#collapse1">OTP</a>
        </h4>
      </div>
<div id="collapse1" class="panel-collapse collapse in">
  <div class="panel-body">
  <c:url value="/payment" var="pa"/>
<form:form action="${pa}" method="post" id="myForm">
 <h4>Enter a OTP:</h4><br>
 <input type="text" class="form-control" name="otp" >
 <br>
 <button class="button1" >PAY</button>
 </form:form>
   </div>
 </div>
</div>
	
    <div class="panel panel-default">
      <div class="panel-heading">
        <h4 class="panel-title">
          <a data-toggle="collapse" data-parent="#accordion" href="#collapse2">CARD PAYMENT</a>
        </h4>
      </div>
      <div id="collapse2" class="panel-collapse collapse">
        <div class="panel-body">
		<form>
 <img src="${img}/card2.png" class="img-rounded" alt="almond" width="75px">
  <img src="${img}/card3.jpg" class="img-rounded" alt="almond" width="75px">
  <br>
   <img src="${img}/card4.jpg" class="img-rounded" alt="almond" width="75px">  
   <img src="${img}/card5.png" class="img-rounded" alt="almond" width="75px">  
 <br>  
  Card Holder Name:<br>
 <input type="text" class="form-control">
 <br>
 Credit Card Number:<br>
 <input type="text" class="form-control">
 <br>
 CVV Code:<br>
 <input type="password" class="form-control" id="password">  
 <br>
 <button class="button1" >PAY</button>  
 </form>
 </div>
      </div>
    </div>
	
	
    <div class="panel panel-default">
      <div class="panel-heading">
        <h4 class="panel-title">
          <a data-toggle="collapse" data-parent="#accordion" href="#collapse3">NETBANKING</a>
        </h4>
      </div>
      <div id="collapse3" class="panel-collapse collapse">
        <div class="panel-body">
		<form>
 Account Number:<br>
 <input type="text" class="form-control">
 <br>
 Bank Name:<br>
 <input type="text" class="form-control">
 <br>
 Password:<br>
 <input type="password" class="form-control" id="password"> 
 <br>
 <button class="button1" >PAY</button>.</div>
      </div>
    </div>
  </div> 
</div>
    
	
</body>
</html>
 
 
 
 