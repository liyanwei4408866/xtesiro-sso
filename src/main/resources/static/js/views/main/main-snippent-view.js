define([ 'jquery', 'views/communication-base-view', 'text!../../templates/login/loginTemplate.html', 'text!../../templates/main/mainTemplate.html',
		'views/main/header-snippent-view', 'views/main/menu-snippent-view',
		'views/main/main-conatiner-snippent-view' ],
		function($, CommunicationBaseView,LoginTemplate, MainTemplate,
				HeaderSnippentView, MenuSnippetView,
				MainContainerSnippent) {
			var MainSnippent = CommunicationBaseView.extend({
				events : {
					'click .SI-search-toggle' : 'searchToggleDisplay',
					'click .SID-login-btn' : 'login'
				},
				initialize : function() {
					this.preRender();
					this.views = {};
				},
				render : function() {
					var appContext = this.getAppContext();
					appContext.cashUtil.saveData('servicePath',"api");
					appContext.cashUtil.saveData('ropParam','format=json&v=1.0&appKey=');
					appContext.cashUtil.saveData('ropParamNoV','format=json&appKey=');
					appContext.cashUtil.saveData('ropFileParam','format=bin&v=1.0&appKey=');
					this.setUpContent();
					return this;
				},
				refresh : function() {
				},
				destroy : function() {
					this.undelegateEvents();
					this.unbind();
				},
				setUpContent : function() {
					var self = this;
					var token = localStorage.getItem('token')
					if (token == "" || token == null || token == undefined) {
						self.initLoginView();
						console.log(token)
					} else {
						// 校验token是否有效
						$.ajax({
							type : "GET",
							url : 'login',
							async : false,
							success : function(data) {
								console.log("刷新");
								console.log(data);
								if (data.code == "1") {
									self.setCurrentUser(data);
									self.initBusinessViews();
								} else {
									self.clearCurrentUser();
									self.initLoginView();
								}
							},
							error : function() {
								self.clearCurrentUser();
								self.initLoginView();
							}
						});
//							self.clearCurrentUser();
//							window.top.location = "index.html";
					}
				},
				subscribeEvents : function() {
					var self = this;
				},
				login : function(){
					var self = this;
					var name = this.$el.find("#ID-username").val();
					var pwd = this.$el.find("#ID-password").val();
					var userInfo = {
			          username: name,
			          password: pwd,
			        }
					var data = JSON.stringify(userInfo)
					console.log(data)
					this.showLoading();
					$.ajax({
						type : "POST",
						url : 'ajaxLogin',
						data : data,
						async : false,
						success : function(data) {
							self.hideLoading();
							console.log(data);
							if (data.code == "1") {
								self.setCurrentUser(data);
								console.log(self.getCurrentUserName());
								console.log(self.getCurrentUserGroupId());
								console.log(self.getCurrentMenu());
								console.log(self.getCurrentRole());
								console.log(self.getCurrentRoleName());
								self.initBusinessViews();
							} else {
								fh.alert(data.error_message);
							}
						},
						error : function() {
							self.hideLoading();
							fh.alert("获取登录信息失败！");
						}
					});
				},
				/**
				 * init business views
				 */
				initLoginView : function() {
					var self = this;
					var imgPath = self.constants.IMAGEPATH;
					var html = _.template(
							LoginTemplate, {
								imgPath : imgPath
							});
					self.$el.html(html);
					this.clearBusinessViews();
				},
				initBusinessViews : function() {
					var self = this;
					var imgPath = self.constants.IMAGEPATH;
					var html = _.template(
							MainTemplate, {
								imgPath : imgPath
							});
					self.$el.html(html);	
//					$.each(this.views, function(index, view) {
//						view.destroy();
//					});
//					this.views = {};
					this.clearBusinessViews();
					this.views.menuSnippetView = new MenuSnippetView({el:$(".SID-menu-snippet")});
					this.views.headerSnippentView = new HeaderSnippentView({el:$(".SID-header-snippent")});
					//this.views.navbarSnippentView = new NavbarSnippentView({el:$(".SID-nav-bar-snippet")});
					this.views.mainContainerSnippent = new MainContainerSnippent({el:$(".SID-main-container-snippet")});
					this.renderBusinessViews();
				},
				/**
				 * Render the business views
				 */
				renderBusinessViews : function() {
					$.each(this.views, function(index, view) {
						view.render();
					});
				},
				
				clearBusinessViews : function() {
					$.each(this.views, function(index, view) {
						view.destroy();
					});
					this.views = {};
				},

				searchToggleDisplay : function(Event){
					if($(Event.currentTarget).find("span.fhicon-arrowD2").length==1){
						this.$el.find(".search-toggle span:eq(1)").text("关闭查询条件");
						this.$el.find(".search-toggle span:eq(0)").removeClass("fhicon-arrowD2").addClass("fhicon-arrowU2");
						
						this.$el.find(".search-modle").removeClass("hide");
					}else{
						this.$el.find(".search-toggle span:eq(1)").text("展开查询条件");
						this.$el.find(".search-toggle span:eq(0)").removeClass("fhicon-arrowU2").addClass("fhicon-arrowD2");
						
						this.$el.find(".search-modle").addClass("hide");
					}
				}
				
			});

			return MainSnippent;
		});