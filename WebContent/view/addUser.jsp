<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add user</title>
<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/files/css/style.css">
</head>
<body>
<h4>Submit your information</h4>
<hr/>
<form:form modelAttribute="user" action="addUser">

	Name: <form:input path="name" required="true" placeholder="Enter name"/>
	<p/>
	<form:errors path="name" cssStyle="color:red"/>
	<p/>
	Gender: 
	Male:<form:radiobutton path="gender" value="Male" required="true" />
	Female: <form:radiobutton path="gender" value="Female" required="true" />
	<p/>
	Country: <form:select path="country">
			<form:option value="India"> </form:option>
			<form:option value="Romania"> </form:option>
			<form:option value="USA" label="United States"> </form:option>
			<form:option value="UK" label="United Kingdom"> </form:option>
			
	</form:select>
	<p/>
	Email: <form:textarea path="email" required="true" placeholder="Enter email"/>
	<p/>
	<form:errors path="email" cssStyle="color:red"/>
	<p/>
	Visited countries:
	China: <form:checkbox path="visitedCountries" value="China"/>
	Taiwan: <form:checkbox path="visitedCountries" value="Taiwan"/>
	India: <form:checkbox path="visitedCountries" value="India"/>
	Austria: <form:checkbox path="visitedCountries" value="Austria"/>
	<p/>
	
	<input type="submit" value="submit">
	

</form:form>


</body>
</html>
