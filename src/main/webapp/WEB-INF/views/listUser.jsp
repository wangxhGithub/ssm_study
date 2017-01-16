<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>User list</title>
</head>
<body>
  	<h3>UserList</h3>
  	<a href="<%=path %>/userController/toAddUser.do">Add User</a><br/>
	<table border="1" width="70%">
   		<tr>
   			<td>Id</td>
   			<td>Name</td>
   			<td>Age</td>
   			<td>Address</td>
   			<td>Delete</td>
   			<td>Update</td>
   			<td>Json</td>
   		</tr>
   		<c:forEach items="${userlist}" var="user">
   		<tr>
   			<td>${user.id }</td>
   			<td>${user.name }</td>
   			<td>${user.age }</td>
   			<td>${user.address }</td>
   			<td><a href="<%=path %>/userController/deleteUser.do?id=${user.id }">Delete</a></td>
   			<td><a href="<%=path %>/userController/updateUserUI.do?id=${user.id }">Update</a></td>
   			<td><a href="<%=path %>/userController/toJson.do?id=${user.id }">Json</a></td>
   		</tr>
   		</c:forEach>
   </table>
   
</body>
</html>