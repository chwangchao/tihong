<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script src="/resource/js/jquery-1.12.4.js"></script>
<title>Insert title here</title>
</head>
<script type="text/javascript">
	function loadData() {
		$.post("/user/all.do", function(data) {
			alert(data);
		})
	}

	var pageNum = 1;
	var pageSize = 2;
	function loadDataPage() {
		pageNum++;
		$.post("/user/allpage.do", {
			pageNum : pageNum,
			pageSize : pageSize
		}, function(data) {
			alert(data);
		})
	}
</script>
<body>
	<button onclick="loadData()">全部</button>

	<button onclick="loadDataPage()">分页</button>
</body>
</html>