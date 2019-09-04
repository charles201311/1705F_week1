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
</head>
<body>
<form action="">
	<table>
		<tr>
			<td>名称:<input type="text" name="name" value="${movie.name }">
			<input type="hidden" name="id" value="${movie.id }">
			
			</td>
		</tr>
		<tr>
			<td>导演::<input type="text" name="actor" value="${movie.actor }"></td>
		</tr>
		<tr>
			<td>发布日期::<input type="date" name="pdate" value="${movie.pdate }"></td>
		</tr>
		<tr>
			<td>介绍::<input type="text" name="about" value="${movie.about }"></td>
		</tr>
		<tr>
			<td>类型:
			<c:forEach items="${types }" var="t">
			 <input type="checkbox" name="tids" value="${t.id}"  >${t.type } 
			</c:forEach>
			
			</td>
		</tr>
		</tr>

		<tr>
			<td><button type="button" onclick="update()">修改</button> </td>
		</tr>
	</table>
	</form>
   <script type="text/javascript">
   $(function(){
	   $.get("/selectById",{mid:'${movie.id}'},function(list){
		   for(var i in list){
			    
			  // alert(list[i].tid)
			$("[name='tids']").each(function(){
				//如果相等则选中
				if($(this).val()==list[i].tid){
					$(this).attr("checked",true);	
				}
				
			})   
			   
		   }
		   
	   })
	   
	   
	   
   })
   
   
   
   function update(){
	   $.post("/update",$("form").serialize(),function(obj){
		   if(obj){
			   alert("修改成功");
			   location.href="/selects";
			   
		   }else{
			   alert("失败")
		   }
	   })
	   
	   
	   
   }
   
   
   </script>
</body>
</html>