<%@taglib prefix="c" uri="http://www.springframework.org/tags" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="c1" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="security" uri="http://www.springframework.org/security/tags" %>


<!DOCTYPE html>
<html lang="en" >
<head>
  <meta charset="UTF-8">
  <title>Shipping-form</title>
  
  <c:url value="/resources/images/" var="img"/>
 <c:url value="/resources/css/" var="css"/>
 <c:url value="/resources/js/" var="js"/>
  <link rel='stylesheet prefetch' href='https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css'>
  <link rel="stylesheet" href="${css}/style2.css">
</head>

<style>
.field-set1
{
float:left;
margin:10px 100px;

top:0;
}


</style>

<body>
<%@ include file="header.jsp" %>
  <div class="overlay">
<form class="form" action="" method="post">
   <div class="con">
   <header class="head-form">
     <h2>BILLING FORM</h2>     
   </header> 
<br>
   <div class="field-set">      
    <form:input class="form-input" type="text" placeholder="BillID" required="required" path="billing.billId" autocomplete="off" autofocus="true"/>
 <br>
	<form:input class="form-input" type="text" placeholder="HouseNo" path="billing.billHouseno" required="required"/>
 <br>
	<form:input class="form-input" type="text" placeholder="Country" path="billing.billCity" required="required"/>
 <br>
    <form:input class="form-input" type="text" placeholder="Pincode" path="billing.billPincode" required="required" pattern="[0-9]{6}"/>
 <br>
    <form:input class="form-input" type="text" placeholder="EmailID" path="billing.billEmailid"  required="required"/>
 <br>
    <form:input class="form-input" type="text" placeholder="Mobileno" path="billing.billPhnno" required="required" pattern="[789][0-9]{9}"/>
 <br>
     
</div>
</div>
</form>


 <div class="con">
<br>
   <div class="field-set1">
    
   <c:url value="/orderConfirm" var="a"/>
     <form:form action="${a}" method="post" class="form" commandName="shipping"> 
     <header class="head-form">
     <h2>SHIPPING FORM</h2>
   </header>        
    <form:input class="form-input" type="text" placeholder="Firstname"  path="shipFname" required="required"/>
 <br>
	<form:input class="form-input" type="text" placeholder="Lastname" path="shipLname" required="required"/>
 <br>
	<form:input class="form-input" type="text" placeholder="Shipping-ID" path="shipId"  required="true"/>
 <br>
    <form:input class="form-input" type="text" placeholder="Houseno" path="shipHouseno" required="required"/>
 <br>
    <form:input class="form-input" type="text" placeholder="Country" path="shipCountry" required="required"/>
 <br>
	<form:input class="form-input" type="text" placeholder="City" path="shipCity" required="required"/>
 <br>
    <form:input class="form-input" type="text" placeholder="Mobileno" path="shipMobno"  required="required" pattern="[789][0-9]{9}"/>
 <br>
	<form:input class="form-input" type="text" placeholder="EmailID" path="shipEmailid" required="required"/>
 <br>
    <button class="btn submits sign-up"> Submit </button>
     <button class="btn submits sign-up">Cancel</button>
 </form:form>     
</div>

</div>


</div>  
<script  src="js/index.js">
</script>
</body>
</html>
