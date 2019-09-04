<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>电影列表</title>
<link href="/resource/css/index_work.css" rel="stylesheet">

<script type="text/javascript" src="/resource/js/jquery-3.2.1.js"></script>
<script type="text/javascript">

function chkAll(flag){
	if(flag==1){
	  $("[name='ids']").prop("checked",true)	
		
	}else if(flag==2){
		 $("[name='ids']").prop("checked",false)
	}else{
		$("[name='ids']").each(function(){
			$(this).prop("checked",!$(this).prop("checked"));
		
		})
		
	}
	
}

</script>
</head>
<body>
	<table>
		<tr>
			<td>
				<button type="button" onclick="chkAll(1)">全选</button>
				<button type="button" onclick="chkAll(2)">全不选</button>
				<button type="button" onclick="chkAll(3)">反选</button>

			</td>
			<td>名称</td>
			<td>导演</td>
			<td>发布日期</td>
			<td>介绍</td>
			<td>类型</td>
			<td>操作<a href="add">增加</a></td>
		</tr>
		<c:forEach items="${movies }" var="m">

			<tr>
				<td><input type="checkbox" name="ids" value="${m.id }"></td>
				<td>${m.name }</td>
				<td>${m.actor }</td>
				<td>${m.pdate}</td>
				<td>${m.about }</td>
				<td>${m.type }</td>
				<td><a href="update?id=${m.id }">修改</a></td>
			</tr>



		</c:forEach>

		<tr>
			<td colspan="6">${page }</td>
		</tr>
	</table>

</body>
</html>