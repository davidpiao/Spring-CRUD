<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Edit Form</title>
</head>
<body>
	<%@page import="com.crud.dao.userDAO,com.crud.bean.user"%>
	<jsp:useBean id="dao" class="com.crud.dao.userDAO"></jsp:useBean>

	<%
	String seq = request.getParameter("seq");
	user u = dao.getUser(Integer.parseInt(seq));
	%>

	<h1>Edit Form</h1>
	<form action="edituser.jsp" method="post">
		<input type="hidden" name="id" value="<%=u.getSeq()%>" />
		<table>
			<tr>
				<td>Title:</td>
				<td><input type="text" name="title" value="<%=u.getTitle()%>" /></td>
			</tr>
			<tr>
				<td>Writer:</td>
				<td><input type="writer" name="writer"
					value="<%=u.getWriter()%>" /></td>
			</tr>
			<tr>
				<td>Email:</td>
				<td><input type="content" name="content" value="<%=u.getContent()%>" /></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="Edit User" /></td>
			</tr>
		</table>
	</form>

</body>
</html>
