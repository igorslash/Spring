<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%--
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>

</head>
<body>

<h3>Information for all employees</h3>
<br><br>
<security:authorize access="hasRole('HR')">
    <input type="button" value="Salary"
           onclick="window.location.href = 'HR_info'">
</security:authorize>

Only for HR staff
<br><br>
<security:authorize access="hasRole('IT')">
    <input type="button" value="Performance"
           onclick="window.location.href = 'IT_info'">
</security:authorize>

Only for IT staff
<br><br>
<input type="button" value="Performance"
       onclick="window.location.href = 'frame_info'">
Only for Frame staff
<br><br>
</body>
</html>
