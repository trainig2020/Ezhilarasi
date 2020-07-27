<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<a href="/SpringMVC_CRUD/showForm?siteLanguage=en">English</a>|
	<a href="/SpringMVC_CRUD/showForm?siteLanguage=fr">French</a>


	<form action="save" method="post">
		<c:if test="${employee.empId != null}">
			<form action="update" method="post">
		</c:if>

		<table>
			<tr>
				<c:if test="${employee != null}">
					<input type="hidden" name="empId" value="<c:out value='${employee.empId}' />" />
				</c:if>
			</tr>
			<tr>
				<td><spring:message code="label.empId" /></td>
				<td><input type="text" name="empId"></td>
			</tr>
			<tr>
				<td><spring:message code="label.empName" /></td>
				<td><input type="text" name="empName"></td>
			</tr>
			<tr>
				<td><spring:message code="label.age" /></td>
				<td><input type="text" name="age"></td>
			</tr>
			<tr>
				<td><spring:message code="label.deptId" /></td>
				<td><input type="text" name="deptId"></td>
			</tr>
			<tr>
				<td><input type="submit" value="submit"></td>
			</tr>


		</table>
	</form>
</body>
</html>