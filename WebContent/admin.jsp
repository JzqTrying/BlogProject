<%@page import="tzc.bean.Article"%>
<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%  
String path = request.getContextPath();  
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";  
request.setAttribute("path", basePath);  
%>

<!DOCTYPE html>
<html>
<head>
	<title>后台管理</title>
</head>
<body>

<div class="">
        	
			<c:choose>
				<c:when test="${page.hasPrepage}">
				  <a href="AdminServlet?currentPage=1">首页</a> | 
				  <a href="AdminServlet?currentPage=${page.currentPage-1 }">上一页</a>
				</c:when>
				<c:otherwise>
					首页 | 上一页
				</c:otherwise>
			</c:choose>
			<c:choose>
				<c:when test="${page.hasNextPage}">
				<a href="AdminServlet?currentPage=${page.currentPage + 1 }">下一页</a> | 
			<a href="AdminServlet?currentPage=${page.totalPage }">尾页</a>
			</c:when>
			<c:otherwise>
				下一页 | 尾页
			</c:otherwise>
			</c:choose>
			当前为第${page.currentPage}页,共${page.totalPage}页
		  </div>

</body>
</html>