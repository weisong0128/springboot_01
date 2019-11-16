<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort() +request.getContextPath()+"/";
%>
<!DOCTYPE html>
<html>
<head>
    <base href="<%=basePath %>">
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>new jsp</title>
</head>
<body>
    <%--<h1>访问jsp顺利</h1>--%>
    <center>
        <table border="1px" width="800px">
            <thead>
                <tr>
                    <th>主键</th>
                    <th>用户名</th>
                    <th>余额</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${userList}" var="map">
                    <tr>
                        <td>${map.id}</td>
                        <td>${map.username}</td>
                        <td>${map.money}</td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </center>

</body>
</html>
