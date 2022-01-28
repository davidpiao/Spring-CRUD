<!DOCTYPE html>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>View Users</title>
</head>
<body>

	<%@page import="com.crud.dao.userDAO,com.crud.bean.*,java.util.*"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
	<jsp:useBean id="dao" class="com.crud.dao.userDAO"></jsp:useBean>
	
	<h1>Users List</h1>

	<%
	List<user> list = dao.getUserList();
	request.setAttribute("list", list);
	%>

	<table border="1" width="90%">
		<tr>
			<th>Seq</th>
			<th>Title</th>
			<th>Writer</th>
			<th>Content</th>
			<th>Edit</th>
			<th>Delete</th>
		</tr>
		<c:forEach items="${list}" var="u">
			<tr>
				<td>${u.getSeq()}</td>
				<td>${u.getTitle()}</td>
				<td>${u.getWriter()}</td>
				<td>${u.getContent()}</td>
				<td><a href="editform.jsp?id=${u.getSeq()}">Edit</a></td>
				<td><a href="deleteuser.jsp?id=${u.getSeq()}">Delete</a></td>
			</tr>
		</c:forEach>
	</table>
	<br />
	<a href="adduserform.jsp">Add New User</a>

</body>
</html>
