<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"%>
<%
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort() +request.getContextPath()+"/";
%>
<!DOCTYPE html>
<html>
<head>
	<base href="<%=basePath %>">
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>QQ注册</title>
    <%--做ajax前需进入jquery--%>
    <script type="text/javascript" src="<%=basePath %>/static/js/jquery-1.8.2.min.js"></script>
    <%--引用表单数据快速生成json--%>
    <script type="text/javascript" src="<%=basePath %>/static/js/jsonHandler.js"></script>

    <style type="text/css">
        span{
            color:red;
            font-size: 12px;
        }
        tr>td:nth-child(1){
            width: 100px;
        }
    </style>

</head>
<body>
    <center>
        <%--此时表示url登录jsp页面后，通过action会指定到后台数据库--%>
        <form action="<%=basePath %>/addQQInfo.do" >
            <table border="1px" width="600px">
                <tr>
                    <td>昵称</td>
                    <td><input type="text" name="nick" value="${errorMap.nick==null?qqInfo.nick:''}">
                        <span>${errorMap.nick}</span>
                    </td>
                </tr>
                <tr>
                    <td>密码</td>
                    <td><input type="text" name="pwd" value="${errorMap.pwd==null?qqInfo.pwd:''}">
                        <span>${errorMap.pwd}</span>
                    </td>
                </tr>
                <tr>
                    <td>手机号</td>
                    <%--追加前端校验--%>
                    <td><input type="text" name="phone" value="${errorMap.phone==null?qqInfo.phone:''}">
                        <span>${errorMap.phone}</span>
                    </td>
                </tr>
                <tr>
                    <td>邮箱</td>
                    <td><input type="text" name="em" value="${errorMap.em==null?qqInfo.em:''}">
                        <span>${errorMap.email}</span>
                    </td>
                </tr>
                <tr>
                    <td>年龄</td>
                    <td><input type="text" name="age" value="${errorMap.age==null?qqInfo.age:''}">
                        <span>${errorMap.age}</span>
                    </td>
                </tr>
                <tr>
                    <td><input type="submit" value="注册"></td>
                    <td><input type="reset" value="重置"></td>
                </tr>
            </table>
        </form>
    </center>

</body>
</html>



