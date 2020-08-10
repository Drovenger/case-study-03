<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body onload="search();">
<form action="/home" method="get" id="home">
</form>
<script>
    function search() {
        document.forms["home"].submit();
    }
</script>
</body>
</html>
