<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<tiles:importAttribute name="exception" ignore="true"/>
<!DOCTYPE html>
<html>
<head>
<title>error</title>
</head>
<body>
	에러정보 : ${exception }
</body>
</html>