<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"%>
<%
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort() +request.getContextPath()+"/";
%>
<!DOCTYPE html>
<html>
<head>
	<base href="<%=basePath %>">
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>文件上传</title>
</head>
<body>
<%--先搞一个form表单--%>
<center>
    <form action="<%=basePath %>/uploadFile.do" method="post" enctype="multipart/form-data">
        <table border="1px" width="300px">
            <tr>
                <td>大头照</td>
                <%--type=file就会出现一个能选择本地文件的按钮--%>
                <td><input type="file" name="bigHeadImg"></td>
            </tr>
            <tr>
                <%--这里submit类型说明我们后台需要接收！即在controller层uploadFile.do接口写如何接收--%>
                <%--即具体上传方法怎么写，这是在controller层uploadFile.do接口中写的，不是在jsp中写的--%>
                    <%--点击提交后会跳到接口界面进行处理--%>
                <td><input type="submit" value="上传"></td>
                <td><input type="reset" value="重置"></td>
            </tr>
        </table>
    </form>
</center>
</body>
</html>
