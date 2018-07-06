<%@taglib prefix="c" uri="http://www.springframework.org/tags" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="c1" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="security" uri="http://www.springframework.org/security/tags" %>

<!DOCTYPE html>
<html lang="en" >
<head>
  <meta charset="UTF-8">
  
  <c:url value="/resources/images/" var="img"/>
 <c:url value="/resources/css/" var="css"/>
 <c:url value="/resources/js/" var="js"/>
 
  <title>Checkout</title>
  <link rel='stylesheet prefetch' href='https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css'>
  <link rel="stylesheet" href="${css}/style2.css">
  
</head>

<body>
<%@ include file="header.jsp" %>
<br>
<table border=1px solid grey>
<tr>
<th>ProductId</th>
<th>ProductImage</th>
<th>Price</th>
<th>Category</th>
<th>Actions</th>
</tr>

<c1:forEach items="${cartItem}" var="prod">
<tr>
<td>${prod.getProduct().getProductId()}</td>
<td>${prod.getProduct().getProductName()}</td>
<td>${prod.getProduct().getProductPrice()}</td>
<td>${prod.getProduct().getCategory().getCatName()}</td>
<td>
<a href="<c:url value='/remove/${prod.getCtItemsId()}'/>">REMOVE</a> /<a href="<c:url value='/Buy/${prod.getProduct().getProductId()}/${prod.getCtItemsId()}'/>">BUY</a>
</td>
</tr>
</c1:forEach>
</table>

<div class="submits">
<button class="btn submits sign-up" style="color:#ff8080;"><a href="<c:url value='/Removeall'/>">Remove All</a></button>
  <button class="btn submits sign-up" style="color:#ff8080;"><a href="<c:url value="/Buyall"/>">Buy All</a></button>
</div>

</body>
</html>