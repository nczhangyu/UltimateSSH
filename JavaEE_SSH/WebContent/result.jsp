<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>全部信息</title>
</head>
<body>
	<table border=10px bgcolor="cyan">
		<tr>
			<td>序号</td>
			<td>姓名</td>
			<td>性别</td>
			<td>战力</td>
			<td>技能</td>
			<td>派别</td>
			<td>相片</td>
		<tr>
		<s:iterator  value="#request.results" var="res">
			<tr>
				<td><s:property value="#res.id"/></td>
				<td><s:property value="#res.name"/></td>
				<td><s:property value="#res.sex"/></td>
				<td><s:property value="#res.power"/></td>
				<td><s:property value="#res.skill"/></td>
				<td><s:property value="#res.sects"/></td>
				<td><img alt="相片" src="getImage.action?warrior.name=<s:property value="#res.name"/>" ></td>
			</tr>
		</s:iterator>
	</table>
	<table></table>
</body>
</html>