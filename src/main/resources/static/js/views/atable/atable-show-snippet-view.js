define
(
  [ 
    'jquery', 'views/communication-base-view',
	'text!../../templates/atable/ATableAddTemplate.html'
  ],
  function (
    $, CommunicationBaseView,
	Template) {
	  var ATableShowSnippetView = CommunicationBaseView.extend({
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
			this.viewConstant = this.parentView.viewConstant.dialog.show;
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
			this.$el.find("#usergroupId").val(atableObj.usergroupId);
			this.$el.find("#usergroupName").val(atableObj.usergroupName);
		}
	});
	return ATableShowSnippetView;
});