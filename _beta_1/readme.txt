1.将提供的源码压缩包解压放置到服务器端。
2.安装mySQL，在mySQL的命令行窗口输入
   create database coci;（一定要为coci）
   use coci;
   source f:COCI.sql;(此处示例将COCI.sql直接放置在F盘根目录下的情况，其他情况同理）。
3.（很重要）修改sqlString.java中的usrname及password，设置成运行服务器端所安装的mySQL时的参数设置。
4.访问index.jsp。
5.系统预先设定了一些用户：
  角色         用户        密码
  系统管理员   admin      admin
  社团         group      group
  学生         student    student
6.祝浏览愉快。