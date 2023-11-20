<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>input_data</h1>
	<form:form action="input_pro" modelAttribute="dataBean1" method="post">
	<h5>JSR-303/380 --- @Size </h5>
	data1 : <form:input path="data1"/><br/><!-- type="text"는 생략가능 -->
			<form:errors path="data1" /><br/>
	<hr/>
	<h5>rejectIfEmpty & length() &lt; 10</h5>
	data2 : <form:input path="data2"/><br/>
			<form:errors path="data2" /><br/>
	<hr/>
	<h5>rejectIfEmptyOrWhitespace & contains("@")</h5>
	data3 : <form:input path="data3"/><br/>
			<form:errors path="data3" /><br/>
	<hr/>
	<form:button type="submit">확인</form:button>
	</form:form>
</body>
</html>