<%@ page contentType="text/html; charset=utf-8" language="java" import="java.sql.*" errorPage="" %>
<form id="form1" name="form1" method="post" action="">
  <p>
    <label for="username">用户名</label>
    <input type="text" name="username" id="username" />
  </p>
  <p>
    <label for="password">密码</label>
    <input type="text" name="password" id="password" />
  </p>
  <p>
    <input type="submit" name="apply" id="apply" value="登陆" />
    <input type="reset" name="register" id="register" value="重置" />
  </p>
</form>
<p><a href="register.jsp">立即注册</a></p>