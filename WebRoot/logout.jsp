<%@ page language="java" import="java.util.*" pageEncoding="GB18030"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'logout.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
<%
session.invalidate();
 %>
 <script language="JavaScript1.2" type="text/javascript">
�0�2�0�2�0�2 �0�2�0�2�0�2 �0�2�0�2�0�2 
�0�2�0�2 �0�2�0�2 �0�2�0�2�0�2 �0�2�0�2�0�2 window.location.href = "index.jsp";
�0�2�0�2 �0�2�0�2 �0�2�0�2�0�2 �0�2�0�2�0�2
</script>
  </body>
</html>
