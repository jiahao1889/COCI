<%@ page contentType="text/html; charset=utf-8" language="java" import="java.sql.*,com.COCI.*" errorPage="" %>
<%
    if(session.getAttribute("muser")==null){ 
    if(request.getParameter("usernamel")==null&&request.getParameter("passwordl")==null){%>
<form id="form1" name="form1" method="post" action="">
  <p>
    <label for="usernamel">用户名</label>
    <input type="text" name="usernamel" id="usernamel" />
  </p>
  <p>
    <label for="passwordl">密码</label>
    <input type="text" name="passwordl" id="passwordl" />
  </p>
  <p>
    <input type="submit" name="apply" id="apply" value="登陆" />
    <input type="reset" name="register" id="register" value="重置" />
  </p>
</form>
<p><a href="register.jsp">立即注册</a></p>
<%
}
  else
  {
      int islog = 0;
      String name = request.getParameter("usernamel");
      String pass = request.getParameter("passwordl");
      if(name!=null&&pass!=null)
      {
          User auser = new User(name,pass);
          islog = auser.Login();
          if(islog==1)
          {
             session.setAttribute("muser",new Student(name,pass));
             session.setAttribute("auth","1");
          }
          else if(islog==2)
          {
             session.setAttribute("muser",new Group(name,pass));
             session.setAttribute("auth","2");
          }
          else if(islog == 3)
          {
             session.setAttribute("muser",new Admin(name,pass));
             session.setAttribute("auth","3");
          }
          
      }
      if(islog==0)
      {
      %>
          <p>登录失败！</p>
          <p><a href="">重新登录</a></p>
          
      <% 
         
      }
      else
      {
      %>
      <p>您好！<%=name%></p>
      <p><a href="logout.jsp">退出</a></p>
      <%
          
      }
  }
}
    else
    {
        User auser = (User)session.getAttribute("muser");
        String name = auser.getName();   
    %>
<p>您好！<%=name%></p>
<p><a href="logout.jsp">退出</a></p>
<%} %>
    