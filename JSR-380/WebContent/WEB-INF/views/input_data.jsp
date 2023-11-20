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
		<h4>@NotEmpty</h4>
		data1 : <form:input path="data1" type="text"/><br/>
				<form:errors path="data1" /><br/>
		<hr/>
		<h4>@NotBlank</h4>
		data2 : <form:input path="data2" type="text"/><br/>
				<form:errors path="data2" /><br/>
		<hr/>
		<h4>@Positive</h4>
		data3 : <form:input path="data3" type="text"/><br/>
				<form:errors path="data3" /><br/>
		<hr/>
		<h4>@PositiveOrZero</h4>
		data4 : <form:input path="data4" type="text"/><br/>
				<form:errors path="data4" /><br/>
		<hr/>
		<h4>@Negative</h4>
		data5 : <form:input path="data5" type="text"/><br/>
				<form:errors path="data5" /><br/>
		<hr/>
		<h4>@NegativeOrZero</h4>
		data6 : <form:input path="data6" type="text"/><br/>
				<form:errors path="data6" /><br/>
		<hr/>
 		<h4>@Email</h4>
		data7 : <form:input path="data7" type="text"/><br/>
				<form:errors path="data7" /><br/>
		<hr/>
		<form:button type="submit">확인</form:button> 
	</form:form>
</body>
</html>