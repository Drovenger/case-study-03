<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body onload="search();">
<form action="/dashboard" method="get" id="dashboard">
</form>
<script>
    function search() {
        document.forms["dashboard"].submit();
    }
</script>
</body>
</html>
