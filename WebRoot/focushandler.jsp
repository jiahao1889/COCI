<%@ page language="java"
	import="java.sql.Timestamp,java.sql.ResultSet,java.sql.Date,com.COCI.*,java.util.ArrayList,java.util.*"
	pageEncoding="GB18030"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<!-- InstanceBegin template="/Templates/index.dwt.jsp" codeOutsideHTMLIsLocked="false" -->
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<!-- InstanceBeginEditable name="doctitle" -->
		<title>ȫ����б�</title>
		<!-- InstanceEndEditable -->
		<!-- InstanceBeginEditable name="head" -->
		<!-- InstanceEndEditable -->
		<style type="text/css">
<!--
body {
	font: 100%/1.4 Verdana, Arial, Helvetica, sans-serif;
	background: #42413C;
	margin: 0;
	padding: 0;
	color: #000;
}

/* ~~ Ԫ��/��ǩѡ���� ~~ */
ul,ol,dl {
	/* ���������֮��Ĳ��죬������������б��н����ͱ߾඼����Ϊ�㡣Ϊ�˱���һ�£��������ڴ˴�ָ����Ҫ����ֵ��Ҳ�������б����������б��LI��DT �� DD����ָ����Ҫ����ֵ����ע�⣬���Ǳ�дһ����Ϊ�����ѡ�������������ڴ˴����е����ý������� .nav �б� */
	padding: 0;
	margin: 0;
}

h1,h2,h3,h4,h5,h6,p {
	margin-top: 0;
	/* ɾ���ϱ߾���Խ���߾�ᳬ��������� div �����⡣ʣ����±߾����ʹ div �������κ�Ԫ�ر���һ�����롣 */
	padding-right: 15px;
	padding-left: 15px;
	/* �� div �ڵ�Ԫ�ز�ߣ������� div ����������ɱ���ʹ���κη���ģ����ѧ�����⣬Ҳ�ɽ����в������Ƕ�� div ������������� */
}

a img { /* ��ѡ������ɾ��ĳЩ���������ʾ��ͼ����Χ��Ĭ����ɫ�߿򣨵���ͼ�������������ʱ�� */
	border: none;
	display: none;
}

/* ~~ վ�����ӵ���ʽ���뱣�ִ�˳�򣬰������ڴ�����ͣЧ����ѡ���������ڡ� ~~ */
a:link {
	color: #42413C;
	text-decoration: underline;
	/* ���ǽ��������óɼ�Ϊ���ص������ʽ����������ṩ�»��ߣ��Ա�ɴ��Ӿ��Ͽ���ʶ�� */
}

a:visited {
	color: #6E6C64;
	text-decoration: underline;
}

a:hover,a:active,a:focus { /* ����ѡ������Ϊ���̵������ṩ�����ʹ������ͬ����ͣ���顣 */
	text-decoration: none;
}

/* ~~ �˹̶���������������� div ~~ */
.container {
	width: 960px;
	background: #FFF;
	margin: 0 auto; /* ��ߵ��Զ�ֵ���Ƚ��ʹ�ã����Խ����־��ж��� */
}

/* ~~ ����δָ����ȡ�������չ�����ֵ�������ȡ��������һ��ͼ��ռλ������ռλ��Ӧ�滻Ϊ���Լ������ӻձ� ~~ */
.header {
	background: #ADB96E;
}

/* ~~ ���ǲ�����Ϣ�� ~~ 

1) ���ֻ������� div �Ķ�����/��ײ����� div �е�Ԫ�ز�߻�����䡣�����������Ա���ʹ���κΡ�����ģ����ѧ������ע�⣬����� div ��������κβ������߿���Щ�������߿���������Ŀ����ӣ��ó� *�ܼ�* ��ȡ���Ҳ����ѡ��ɾ�� div �е�Ԫ�ص���䣬���ڸ�Ԫ�����������һ��û���κο�ȵ���������������� div��

*/
.content {
	padding: 10px 0;
}

/* ~~ ��ע ~~ */
.footer {
	padding: 10px 0;
	background: #CCC49F;
}

/* ~~ ��������/����� ~~ */
.fltrt { /* �����������ҳ����ʹԪ�����Ҹ���������Ԫ�ر���λ������ҳ���ϵ�����Ԫ��֮ǰ�� */
	float: right;
	margin-left: 8px;
}

.fltlft { /* �����������ҳ����ʹԪ�����󸡶�������Ԫ�ر���λ������ҳ���ϵ�����Ԫ��֮ǰ�� */
	float: left;
	margin-right: 8px;
}

