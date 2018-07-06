<%@taglib prefix="c" uri="http://www.springframework.org/tags" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="c1" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="security" uri="http://www.springframework.org/security/tags" %>

<!DOCTYPE html>
<html lang="en" >
<head>
  <meta charset="UTF-8">
  <title>Checkout</title>
  
 <c:url value="/resources/images/" var="img"/>
 <c:url value="/resources/css/" var="css"/>
 <c:url value="/resources/js/" var="js"/>
  
  <link rel='stylesheet prefetch' href='https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css'>
  <link rel="stylesheet" href="css/style2.css">  
</head>

<style>
.button{
    width: 20%;
    display: inline-block;
    float: left;
    margin-left: 2%;
	color:red;
	background: pink;
}
</style>

<body>
<%@ include file="header.jsp" %>
<br>
<h4>BILLING</h4>
<table border=1px solid grey>
<tr>
<th>BillID</th>
<th>HouseNo</th>
<th>Country</th>
<th>Pincode</th>
<th>EmailID</th>
<th>Mobileno</th>
</tr>

<tr>
<td>${billing.getBillId()}</td>
<td>${billing.getBillHouseno()}</td>
<td>${billing.getBillCity()}</td>
<td>${billing.getBillPincode()}</td>
<td>${billing.getBillEmailid()}</td>
<td>${billing.getBillPhnno()}</td>
</tr>
</table>
<br>
<br>

<h4>SHIPPING</h4>
<table border=1px solid grey>
<tr>
<th>Shipping-ID</th>
<th>Firstname</th>
<th>Lastname</th>
<th>Houseno</th>
<th>Country</th>
<th>City</th>
<th>Mobileno</th>
<th>EmailId</th>
</tr>

<tr>
<td>${shipping.getShipId()}</td>
<td>${shipping.getShipFname()}</td>
<td>${shipping.getShipLname()}</td>
<td>${shipping.getShipHouseno()}</td>
<td>${shipping.getShipCountry()}</td>
<td>${shipping.getShipCity()}</td>
<td>${shipping.getShipMobno()}</td>
<td>${shipping.getShipEmailid()}</td>
</tr>
</table>
<br>
<br>

<h4>PRODUCT</h4>
<table border=1px solid grey>
<tr>
<th>ProductImage</th>
<th>ProductId</th>
<th>ProductName</th>
<th>ProductDesc</th>
<th>ProductPrice</th>
<th>ProductQuantity</th>
<th>Category Name</th>
<th>SupplierName</th>
</tr>

<c1:if test="${prot!=null}">
<tr>
<td><img src="<c:url value="/resources/images/${prot.getProductId()}.jpg"/>" width=150px height=200px></td>
<td>${prot.getProductId()}</td>
<td>${prot.getProductName()}</td>
<td>${prot.getProductDesc()}</td>
<td>${prot.getProductPrice()}</td>
<td>${prot.getProductQty()}</td>
<td>${prot.getCategory().getCatName()}</td>
<td>${prot.getSupplier().getSupplierName()}</td>
</tr>
</c1:if>

<c1:if test="${prot==null}">
 <c1:forEach items="${cartItems}" var="c">
 <tr>
  <td> <img src="<c:url value="/resources/images/${c.getProduct().getProductId()}.jpg"/>" width="100px" height="100px">
  <td> ${c.getProduct().getProductId()}</td>
  <td> ${c.getProduct().getProductName()}</td>
  <td> ${c.getProduct().getProductDesc()}</td>
   <td>${c.getProduct().getProductPrice()}</td>
    <td> ${c.getProduct().getProductQty()}</td>
  <td> ${c.getProduct().getCategory().getCatName()}</td>
  <td> ${c.getProduct().getSupplier().getSupplierName()}</td>
 </tr>
 </c1:forEach>
</c1:if>
</table>
<button class="btn submits sign-up" ><a href="<c:url value='/previous'/>">PREVIOUS</a></button>
 <button class="btn submits sign-up"><a href="<c:url value="/pay"/>">PAY</a></button>

</body>
</html>