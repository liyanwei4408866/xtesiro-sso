define
(
  [ 
    'jquery', 'views/communication-base-view',
	'text!../../templates/atable/ATableAddTemplate.html'
  ],
  function (
    $, CommunicationBaseView,
	Template) {
	  var ATableAddSnippetView = CommunicationBaseView.extend({
		events : {
		},
		initialize : function() {
			this.childView = {};
			this.parentView = {};
			this.viewConstant = {};
			this.atableObj = {};
		},
		render : function(parentView,atableObj) {
			this.atableObj = atableObj;
			this.parentView = parentView;
			this.viewConstant = this.parentView.viewConstant.dialog.add;
			this._setContentHTML(atableObj);
			return this;
		},
		_setContentHTML : function (atableObj){
			var self = this;
			var html = _.template(Template, {
				'imgPath': self.constants.IMAGEPATH
			});
			this.$el.append(html);
			var commonDialog = fh.commonOpenDialog(this.viewConstant.key, this.viewConstant.title, this.viewConstant.width, this.viewConstant.height, this.el);
			commonDialog.addBtn("cannel","关闭",function(){
				self.destroy();
				commonDialog.cancel();
			});
			commonDialog.addBtn("ok","保存",function(){
				self._sumbitForm(commonDialog,atableObj);
			});
			this._initData(atableObj);
		},
		destroy : function() {
			this._destroyBusinessViews();
			this.undelegateEvents();
			this.unbind();
			this.$el.empty();
			this.remove();
		},
		_destroyBusinessViews : function() {
			$.each(this.childView, function(index, view) {
				view.destroy();
			});
		},
		_initData:function(atableObj){
			var self = this;
			if(atableObj){// 修改
				self.$el.find("#roomId").val(atableObj.roomId);
			}else {// 新增
			}
		},
		_sumbitForm : function(commonDialog,room){
			var param = "";
			var self = this;
		    this.validateForm("formMsg");
			var param = this.serializeJson($("#formMsg"));
			console.log(param);
		    if(this.validateResult()){
		    	$.ajax({
		    		type:"POST",
			    	url:self.parentView.viewConstant.url,
			    	data:param,
			    	success :function(response){
			    		if(response.code == "1"){
			    			fh.alert(self.viewConstant.success,false,function(){
			    				commonDialog.cancel();
			    				self.parentView.refreshTable();
			    				self.destroy();
							});
			    		}else{
			    			fh.alert(response.message,true,null,commonDialog);
			    		}
			    	},
			    	error :function(){
			    		fh.alert(self.viewConstant.error);
			    	}
			    });
		    }
		}
	});
	return ATableAddSnippetView;
});