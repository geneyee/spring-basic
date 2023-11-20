<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>input_data</h1>
	<form:form action="input_pro" modelAttribute="dataBean1" method="post">
		<h4>@AssertTrue</h4>
		data1 : <form:radiobutton path="data1" value="true"/>true
				<form:radiobutton path="data1" value="false"/>false<br/>
				<form:errors path="data1" /><br/>
		<Hr/>
		<h4>@AssertFalse</h4>		
		data2 : <form:radiobutton path="data2" value="true"/>true
				<form:radiobutton path="data2" value="false"/>false<br/>
				<form:errors path="data2" /><br/>
		<Hr/>
		<h4>@Max / @Min</h4>
		data3 : <form:input path="data3" type="text"/><br/>
				<form:errors path="data3" /><br/>
		<Hr/>
		<h4>@DeciamlMax / @DeciamlMin</h4>
		data4 : <form:input path="data4" type="text"/><br/>
				<form:errors path="data4" /><br/>
		<Hr/>
		<h4>@Null</h4>
		data5 : <form:checkbox path="data5" value="check1"/>checkbox1<br/>
				<form:errors path="data5" /><BR/>
		<Hr/>
		<h4>@NotNull</h4>
		data6 : <form:checkbox path="data6" value="check2"/>checkbox2<br/>
				<form:errors path="data6" />	
		<Hr/>
		<h4>@Digits</h4>
		data7 : <form:input path="data7" type="text"/><br/>
				<form:errors path="data7" /><br/>	
		<Hr/>		
		<h4>@Size</h4>
		data8 : <form:input path="data8" type="text"/><br/>
				<form:errors path="data8" /><br/>	
		<Hr/>
		<h4>@Pattern</h4>
		data9 : <form:input path="data9" type="text"/><br/>
				<form:errors path="data9" /><br/>	
		<Hr/>	
		<form:button type="submit">확인</form:button>
	</form:form>
</body>
</html>