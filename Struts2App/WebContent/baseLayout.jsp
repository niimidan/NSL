<!DOCTYPE html>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %> 
<html>
<head>
	<title><tiles:insertAttribute name="title" ignore="true"/></title>
	<tiles:insertAttribute name="header"/>
</head>
<body>
	<tiles:insertAttribute name="navi"/>
	<tiles:insertAttribute name="jumbo"/>
	<tiles:insertAttribute name="main"/>
	<tiles:insertAttribute name="footer"/>

</body>
</html>