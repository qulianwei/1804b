<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../common/mystyle.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

	<table id="userTableId"></table>
</body>
	<script type="text/javascript">
	$().ready(function (){
		$("#userTableId").bootstrapTable({
			 url:"<%=request.getContextPath()%>/user/queryUserList.do",	
			 method:"post",
			 striped: true,  	// 斑马线效果     默认false 
			 //只允许选中一行
			 singleSelect:true,
			 //选中行是不选中复选框或者单选按钮
			 clickToSelect:true,
			 showToggle:true,                    //是否显示详细视图和列表视图的切换按钮
			 cardView: false,                    //是否显示详细视图
			 uniqueId: "userId",                 //每一行的唯一标识，一般为主键列
			 showColumns: true,                  //是否显示所有的列
			 showRefresh: true,                  //是否显示刷新按钮
			 minimumCountColumns: 2,     //  最少留两列
			 detailView: false,                  //是否显示父子表
			 //发送到服务器的数据编码类型  
			contentType:'application/x-www-form-urlencoded;charset=UTF-8',   //数据编码纯文本  offset=0&limit=5
			toolbar:'#tabToolBar',   //  工具定义位置
			columns:[
			     	{field:'userId',title:'ID',width:50,
						formatter:function(value,row,index){   //  格式化  当前单元格内容
							return "<input type='checkbox' value="+value+" name='chk'/>";
						}
					},
					{field:'realName',title:'真实名称',width:100},
					{field:'cz',title:'操作',width:100,
					 	formatter:function(value,row,index){
			        		return  "<button type='button' class='btn btn-warning' onclick='updateRoleByUserId(\""+row.userId+"\")'>角色赋权限</button>";
						} 
					}
			         ],
			         //传递参数（*）
					 queryParams: function(params) {
						 	var whereParams = {    
						 			
						 	}
							 return whereParams;
						 },
						 //前台--排序字段
						 //sortName:'proPrice',
						 //sortOrder:'desc',
						 //前台--搜索框
						 search:true,
						 //启动回车键做搜索功能
						 searchOnEnterKey:true,
				   	   
		});
	
	});
	
	function updateRoleByUserId(userId){
		dialog("<%=request.getContextPath()%>/user/toRolePage.do?userId="+userId,"<%=request.getContextPath()%>/role/updateRoleByUserId.do","修改角色权限")
	}
	/*
	*发送ajax请求获取jsp页面内容
	*/
	 function getJspHtml(urlStr){
		 var  jspHtml = "";
//		 async  (默认: true) 默认设置下，所有请求均为异步请求。如果需要发送同步请求，请将此选项设置为 false。
	//注意，同步请求将锁住浏览器，用户其它操作必须等待请求完成才可以执行。
			$.ajax({
				url:urlStr,
				type:'post',
				//同步的ajax
				async:false,
				success:function(data){
					//alert(data);//data--addProduct.jsp页面内容
					jspHtml = data;
				},
				error:function(){
					bootbox.alert("ajax失败");
				}
			});
		return jspHtml;
	}

	

	function  dialog(HTMLurl,submitUrl,title){
		
		var dialog = bootbox.dialog({
			 title: title,
		    message: getJspHtml(HTMLurl),   //调用方法  
		    buttons:{
		    				"save":{
							  label: '保存',
							  //自定义样式
							  className: "btn-success",
							  callback: function() {
								  var treeObj = $.fn.zTree.getZTreeObj("roletreeDiv");
								  var nodes = treeObj.getCheckedNodes(true);
								  var userId=$("#hiddenId").val();
								  var ids=""
								  for(var i=0;i<nodes.length;i++){
									  if(ids==""){
										  ids+=nodes[i].id
									  }else{
										  ids+=","+nodes[i].id
									  }
								  }

									$.ajax({
										url:submitUrl,
										type:'post',
										data:{"ids":ids,"userId":userId},
										dataType:"json",
										success:function(data){
											
										},
										error:function(){
											bootbox.alert("ajax失败");
										}
									});
							  }
							},
							"unSave":{
								  label: '取消',
								  //自定义样式
								 className: "btn-info",
								  callback: function() {
									 // return false;  //dialog不关闭
								  }
								}
						}
	});
	}
	</script>
</html>