<%@page import="com.crud.dao.userDAO"%>
<jsp:useBean id="u" class="com.crud.bean.user"></jsp:useBean>
<jsp:setProperty property="*" name="u" />
<%
int i = userDAO.update(u);
response.sendRedirect("viewusers.jsp");
%>
