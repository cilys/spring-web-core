$(document).ready(function(){
	var list = [
		{
			id : 1
			, parentId : null
			, title : '首页'
		}
		
		, {
			id : 2
			, parentId : null
			, title : '系统设置'
		}
		
		, {
			id : 3
			, parentId : 2
			, title : '用户管理'
		}
		
		, {
			id : 4
			, parentId : 2
			, title : '日志管理'
		}
		, {
			id : 5
			, parentId : 3
			, title : '用户列表'
		}
		, {
			id : 6
			, parentId : 3
			, title : '用户权限'
		}
	]
	
	var tree = arrayToTree(list, null)
	console.log(tree)
	
	$("#div_left_nav").html('')
	
	
})

function arrayToTree(arr, parentId = null) {
  const tree = [];
  
  for (let i = 0; i < arr.length; i++) {
    if (arr[i].parentId === parentId) {
      const children = arrayToTree(arr, arr[i].id);
      if (children.length) {
        arr[i].children = children;
      }
      tree.push(arr[i]);
    }
  }
  
  return tree;
}
