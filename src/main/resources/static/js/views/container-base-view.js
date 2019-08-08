define(['jquery', 'views/communication-base-view', 'text!../templates/baseContainerTemplate.html'], 
	function($, CommunicationBaseView, TemplateBaseContainer) {
	var ContainerBaseView = CommunicationBaseView.extend({
		viewType: 'ContainerBaseView',
		preRender: function() {
			this.subscribeEvents();
			this.initContent();
		},
		initContent : function(){
			var html = _.template(TemplateBaseContainer, {});
			this.$el.append(html);
			//var nav = this.commentLable.menu[this.attributes.parentMenu.menuName] + '&gt;' + this.commentLable.menu[this.attributes.currentMenu.menuName];
			var nav = this.attributes.parentMenu.descn + '&nbsp;&nbsp;&gt;&nbsp;&nbsp;' + this.attributes.currentMenu.descn;
			this.$el.find('.SID-nav-bar').html(nav);
		},
	});
	return ContainerBaseView;
});