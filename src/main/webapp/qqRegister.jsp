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
</head>
<body>
    <center>
        <%--套一个form表单,需要触发ajax ,id=fm为了下面ajax能获取为id的form表单--%>
        <%--触发ajax，在后面写一个ajax用于后台controller层接收submit请求--%>
        <form action="javascript:void(0)" id="fm">
            <table border="1px">
                <tr>
                    <td>昵称</td>
                    <td><input type="text" name="nick"></td>
                </tr>
                <tr>
                    <td>密码</td>
                    <td><input type="text" name="pwd"></td>
                </tr>
                <tr>
                    <td>手机号</td>
                    <td><input type="text" name="phone"></td>
                </tr>
                <tr>
                    <td>邮箱</td>
                    <td><input type="text" name="em"></td>
                </tr>
                <tr>
                    <td>年龄</td>
                    <td><input type="text" name="age"></td>
                </tr>
                <tr>
                    <td><input type="submit" value="注册"></td>
                    <td><input type="reset" value="重置"></td>
                </tr>
            </table>
        </form>
    </center>

    <%--给type=submit添加时间，当点击注册，要通过ajax把上面注册信息值全部变成json--%>
    <%--然后传到IndexController中addQQ方法中去接收--%>
    <%--其实写ajax就是因为上面type=submit 表明我们后台需要接收，即在controller层写一个下面指定的addQQ.do接口--%>
    <script type="text/javascript">
        $(function(){
            $("input[type=submit]").click(function(){
                var jsonData = $("#fm").serializeObject();
                alert(jsonData);    //得到的jsonData是json型的字符串
                alert(JSON.stringify(jsonData));    //把json字符串转json
                $.ajax({
                    url:"<%=basePath %>/addQQ.do",  //这说明是从jsp界面跳到controller层，反过来了
                    type:"post",
                    dataType:"json",
                    contentType: 'application/json',
                    data:JSON.stringify(jsonData),
                    success:function(result) {
                        alert(result)       //alert是打印的意思
                    }
                })


            })
        });

    </script>
</body>
</html>



