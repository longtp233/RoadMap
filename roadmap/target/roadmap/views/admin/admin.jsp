<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/common/taglib.jsp"%>

<html>
<head>
    <title>Chỉnh sửa bài viết</title>
</head>
<body>
<div  > ${model}
<% request.getAttribute("test"); %>
<%=request.getParameter("model")%>
 </div>
</body>
</html>
