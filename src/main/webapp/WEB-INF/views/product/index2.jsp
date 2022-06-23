<%@page language="java"contentType="text/html;charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<html>
<head>
<meta http-equiv="Content-Type"content="text/html;charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form method="post" enctype="multipart/form-data" 
    action="${pageContext.request.contextPath}/product/importExcel">
    Excel File<input type="file"name="file">
    <br>
    <input type="submit"value="Import">
</form>
</body>
</html>