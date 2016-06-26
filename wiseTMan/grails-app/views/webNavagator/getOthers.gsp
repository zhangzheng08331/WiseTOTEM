<%--
  Created by IntelliJ IDEA.
  User: pc-1
  Date: 2016/6/25
  Time: 17:28
--%>

<%@ page contentType="text/html;charset=UTF-8" %>

<html>
<head>
    <title></title>
    <script type="text/javascript" src="${resource(dir: "js",file: "jquery-1.11.3.min.js")}"></script>
    <script type="text/javascript">
        $("#div1").load("http://news.hao123.com/",data,function(){
            console.log(data);
        })
    </script>
</head>

<body>
    <div id="div1"></div>
</body>
</html>