define(
		[ 'jquery', 'views/container-base-view','text!../../templates/usergroup/usergroupTemplate.html','views/usergroup/usergroup-add-snippet-view',
		  'views/room/room-view-snippet-view','util/datatableUtil','datatable_lnpagination'],
		function($, ContainerBaseView,Template,RoomAddSnippetView,RoomViewSnippetView,datatableUtil,datatableLnpagination) {
			var treeObj;
			var UserGroupSnippetView = ContainerBaseView
					.extend({
						events : {
							'click .SID-search' : 'search',
							'click .SID-clearSearch' : 'clearSearch',
							'click .SID-usergroup-add': 'addInit',
							'click .SID-usergroup-batch-del': 'batchDel',
							'click .SID-usergroup-edit': 'editInit',
							'click .SID-usergroup-auth': 'authInit',
							'click .SID-usergroup-delete': 'usergroupDelete'
						},
						initialize : function() {
							this.preRender();
							this.chaildView = {};
							this.datatable = {};
						},
						render : function() {
//							this.$el.empty();
							this.setContentHTML();
							this.roomList();
							return this;
						},
						refresh : function() {
						},
						refreshTable : function() {
							this.roomList();
						},
						destroyBusinessViews : function(){
							$.each(this.chaildView, function(index, view) {
								 view.destroy();
							});		
							this.chaildView = {};
						},		
						destroy : function() {
							this.destroyBusinessViews()
							this.undelegateEvents();
							this.unbind();
							this.$el.empty();
						},
						subscribeEvents : function() {
							var self = this;
							this.eventHub.subscribeEvent('REFRESH_MEETINGLIST', function(operate) {
								self.meetingList(self, operate);
							});
						},
						setContentHTML : function (){
							var template = _.template(Template);
							var html = template({});
							this.$el.find(".SID-container").append(html);
						},
						search : function(){
							this.roomList(this,'search');
						},
						clearSearch : function(){
							this.$el.find(".SID-roomName").val("");
							this.$el.find(".SID-address").val("");
							this.$el.find(".SID-projector").removeAttr("checked");
							this.$el.find(".SID-display").removeAttr("checked");
							this.$el.find(".SID-microphone").removeAttr("checked");
							this.$el.find(".SID-stereo").removeAttr("checked");
							this.$el.find(".SID-wifi").removeAttr("checked");
							this.$el.find(".SID-roomType").val("");
						},
						addInit : function(e){
							var self = this;
							var obj = $(e.target);
							var roomId =obj.attr("data-roomId");
							if(roomId){
								var appContext = self.getAppContext();
								var servicePath = appContext.cashUtil.getData('servicePath');
								var ropParam = appContext.cashUtil.getData('ropParam');
								$.ajax({
									type:"POST",
									url:servicePath+"?"+ropParam+ "&method=mapps.meetingroom.room.detail&roomId="+roomId,
									success:function(ajax){
										self.chaildView.roomAddSnippetView = new RoomAddSnippetView();
										self.chaildView.roomAddSnippetView.render(self,ajax);
									}
								});
							}else{
								this.chaildView.roomAddSnippetView = new RoomAddSnippetView();
								this.chaildView.roomAddSnippetView.render(this,roomId);
							}
						},
						roomDetail : function(e){
							var self = this;
							var obj = $(e.target);
							var roomId =obj.attr("data-roomId");
							if(roomId == ""){
								return;
							}
							var appContext = self.getAppContext();
							var servicePath = appContext.cashUtil.getData('servicePath');
							var ropParam = appContext.cashUtil.getData('ropParam');
							$.ajax({
								type:"POST",
								url:servicePath+"?"+ropParam+ "&method=mapps.meetingroom.room.detail&roomId="+roomId,
								success:function(ajax){
									self.chaildView.roomViewSnippetView = new RoomViewSnippetView();
									self.chaildView.roomViewSnippetView.render(ajax);
								}
							});
						},
						roomDelete:function(e){
							var self = this;
							var obj = $(e.target);
							var roomId =obj.attr("data-roomId");
							if(roomId == ""){
								return;
							}
							fh.confirm('确定删除会议室吗？',function(){
								var appContext = self.getAppContext();
								var servicePath = appContext.cashUtil.getData('servicePath');
								var ropParam = appContext.cashUtil.getData('ropParam');
								$.ajax({
									type:"POST",
									url:servicePath+"?"+ropParam+ "&method=mapps.meetingroom.room.delete&roomId="+roomId,
									success:function(ajax){
										if(ajax.code == "300005"){
											fh.alert("会议室处于预定中！");
										}else if(ajax.code == "1"){
											fh.alert("删除会议室成功！",false,function(){
												self.roomList();
											});
										}else{
											fh.alert(ajax.message,false,function(){
												self.roomList();
											});
										}
									},
									error:function(){
										fh.alert("删除会议室失败！");
									}
								});
							});
						},
						initSearchParam:function(){
					        var serializeObj = this.serializeJson($("#subForm"));
							return serializeObj;
						},
						roomList : function(that,operate){
							var tableObj={};
							var param = this.initSearchParam();
							tableObj.url = "usergroup";
							//控制是否可分页
							tableObj.bPaginate = true;
							// tableObj.aaSorting = [[2,'asc']];
							tableObj.aoColumns=[
							{"sTitle": "<input type=\"checkbox\" />","mDataProp": null,"sWidth": "10%","sClass": "center","bSortable": false,
		                        "sDefaultContent": "<input type=\"checkbox\" />",
		                        "bUseRendered": false,
		                        "fnRender": function(o, val) {
		                            return '<input type="checkbox" value="' + o.aData.usergroupid + ',' + o.aData.groupname + '"/>';
		                        }
		                    },
							{"sTitle":"用户组","sWidth":"30%","mDataProp":"groupname","sDefaultContent": "" ,"sClass":"left","bSortable":false},
							{"sTitle":"角色","sWidth":"53%","mDataProp":"rolename","sDefaultContent": "" ,"sClass":"left","bSortable":false},
							{"sTitle":"操作","sWidth":"7%","mDataProp":"cz","sDefaultContent": "" ,"sClass":"center","bSortable":false,"fnRender":function(o,val){
								var str = '<a href="javascript:void(0)" class="SID-meet-detail" data-roomId="'+o.aData.usergroupid+'"><span class="fhicon-pencil"></span>编辑</a>';
								str += '<a href="javascript:void(0)" class="SID-meet-add" data-roomId="'+o.aData.usergroupid+'"><span class="fhicon-admin3"></span>角色分配</a>';
								str += '<a href="javascript:void(0)" class="SID-meet-delete" data-roomId="'+o.aData.usergroupid+'"><span class="fhicon-delete"></span>删除</a>';
								var retBox='<div class="tb-opt-box"><a class="table-operation"><span class="fhicon-set2"></span></a><div class="tb-opt-main">'+str+'</div></div>'
								return retBox;
							}}
							];
							var jsonProc = function(data) {
								var jsonData = {
										"iTotalDisplayRecords" : data.total ? data.total : 0,
												"iTotalRecords" : data.total ? data.total : 0,
														"aaData" : data.usergroupList ? data.usergroupList : ''
								};
								return jsonData;
							}
							this.datatable=datatableUtil(tableObj,param,jsonProc);
							
						}
			
					});
			return UserGroupSnippetView;
		});