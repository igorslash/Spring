<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: 12
  Date: 24.04.2022
  Time: 20:19
  To change this template use File | Settings | File Templates.
--%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h2>Employee, please enter your details</h2>
<br>
<br>
<%--Сложный способ--%>
<form: form action = "showDetails" modelAttribute="employee">
    Name <form: input path="name"/>
    <form:errors path="name"/><%--Прщверка валидации на ошибки--%>
    <br><br>
    Surname <form: input path="surname"/>
    <form:errors path="surname"/>
    <br><br>
    Salary <form: input path="salary"/>
    <br><br>
    Department <form: select path="department"/>
    <form: options items="${employee.departments}"/><%--более лёгкие способы--%>
    <br><br>
    Which car do you want?
    <form: radiobuttons path="CarBrands" items="${employee.carBrand}"/>
    <br><br>
    Foreign language(s)
    <form: checkbox path="languages" items="${employee.languagesList}"/>
    <br><br>
    PhoneNumber <form: input path="phoneNumber"/>
    <form:errors path="phoneNumber"/>
    <br><br>
    Email <form: input path="emailAddress"/>
    <form:errors path="emailAddress"/>
    <br><br>
    <input type="submit" value="ok">
</form:>

</body>
</html>