.clearfloat {
	/* ����� #container ��ɾ�����Ƴ��� #footer������Խ���������� <br /> ��� div �У���Ϊ #container �����һ������ div ֮�������Ԫ�� */
	clear: both;
	height: 0;
	font-size: 1px;
	line-height: 0px;
}
-->
</style>
		<script src="SpryAssets/SpryMenuBar.js" type="text/javascript">
</script>
		<link href="SpryAssets/SpryMenuBarHorizontal.css" rel="stylesheet"
			type="text/css" />
	</head>

	<body>

		<div class="container">
			<div class="header">
				<table width="960" border="0">
					<tr>
						<td width="650">
							<img src="logo.jpg" width="650" height="90" />
						</td>
						<td width="295"><%@ include file="login.jsp"%></td>
					</tr>
				</table>
				<!-- end .header -->
			</div>
			<ul id="MenuBar1" class="MenuBarHorizontal">
				<li>
					<a href="index.jsp">��ҳ</a>
				</li>
				<li>
					<a href="news.jsp">������Ϣ</a>
				</li>
				<li>
					<a class="MenuBarItemSubmenu" href="actlista.jsp">�鿴�</a>
					<ul>
						<li>
							<a href="actlista.jsp">ȫ�������</a>
						</li>
						<li>
							<a href="actlistp.jsp">���˻����</a>
						</li>
					</ul>
				</li>
				<li>
					<a href="grouplist.jsp">���ŷ���</a>
				</li>
				<li>
					<a href="actmanage.jsp">�����</a>
				</li>
				<li>
					<a href="help.jsp" class="header">����</a>
				</li>
			</ul>
			<div class="content">
				<!-- InstanceBeginEditable name="TextEditRegion" -->

				<%
					Student auser = (Student) session.getAttribute("muser");
					String i = request.getParameter("aid");
					int ac_id = Integer.parseInt(i);
					String j = request.getParameter("useid");
					int use_id = Integer.parseInt(j);
					String k = request.getParameter("focus");
					auser.Focus(use_id, ac_id, k);
				%>
				<br></br>

				<span id="time" style="background: red">5</span>���Ӻ��Զ���ת���������ת��������������
				�0�2�0�2�0�2 �0�2�0�2�0�2
				<script language="JavaScript1.2" type="text/javascript">
�0�2�0�2�0�2 �0�2�0�2�0�2 �0�2�0�2�0�2 <!--
�0�2�0�2�0�2 �0�2�0�2�0�2 �0�2�0�2�0�2 function delayURL(url) {�0�2�0�2�0�2�0�2�0�2�0�2�0�2�0�2�0�2�0�2�0�2�0�2�0�2�0�2 //��ʱ��ת
�0�2�0�2�0�2 �0�2�0�2 �0�2�0�2 var delay = document.getElementById("time").innerHTML;
�0�2�0�2�0�2 �0�2�0�2�0�2 �0�2�0�2�0�2 if(delay > 0) {
�0�2�0�2�0�2 �0�2�0�2�0�2 �0�2�0�2�0�2 delay--;
�0�2�0�2�0�2 �0�2�0�2�0�2 �0�2�0�2�0�2 document.getElementById("time").innerHTML = delay;
�0�2�0�2 �0�2�0�2 �0�2�0�2�0�2 } else {
�0�2�0�2 �0�2�0�2 �0�2�0�2�0�2 �0�2�0�2�0�2 window.top.location.href = url;
�0�2�0�2 �0�2�0�2 �0�2�0�2�0�2 �0�2�0�2�0�2 }
�0�2�0�2 �0�2�0�2 �0�2�0�2�0�2 setTimeout("delayURL('" + url + "')", 1000); 
�0�2�0�2�0�2 �0�2�0�2�0�2 }
�0�2�0�2�0�2 �0�2�0�2�0�2 //-->
�0�2�0�2�0�2 </script>
				�0�2�0�2�0�2
				<a href="actdetail.jsp?id=<%=ac_id%>">����</a> �0�2�0�2�0�2
				<script type="text/javascript">
�0�2�0�2�0�2 delayURL("actdetail.jsp?id=<%=ac_id%>");
�0�2�0�2�0�2 </script>
				�0�2�0�2�0�2

				<!-- InstanceEndEditable -->
				<!-- end .content -->
			</div>
			<div class="footer">
				<p>
					Copyright 2010.9-2010.12, COCI Group. all rights reserved.
				</p>
				<!-- end .footer -->
			</div>
			<!-- end .container -->
		</div>
		<script type="text/javascript">
var MenuBar1 = new Spry.Widget.MenuBar("MenuBar1", {
	imgDown : "../SpryAssets/SpryMenuBarDownHover.gif",
	imgRight : "../SpryAssets/SpryMenuBarRightHover.gif"
});
</script>
	</body>
	<!-- InstanceEnd -->
</html>
