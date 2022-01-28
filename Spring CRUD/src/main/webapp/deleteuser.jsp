<%@page import="com.crud.dao.userDAO"%>  
<jsp:useBean id="u" class="com.crud.bean.user"></jsp:useBean>  
<jsp:useBean id="dao" class="com.crud.dao.userDAO"></jsp:useBean>
<jsp:setProperty property="*" name="u"/>  
<%  
dao.deleteUser(u);  
response.sendRedirect("viewusers.jsp");  
%>  