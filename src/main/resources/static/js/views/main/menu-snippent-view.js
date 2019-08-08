define(['jquery', 'views/communication-base-view'
	   ,'text!../../templates/main/menuTemplate.html'
	   ,'text!../../templates/main/menuGroupTemplate.html'
	   ,'text!../../templates/main/subMenuTemplate.html']
       , function($,CommunicationBaseView, MenuTemplate, MenuGroupTemplate, SubMenuTemplate) {
	var MenuSnippetView = CommunicationBaseView.extend({
		events: {
			'click .SID-menu-group-item': '_menuGroupClickHandler',
			'click .SID-submenu-switch': '_subMenuSwitch',
			'click .SID-menu-item': '_menuClickHandler'
		},
		initialize: function() {
			this.preRender();
			this.menuData = {};
		},
		render: function() {
			this.setUpContent();
			return this;
		},
		refresh: function() {},
		destroy: function() {
			this.undelegateEvents();
			this.unbind();
			this.$el.empty();
		},
		subscribeEvents: function() {
			var self = this;
			this.eventHub.unsubscribeEventByName('MENU_CLICK_WELCOME');
			this.eventHub.subscribeEvent('MENU_CLICK_WELCOME', function(data) {
				self.menuClickWelcome(data);
			});
		},
		defauleMenu : function(){
			this.$el.find('.SID-menu').first().click();
		},
		_menuGroupClickHandler: function(Event) {
			var self = this;
			var currentMenuId = $(Event.currentTarget).find(".SID-menu-group-item-a").attr('data-menuId');
			this.$el.find('.SID-menu-group-item').filter(function(index) {
				return $(this).hasClass('active');
			}).addClass('nav-category-list').removeClass('active');
			$(Event.currentTarget).addClass('active');
			
			var menuList = this.getCurrentMenu();
			var submenuHtml = '';
			for(var i=0,menuGroup; menuGroup=menuList[i++];) {
				if (currentMenuId == menuGroup.id) {
					submenuHtml += _.template( SubMenuTemplate, { menuList : menuGroup.menuList });
//					submenuHtml += '<li class="sublist SID-menu-item"><a data-menuUrl=' + submenu.resString + ' data-menuUUID=' + submenu.id + ' data-menuId=' + submenu.id + '>' + submenu.name + '</a></li>';
				}
			}
			
//			var menuData = this.menuData;
//			var submenuData = _.filter(menuData, function(data) {
//				return data.parentId == currentMenuId;
//			});
//			var submenuHtml = '';
//			_.each(submenuData, function(submenu, index) {
//				submenuHtml += '<li class="sublist SID-menu-item"><a data-menuUrl=' + submenu.url + ' data-menuUUID=' + submenu.menuUUID + ' data-menuId=' + submenu.menuId + '>' + submenu.menuName + '</a></li>';
//			});
			this.$el.find('.SID-submenu-box').html(submenuHtml);
			this._showSubMenu();
		},
//		menuClickHandler :function(target){
//			this.$el.find('.SID-menu').parent().removeClass('active');
//			$(target.currentTarget).parent().addClass('active');
//			var menuName = $(target.currentTarget).attr('data-name');
//			var msg = {
//					menuName : menuName
//			};
//			this.eventHub.publishEvent('MENU_CLICKL', msg);	
//			return false;
//		},
		_getMenuObj:function(menuId,parentMenuId){
			var list = this.getCurrentMenu();
			for(var i=0,menuGroup; menuGroup=list[i++];) {
				if (menuGroup.id == parentMenuId) {
					for(var j=0,menu; menu=menuGroup.menuList[j++];) {
						if (menu.id == menuId) {
							var msg = {
								currentMenu: menu,
								parentMenu: menuGroup
							};
							return msg;
						}
					}
				}
			}
		},
		_menuClickHandler: function(Event) {
			var self = this;
			var currentObj = $(Event.currentTarget);
			var currentMenuId = currentObj.find(".SID-menu-item-a").attr('data-menuid');
			var currentParentMenuId = currentObj.find(".SID-menu-item-a").attr('data-parentId');
			var msg = this._getMenuObj(currentMenuId,currentParentMenuId);
			console.log(msg)
			
			this.$el.find('.SID-menu-item').filter(function() {
				return $(this).hasClass('active');
			}).addClass('sublist').removeClass('active');
			$(Event.currentTarget).addClass('active').removeClass('sublist');
			
			//解决快速点击菜单，导致view创建多份
			$(".SID-menuClick-cover").show();
			
			this.eventHub.publishEvent('MENU_CLICKL', msg);
			return false;
		},
		_subMenuSwitch: function(Event) {
			var switchDiv = $(Event.target);
			if (this.$el.find('.SID-menu-group-item').filter(function(index) {
					return $(this).hasClass('active');
				}).length != 0) {
				if (switchDiv.hasClass('side-left-switchR')) {
					this._showSubMenu();
				} else {
					this._hideSubMenu();
				}
			}
		},
		_showSubMenu: function() {
			this.$el.find('.fixed-side-left').addClass('fixed-side-leftW');
			this.$el.find('.fixed-side-left').removeClass('fixed-side-left');

			this.$el.find('.SID-submenu-switch').removeClass('side-left-switchR');
			this.$el.find('.SID-submenu-switch').addClass('side-left-switchL');
			$('.SID-main-container-snippet').addClass('fixed-centerW');
		},
		_hideSubMenu: function() {
			this.$el.find('.fixed-side-leftW').addClass('fixed-side-left');
			this.$el.find('.fixed-side-leftW').removeClass('fixed-side-leftW');
			this.$el.find('.SID-submenu-switch').removeClass('side-left-switchL');
			this.$el.find('.SID-submenu-switch').addClass('side-left-switchR');
			$('.SID-main-container-snippet').removeClass('fixed-centerW');
		},
		_getClassFhicon: function(priority) {
			var classFhicon = {};
			switch (priority) {
			  case '01':
				  classFhicon = 'fhicon-admin2';//用户管理
				  break;
		      case '02':
		    	  classFhicon = 'fhicon-meeting-clock';//预约管理
		    	  break;
		      case '04':
		    	  classFhicon = 'fhicon-subscription';//内容管理
		    	  break;
		      case '07':
		    	  classFhicon = 'fhicon-adhibition';//信用管理
		    	  break;
		      case '08':
		    	  classFhicon = 'fhicon-statistics';//统计分析
		    	  break;
		      case '09':
		    	  classFhicon = 'fhicon-safe';//门禁安防
		    	  break;
		      case '10':
		    	  classFhicon = 'fhicon-device-policy';//烟感控制
		    	  break;
		      case '11':
		    	  classFhicon = 'fhicon-book';//工位电源
		    	  break;
		      case '20':
		    	  classFhicon = 'fhicon-window';//系统管理
		    	  break;
	    	  default:
	    		  classFhicon = 'fhicon-set';
	    		  break;
		    }
			return classFhicon;
		},
		setUpContent: function() {
			var menuList = this.getCurrentMenu();
			for(var i=0,menuGroup; menuGroup=menuList[i++];) {
				menuGroup.classFhicon = this._getClassFhicon(menuGroup.priority);
			}
			var html = _.template( MenuTemplate, {});
			this.$el.append(html);
			var groupHtml = _.template( MenuGroupTemplate, { menuList : menuList });
			this.$el.find(".SID-menu-group").append(groupHtml);
			//this.defauleMenu();
		},
		menuClickWelcome : function(data){
			var self = this;
			this.$el.find('.SID-menu-group-item').addClass('nav-category-list').removeClass('active');
			this._hideSubMenu();
			var msg = {
				currentMenu: {
					resString:""
				},
				parentMenu: {
					
				}
			};
			this.eventHub.publishEvent('MENU_CLICKL', msg);
//			var currentMenuId = data.menuId;
//			this.$el.find('.SID-menu-group-item[data-menuid="'+currentMenuId+'"]').addClass('active');
//			
//			var menuData = this.menuData;
//			var submenuData = _.filter(menuData, function(data) {
//				return data.parentId == currentMenuId;
//			});
//			var submenuHtml = '';
//			_.each(submenuData, function(submenu, index) {
//				submenuHtml += '<li class="sublist SID-menu-item"><a data-menuUrl=' + submenu.url + ' data-menuUUID=' + submenu.menuUUID + ' data-menuId=' + submenu.menuId + '>' + submenu.menuName + '</a></li>';
//			});
//			this.$el.find('.SID-submenu-box').html(submenuHtml);
//			self._showSubMenu();
//			
//			if(data.searchKey){
//				this.$el.find('.SID-submenu-box a[data-menuid="'+data.subMenuId+'"]').attr("data-searchKey",data.searchKey);
//				this.$el.find('.SID-submenu-box a[data-menuid="'+data.subMenuId+'"]').attr("data-searchValue",data.searchValue);
//			}
//			this.$el.find('.SID-submenu-box a[data-menuid="'+data.subMenuId+'"]').click();
		}
	});

	return MenuSnippetView;
});