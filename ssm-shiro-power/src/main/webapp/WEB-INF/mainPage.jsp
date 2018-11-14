<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<%@ include file="../common/mystyle.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<style type="text/css">
body {padding-top:15px;}
</style>
<body>
<input type="hidden" value=${user.userName } id="userName">
<center><h3>欢迎<font color="red" size="7px" >${user.userName }</font>使用金科管理系统</h3></center>
<h3 align="right"><a>退出登录</a></h3>
<div class="row">
		  <div class="col-md-3">
			
			   <a class="list-group-item" data-addtab="userMenu" data-target="#tabs" >
			    	ssm+shiro框架权限管理
			   </a>
			  
			
				<!-- tree 的插件 -->
			 <ul id="treeDiv" class="ztree"></ul>   
			 
			 <ul id="treeDiv1" class="ztree"></ul>              
			
			 </div>
	  
	  	<div class="col-md-9">
			
				<!--   选项卡    -->
				<!-- Nav tabs -->
				<ul id="tabs" class="nav nav-tabs" role="tablist">
				    <li role="presentation" class="active">
				        <a href="#home" aria-controls="home" role="tab" data-toggle="tab">欢迎</a></li>
				</ul>
			  	<!-- 选项卡  内容 -->
				<!-- Tab panes -->
				<div class="tab-content">
				    <div role="tabpanel" style="" class="tab-pane active " id="home">后台管理系统</div>
				</div> 
	</div>
	</div>
</body>

	<script type="text/javascript">
	$(function (){
		var settings={   //在setting中做我们树的一些配置    setting  是创建树之前的要干的事情 
			
			   check:{   //复选框  配置   
					enable: true,    //  开启 复选框
					}, 
			   data: {				//  data 中  是一些基础信息
					key:{
						name: "text",   //    默认 是name
						//url:"uriTab",
						//abc:"uriTab"
					}, 
				simpleData: {    	 //简单数据设置
				enable: true,	//简单数据开启  默认为false
				idKey: "id",  		// 指定 那个是id 可以自定义 
				pIdKey: "pid",  //  那个是父节点	可以自定义
				rootPId: null   	//  将几定义为父节点	可以自定义
					       }
				},
			view:{              //显示的设置
			selectedMulti:false, //是否允许多个被选中		
			nameIsHTML: true,  //支持HTML  格式
			},
			callback:{  	// 回掉函数   的设置
			  onClick:function (event,treeId,treeNode){  // event 设置的对象   treeId  标签的id  treeNode该节点的所有参数
			  alert(event+"~~~"+treeId+"~~~~~"+treeNode.uri+"~~~~~"+treeNode.id);
			  if(null !=  treeNode.uri){
				  $.addtabs.add({
					   id:treeNode.id,
					   title:treeNode.text,
					   url:'<%=request.getContextPath()%>'+treeNode.uri,
				  })
			  }
			  }
		     }

		  }
		
		$.ajax({
			type:"post",
			url:"<%=request.getContextPath()%>/user/findTree.do",
			data:{'userName':$("#userName").val()},
			dataType:"json",
			success:function (msg){
				$.fn.zTree.init($("#treeDiv"), settings, msg);
			},
			error:function (){
				alert("出错了");
			}
		});
		
		
	})
		
		
	</script>
</html>