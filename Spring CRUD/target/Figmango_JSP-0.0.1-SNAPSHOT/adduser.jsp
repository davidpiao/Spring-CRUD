<%@page import="com.crud.dao.userDAO"%>
<jsp:useBean id="u" class="com.crud.bean.user"></jsp:useBean>
<jsp:useBean id="dao" class="com.crud.dao.userDAO"></jsp:useBean>
<jsp:setProperty property="*" name="u" />

<%
int i = dao.insertUser(u);
if (i > 0) {
	response.sendRedirect("adduser-success.jsp");
} else {
	response.sendRedirect("adduser-error.jsp");
}
%>
