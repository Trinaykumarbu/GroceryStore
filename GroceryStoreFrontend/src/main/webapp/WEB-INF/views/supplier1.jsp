<%@taglib prefix="c" uri="http://www.springframework.org/tags" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="c1" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="security" uri="http://www.springframework.org/security/tags" %>

<!DOCTYPE html>
<html lang="en" >
<head>
  <meta charset="UTF-8">
  <title>Supplier-form</title>
  
 <c:url value="/resources/images/" var="img"/>
 <c:url value="/resources/css/" var="css"/>
 <c:url value="/resources/js/" var="js"/>
 
 <link rel='stylesheet prefetch' href='https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css'>
 <link rel="stylesheet" href="${css}/style2.css">
</head>

<body>
<%@ include file="header.jsp" %>
  <div class="overlay">
  ${msg5}
  <c:url value="/addSupplier" var="supplier"/>
<form:form action="${supplier}" method="post" commandName="supplier" style="margin-left:450px;"> 
   <div class="con" style="align:center;">
   <header class="head-form">
      <h2>SUPPLIER FORM</h2>   
   </header>
   <br>
   <div class="field-set">      
      <form:input class="form-input" id="txt-input" type="text" placeholder="Supplier-ID" path="supplierId" required="required"/>  
      <br>
      <form:input class="form-input" type="text" placeholder="Supplier-name" path="supplierName" required="required"/>  
      <br>
      <form:input class="form-input" type="text" placeholder="Supplier-Address"  path="supplierAddress" required="required"/>  
      <br>
	  <form:input class="form-input" type="text" placeholder="Phone-no"  path="supplierPhnno" required="required" pattern="[789][0-9]{9}"/>  
	  <br>
	  <form:input class="form-input" type="text" placeholder="E-mailId"  path="supplierEmailid" required="required"/>  
	  <br>
	  
      <button class="btn submits sign-up"> Submit </button>
	  <button class="btn submits sign-up">Cancel</button>
   </div>
  </div>
 </form:form>
</div>  

<table border=1px solid grey>
<tr>
<th>SupplierId</th>
<th>SupplierName</th>
<th>SupplierAddress</th>
<th>SupplierPhnno</th>
<th>SupplierEmailid</th>
<th>Actions</th>
</tr>
<c1:forEach items="${suppliers}" var="sup">
<tr>
<td>${sup.getSupplierId()}</td>
<td>${sup.getSupplierName()}</td>
<td>${sup.getSupplierAddress()}</td>
<td>${sup.getSupplierPhnno()}</td>
<td>${sup.getSupplierEmailid()}</td>
<td><a href="<c:url value='/editSupplier/${sup.getSupplierId()}'/>">EditSupplier</a>/<a href="<c:url value='/deleteSupplier/${sup.getSupplierId()}'/>">DeleteSupplier</a>
</tr>
</c1:forEach>
</table>

<script  src="js/index.js">
</script>
</body>
</html>
