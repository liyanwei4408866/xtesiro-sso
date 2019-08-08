define
(
  [ 
    'jquery', 'views/container-base-view','util/datatableUtil','datatable_lnpagination',
	'text!../../templates/atable/ATableTemplate.html',
	'views/atable/atable-add-snippet-view', 'views/atable/atable-edit-snippet-view', 'views/atable/atable-show-snippet-view'
  ],
  function (
    $, ContainerBaseView, datatableUtil, datatableLnpagination,
	Template,
	ATableAddSnippetView, ATableEditSnippetView, ATableShowSnippetView) {
	  var ATableSnippetView = ContainerBaseView.extend({
		events : {
			'click .SID-search' : 'search',
			'click .SID-clearSearch' : 'clearSearch',
			'click .SID-atable-add': 'addInit',
			'click .SID-atable-edit': 'editInit',
			'click .SID-atable-delete': 'deleteData',
			'click .SID-atable-batch-del': 'batchDel',
			'click .SID-atable-auth': 'authInit'
		},
		initialize : function() {
			this.preRender();
			this.chaildView = {};
			this.datatable = {};
			this.templateConstant = {};
			this.viewConstant = {};
		},
		render : function() {
			var self = this;
			$.getJSON("/js/model/atable/atable.json", function(json) {
				console.log(self.templateConstant);
				self.templateConstant = json.template;
				self.viewConstant = json.view;
				self.setContentHTML();
			});
			return this;
		},
		setContentHTML : function (){
			var html = _.template(Template, {
				'constant': this.templateConstant
			});
			this.$el.find(".SID-container").append(html);
			this.refreshTable();
		},
		refreshTable : function() {
			this.atableList();
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
		/**
		 * events
		 */
		search : function(){
			this.a-demoList(this,'search');
		},
		clearSearch : function(){
			this.$el.find("#subForm")[0].reset();
		},
		addInit : function(e){
			this.chaildView.atableAddSnippetView = new ATableAddSnippetView();
			this.chaildView.atableAddSnippetView.render(this,"");
		},
		editInit : function(e){
			var self = this;
			var obj = $(e.target);
			var atableId =obj.attr(this.viewConstant.table.idAttr);
			if(atableId == ""){
				return;
			}
			if(atableId){
				$.ajax({
					type:"GET",
					url:"usergroup/"+atableId,
					success:function(ajax){
						self.chaildView.atableEditSnippetView = new ATableEditSnippetView();
						self.chaildView.atableEditSnippetView.render(self,ajax);
					}
				});
			}
		},
		showInit : function(e){
			var self = this;
			var obj = $(e.target);
			var atableId =obj.attr(this.viewConstant.table.idAttr);
			if(atableId == ""){
				return;
			}
			if(atableId){
				$.ajax({
					type:"GET",
					url:"usergroup/"+atableId,
					success:function(ajax){
						self.chaildView.atableShowSnippetView = new ATableShowSnippetView();
						self.chaildView.atableShowSnippetView.render(self,ajax);
					}
				});
			}
		},
		deleteData:function(e){
			var self = this;
			var obj = $(e.target);
			var atableId =obj.attr(this.viewConstant.table.idAttr);
			if(atableId == ""){
				return;
			}
			fh.confirm('确定删除用户组吗？',function(){
				$.ajax({
					type:"DELETE",
					url:"usergroup/"+atableId,
					success:function(data){
						if(data.code == "300005"){
							fh.alert("会议室处于预定中！");
						}else if(data.code == "1"){
							fh.alert("删除会议室成功！",false,function(){
								self.refreshTable();
							});
						}else{
							fh.alert(data.message,false,function(){
								self.refreshTable();
							});
						}
					},
					error:function(){
						fh.alert("删除会议室失败！");
					}
				});
			});
		},
		batchDel:function(e){
			var self = this;
			var obj = $(e.target);
			var atableId =obj.attr("data-atableId");
			if(ademoId == ""){
				return;
			}
			ids = {};
			fh.confirm('确定删除这些用户组吗？',function(){
				$.ajax({
					type:"DELETE",
					url:"usergroup/batch",
					data:{ids:ids},
					success:function(data){
						if(data.code == "300005"){
							fh.alert("会议室处于预定中！");
						}else if(data.code == "1"){
							fh.alert("删除会议室成功！",false,function(){
								self.refreshTable();
							});
						}else{
							fh.alert(data.message,false,function(){
								self.refreshTable();
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
		atableList : function(){
			var self = this;
			var tableObj={};
			var param = this.initSearchParam();
			tableObj.url = this.viewConstant.url;
			//控制是否可分页
			tableObj.bPaginate = true;
			// tableObj.aaSorting = [[2,'asc']];
			tableObj.aoColumns=[
			{"sTitle": "<input type=\"checkbox\" />","mDataProp": null,"sWidth": "10%","sClass": "center","bSortable": false,
		        "sDefaultContent": "<input type=\"checkbox\" />",
		        "bUseRendered": false,
		        "fnRender": function(o, val) {
		            return '<input type="checkbox" value="' + o.aData.usergroupid + '"/>';
		        }
		    },
			{"sTitle":"用户组","sWidth":"30%","mDataProp":"groupname","sDefaultContent": "" ,"sClass":"left","bSortable":false},
			{"sTitle":"角色","sWidth":"53%","mDataProp":"rolename","sDefaultContent": "" ,"sClass":"left","bSortable":false},
			{"sTitle":"操作","sWidth":"7%","mDataProp":"cz","sDefaultContent": "" ,"sClass":"center","bSortable":false,"fnRender":function(o,val){
				var str = "";
				for (var i=0,data;data=self.viewConstant.table.button[i++];) { 
					str += '<a href="javascript:void(0)" class="' + data.sid + '" ' + self.viewConstant.table.idAttr + '="'+o.aData.usergroupid+'">'
					    +  '<span class="' + data.icon + '"></span>'
					    +  data.label
					    +  '</a>';
				}
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
	return ATableSnippetView;
  }
);