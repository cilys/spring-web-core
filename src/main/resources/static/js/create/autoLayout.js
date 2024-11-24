var formVm = null;

$(document).ready(function(){
	formVm = new Vue({
		el : "#div_main"
		, data : function() {
			return {
                viewList : []
			}
		}
	})
	
})

function initViewObj() {
	return {
		"name" : "div"
	}
}

function add() {
	formVm.viewList.push(initViewObj())
}
