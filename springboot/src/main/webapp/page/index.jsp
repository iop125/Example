<%--
  Created by IntelliJ IDEA.
  User: miaoyu1
  Date: 2019-03-13
  Time: 13:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
   来了    老弟！！

   <form  action="/mybaitsController/addaatest2"  method ="post">

      姓名: <input  type="text"  name ="name"> <br>
       年龄:<input  type="text"  name ="age"> <br>
        <input  type="submit" value="go">
   </form>
   <form  action="/redisController/addTest"  method ="post">

       姓名: <input  type="text"  name ="name"> <br>
       年龄:<input  type="text"  name ="age"> <br>
       <input  type="submit" value="go">
   </form>
</body>
</html>
