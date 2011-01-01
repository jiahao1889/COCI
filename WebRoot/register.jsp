<%@ page contentType="text/html; charset=utf-8" language="java"
	import="java.sql.*" errorPage=""%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<!-- InstanceBegin template="/Templates/index.dwt.jsp" codeOutsideHTMLIsLocked="false" -->
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<!-- InstanceBeginEditable name="doctitle" -->
		<title>注册</title>
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

/* ~~ 元素/标签选择器 ~~ */
ul,ol,dl {
	/* 由于浏览器之间的差异，最佳做法是在列表中将填充和边距都设置为零。为了保持一致，您可以在此处指定需要的数值，也可以在列表所包含的列表项（LI、DT 和 DD）中指定需要的数值。请注意，除非编写一个更为具体的选择器，否则您在此处进行的设置将会层叠到 .nav 列表。 */
	padding: 0;
	margin: 0;
}

h1,h2,h3,h4,h5,h6,p {
	margin-top: 0;
	/* 删除上边距可以解决边距会超出其包含的 div 的问题。剩余的下边距可以使 div 与后面的任何元素保持一定距离。 */
	padding-right: 15px;
	padding-left: 15px;
	/* 向 div 内的元素侧边（而不是 div 自身）添加填充可避免使用任何方框模型数学。此外，也可将具有侧边填充的嵌套 div 用作替代方法。 */
}

a img { /* 此选择器将删除某些浏览器中显示在图像周围的默认蓝色边框（当该图像包含在链接中时） */
	border: none;
	display: none;
}

/* ~~ 站点链接的样式必须保持此顺序，包括用于创建悬停效果的选择器组在内。 ~~ */
a:link {
	color: #42413C;
	text-decoration: underline;
	/* 除非将链接设置成极为独特的外观样式，否则最好提供下划线，以便可从视觉上快速识别 */
}

a:visited {
	color: #6E6C64;
	text-decoration: underline;
}

a:hover,a:active,a:focus { /* 此组选择器将为键盘导航者提供与鼠标使用者相同的悬停体验。 */
	text-decoration: none;
}

/* ~~ 此固定宽度容器包含其它 div ~~ */
.container {
	width: 960px;
	background: #FFF;
	margin: 0 auto; /* 侧边的自动值与宽度结合使用，可以将布局居中对齐 */
}

/* ~~ 标题未指定宽度。它将扩展到布局的完整宽度。标题包含一个图像占位符，该占位符应替换为您自己的链接徽标 ~~ */
.header {
	background: #ADB96E;
}

/* ~~ 这是布局信息。 ~~ 

1) 填充只会放置于 div 的顶部和/或底部。此 div 中的元素侧边会有填充。这样，您可以避免使用任何“方框模型数学”。请注意，如果向 div 自身添加任何侧边填充或边框，这些侧边填充或边框将与您定义的宽度相加，得出 *总计* 宽度。您也可以选择删除 div 中的元素的填充，并在该元素中另外放置一个没有任何宽度但具有设计所需填充的 div。

*/
.content {
	padding: 10px 0;
}

/* ~~ 脚注 ~~ */
.footer {
	padding: 10px 0;
	background: #CCC49F;
}

/* ~~ 其它浮动/清除类 ~~ */
.fltrt { /* 此类可用于在页面中使元素向右浮动。浮动元素必须位于其在页面上的相邻元素之前。 */
	float: right;
	margin-left: 8px;
}

.fltlft { /* 此类可用于在页面中使元素向左浮动。浮动元素必须位于其在页面上的相邻元素之前。 */
	float: left;
	margin-right: 8px;
}

.clearfloat {
	/* 如果从 #container 中删除或移出了 #footer，则可以将此类放置在 <br /> 或空 div 中，作为 #container 内最后一个浮动 div 之后的最终元素 */
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
					<a href="index.jsp">首页</a>
				</li>
				<li>
					<a href="news.jsp">最新消息</a>
				</li>
				<li>
					<a class="MenuBarItemSubmenu" href="actlista.jsp">查看活动</a>
					<ul>
						<li>
							<a href="actlista.jsp">全部活动日历</a>
						</li>
						<li>
							<a href="actlistp.jsp">个人活动日历</a>
						</li>
					</ul>
				</li>
				<li>
					<a href="grouplist.jsp">社团分类</a>
				</li>
				<li>
					<a href="actmanage.jsp">活动管理</a>
				</li>
				<li>
					<a href="help.jsp" class="header">帮助</a>
				</li>
			</ul>
			<div class="content">
				<h1>
					<!-- InstanceBeginEditable name="TitleEditRegion" -->
					注册
					<!-- InstanceEndEditable -->
				</h1>
				<!-- InstanceBeginEditable name="TextEditRegion" -->
				<form id="form1" name="form1" method="post" action="register2.jsp"
					onsubmit="return check()">
					<p>
						<label for="username">
							用户名*
						</label>
						<input type="text" name="username" id="username" />
					</p>
					<p>
						<label for="password">
							密码*
						</label>
						<input type="password" name="password" id="password" />
					</p>
					<p>
						<label for="email">
							电子邮箱
						</label>
						<input type="text" name="email" id="email" />
					</p>
					<p>
						<label for="telephone">
							电话
						</label>
						<input type="text" name="telephone" id="telephone" />
					</p>
					<p>
						<input type="checkbox" name="read" id="read" />
						<label for="read">
							我已阅读相关条款
						</label>
					</p>
					<p>
						<input type="submit" name="apply" id="apply" value="提交" />
						<input type="reset" name="empty" id="empty" value="重置" />
					</p>
					<p>
						&nbsp;
					</p>
				</form>
				<script type="text/javascript">
function check() {
	//alert(document.getElementsByName('username')[1].value);
	//var name1 = document.getElementById('username').value;
	//alert(name1.length);
	if (document.getElementById('username').value == "") {
		alert("用户名不能为空");
		return false;
	}

	//alert(document.getElementsByName('password')[1].value);
	if (document.getElementById('password').value == "") {
		alert("密码不能为空");
		return false;
	}

	if (document.getElementById('read').checked == false) {
		alert("尚未 勾选 用户协议 !");
		return false;
	}

	//alert(document.getElementById('email').value);
	//alert(document.getElementsByName('email')[1].value);
	if (document.getElementById('email').value != "") {
		var str = /^([a-zA-Z0-9\._-])+@([a-zA-Z0-9_-])+((\.[a-zA-Z0-9_-]{2,3}){1,2})$/;
		if (!str.test(document.getElementById('email').value)) {
			alert("邮箱格式不正确 !");
			return false;
		}
	}

	//alert(document.getElementById('telephone').value);
	//alert(document.getElementsByName('email')[1].value);
	if (document.getElementById('telephone').value != "") {
		var re = /^((13[0-9]{1})|(15[0-9]{1}))+\d{8}$/; //验证只能为数字的正则表达式   
		if (!re.test(document.getElementById('telephone').value)) {
			alert("电话格式错误 !");
			return false;
		}
	}

	return true;

}
</script>

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
