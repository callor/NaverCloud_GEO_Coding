<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c" %>
<c:set var="rootPath" value="${pageContext.request.contextPath}" />   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>내멋으로</title>
</head>
<body>
내멋으로 홈페이지
<form method="POST" action="${rootPath}/maps/geocoding">
	<input name="address" placeholder="주소를 입력하세요">
	<button>확인</button>
</form>
<form method="POST" action="${rootPath}/maps/regeocoding">
	<input name="coords" placeholder="좌표를 입력하세요(위,경)" value="${GEOS[0].lat},${GEOS[0].lgt}">
	<button>확인</button>
</form>
</body>
</html>