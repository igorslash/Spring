<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:useBean id="employee" scope="request" type="sun.security.x509.X500Name"/>
<%--
  Created by IntelliJ IDEA.
  User: 12
  Date: 24.04.2022
  Time: 20:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h2>Employee, you are Welcome</h2>
<br>
<%--Your name: ${param.employeeName}--%>
Your name: ${employee.name}
<br>
Your surname: ${employee.surname}
<br>
Your salary: ${employee.salary}
<br>
Your department: ${employee.department}
<br>
Language(s):
<ul>
    <c:forEach var="lang" items="${employee.languages}">

        <li>${lang}</li>

    </c:forEach>
</ul>
<br>
Phone Number: ${employee.phoneNumber}
<br>
EmailAddress: ${employee.emailAdress}
</body>
</html>
