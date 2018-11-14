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
	<ul id="roletreeDiv" class="ztree"></ul>
	<input type="hidden" id="hiddenId" value="${userId }">
</body>

<script type="text/javascript">
$(function (){
	var setting={   //在setting中做我们树的一些配置    setting  是创建树之前的要干的事情 
		
			check: {
				autoCheckTrigger: true,//需要触发自动关联勾选操作
				chkboxType: { "Y": "p", "N": "s" },//勾选操作，只影响父级节点；取消勾选操作，只影响子级节点
				chkStyle: "checkbox",
				enable: true,
				nocheckInherit: false,
				chkDisabledInherit: false//需要子节点自动继承 chkDisabled = true
			},
	
		   data: {				//  data 中  是一些基础信息
				key:{
					name: "text",   //    默认 是name
					open:true,
					//url:"uriTab",
					//abc:"uriTab"
				}, 
			/* simpleData: {    	 //简单数据设置
			enable: false,	//简单数据开启  默认为false
			idKey: "id",  		// 指定 那个是id 可以自定义 
			pIdKey: "pid",  //  那个是父节点	可以自定义
			rootPId: null   	//  将几定义为父节点	可以自定义
				       } */
			},
		view:{              //显示的设置
		selectedMulti:true, //是否允许多个被选中		
		nameIsHTML: true,  //支持HTML  格式
		},
		callback:{  	// 回掉函数   的设置
		  onClick:function (event,treeId,treeNode){  // event 设置的对象   treeId  标签的id  treeNode该节点的所有参数
		  alert(event+"~~~"+treeId+"~~~~~"+treeNode.uriTab+"~~~~~"+treeNode.id);
		  },
	     }
	  }
	
	$.ajax({
		type:"post",
		url:"<%=request.getContextPath()%>/role/findRoleTree.do",
		dataType:"json",
		success:function (msg){
			$.fn.zTree.init($("#roletreeDiv"), setting, msg);
			var roleArray=JSON.parse('${userRole}');
			
			var treeObj = $.fn.zTree.getZTreeObj("roletreeDiv");
			 for (var i = 0; i < roleArray.length; i++) {
				 alert(roleArray[i].roleId);
				//通过id获取节点
				var node = treeObj.getNodeByParam("id", roleArray[i].roleId, null);
				
				//通过节点选中
				treeObj.checkNode(node, true, true);
				 //全选节点
			/* var treeObj = $.fn.zTree.getZTreeObj("powertreeDiv");
			treeObj.checkAllNodes(true); */
		   }
		},
		error:function (){
			alert("出错了");
		}
	});
})
</script>

</html>