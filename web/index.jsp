<%@ page import="com.cppor.codes.jspLearn.common.StringUtils" %>
<%@ page import="com.cppor.codes.jspLearn.bean.Student" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="my" uri="http://cppor.com" %>

<%--
  Created by IntelliJ IDEA.
  User: ZhangHY
  Date: 2016/9/26
  Time: 13:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" errorPage="error.jsp" %>
<%
    String title = "a11";
    String[] temp = new String[]{"title1", "titl2", "title3"};
    Student stud = new Student();
    stud.setName("henry");
    request.setAttribute("stu", stud);
    request.setAttribute("temp", temp);
%>
<html>
<head>
    <meta http-equiv="content-type" content="text/html; charset=utf-8"/>
    <meta charset="utf-8"/>
    <title><%=StringUtils.toHtml(title)%>
    </title>
</head>
<body>
<jsp:include page="header.jsp"></jsp:include>
<%--<jsp:forward page="404.jsp"></jsp:forward>--%>

<form action="login" method="post">
    <%
        Object username = session.getAttribute("username");
        if (null != username) {
            out.write("欢迎你：" + username.toString());
        }

        String id = request.getParameter("id");
        if (null != id) {
            int i = Integer.parseInt(id);

            for (int c = 1; c < i; ++c) {
                out.write("suc:" + c + "<br />");
            }
        }
    %>

    <ul>
        <c:forEach items="${temp}" var="e" >
            <li>${e}</li>
        </c:forEach>
    </ul>

    ${true && false}
    ${stud.name}
    username:<input id="username" name="username1" type="text" value="${stu.name}"/>
    password:<input id="password" name="password1" type="text" value=""/>
    <input type="submit"/>
    <my:login username="userName" password="userPwd"></my:login>
<my:choose>
    <my:when test="${10>5}">
        测试大于
    </my:when>
    <my:else1>
        测试小于 elsel中的
    </my:else1>
</my:choose>
</form>
</body>
</html>
