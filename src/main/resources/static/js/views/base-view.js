/**
 * Base class for the all the back bone views generated by the application
 * Holds the common functions and implementation for all or more than one 
 * views that can be via this application 
 * 
 */
define(["backbone", 'fh', "util/progressbar", "util/constants", "util/uiRanderUtil", "require", 'jquery.validate', 'validate_methods', 'messages_zh', "jqueryUi", "icheck"],
	function(Backbone, fh, ProgressBar, Constants, UiRanderUtil, require) {
		var BaseView = Backbone.View.extend({
			viewType: 'BaseView',
			constants: Constants,
			uiRanderUtil: UiRanderUtil,
			validate: {},
			validates: [],
			getAppContext: function() {
				return require("app").getInstance();
			},
			preRender: function() {
				return this;
			},
			render: function() {
				return this;
			},
			showLoading: function(containerSID) {
				if (arguments.length == 0) {
					ProgressBar.start(this);
				} else {
					ProgressBar.start(this, containerSID);
				}
			},
			hideLoading: function(containerSID) {
				if (arguments.length == 0) {
					ProgressBar.stop(this);
				} else {
					ProgressBar.stop(this, containerSID);
				}
			},
			destroy: function() {
				this.undelegateEvents();
				this.remove();
			},
			serializeJson:function(domObj){
				var serializeObj={};  
	            var array=domObj.serializeArray();  
	            var str=domObj.serialize();  
	            $(array).each(function(){  
	                if(serializeObj[this.name]){  
	                    if($.isArray(serializeObj[this.name])){  
	                        serializeObj[this.name].push(this.value);  
	                    }else{  
	                        serializeObj[this.name]=[serializeObj[this.name],this.value];  
	                    }  
	                }else{  
	                    serializeObj[this.name]=this.value;   
	                }  
	            });
	            return JSON.stringify(serializeObj);
			},
			clearCurrentUser:function(){
				this.setCurrentUser('');
			},
			setToken:function(token){
				$.ajaxSetup({
					headers : {
				        'token' : token
				    }				  
				});	
				localStorage.setItem('token',token)
			},
//			isLogin:function(){
//				var token = localStorage.getItem('token');
//				if (data == "" || data == null || data == undefined) {
//					return false;
//				} else {
//					this.setCurrentUser(data);
//					return true;
//				}
//			},
			setCurrentUser:function(userInfo){
				this.getAppContext().cashUtil.saveData('currentUser',userInfo);
				this.setToken(userInfo.token);
			},
			getCurrentUserName:function(){
				var data = this.getAppContext().cashUtil.getData('currentUser');
				return data.descn;
			},
			getCurrentUserGroupId:function(){
				var data = this.getAppContext().cashUtil.getData('currentUser');
				return data.userGroupId;
			},
			getCurrentMenu:function(){
				var data = this.getAppContext().cashUtil.getData('currentUser');
				return data.menuList;
			},
			getCurrentRole:function(){
				var data = this.getAppContext().cashUtil.getData('currentUser');
				return data.roleList;
			},
			getCurrentRoleName:function(){
				var data = this.getAppContext().cashUtil.getData('currentUser');
				var roleArr = [];
				for(var i=0,role; role=data.roleList[i++];) {
					roleArr.push(role.descn)
				}
				return roleArr.join(",");
			},
			refresh: function() {},
			validateForm: function(formID, elObj) {
				//增加elObj参数，用于没有new新view时弹出框的el对象
				var el = this.$el;
				if (elObj) {
					el = elObj;
				}
				this.validate = el.find("#" + formID).validate({
					onfocusout: function(element) {
						$(element).valid();
					},
					onkeyup: function(element) {
						var flag = $(element).valid();
						//类似用户策略模型的错误提示
						if (flag) {
							$(element).next('label.formbar-error').hide();
						} else {
							$(element).next('label.formbar-error').show();
						}
					},
					errorPlacement: function(error, element) {
						element.parents('.form-item,.delPrivformBar-add').addClass('form-item-wrong');
						error.appendTo(element.parents('.form-item,.delPrivformBar-add').find('.wrong-text'));
						//类似用户策略模型的错误提示
						error.appendTo(element.next('label.formbar-error'));
						element.next('label.formbar-error').show();
					}
				});
				return this.validate;
			},
			validateForms: function(formID, elObj) {
				this.validates[formID] = this.validateForm(formID, elObj);
			},
			validateResultByFormId: function(formID) {
				if(this.validates != null){
					return this.validates[formID].form();
				}				
			},			
			validateResult: function() {
				if(this.validate != null){
					return this.validate.form();
				}
				if(this.validates != null){
					_.each(this.validates, function(validate){
						if (!validate.form()) {
							return false;
						}
					});
				}				
			},
			escapeChar: function(str) {
				var arr = [
					["\\\\", "\\\\"],
					["\"", "\\\""],
					["\t", "    "]
				];
				str = jQuery.trim(str);
				for (var i = 0; i < arr.length; i++) {
					str = str.replaceAll(arr[i][0], arr[i][1]);
				}
				return str;
			},
			transInnerHTMLChar: function(str) {
				//解决在拼接html中出现包含破坏html代码的字符
				var arr = [
					["<", "&lt;"],
					[">", "&gt;"],
					["\"", "&quot;"]
				];
				str = jQuery.trim(str);
				for (var i = 0; i < arr.length; i++) {
					str = str.replaceAll(arr[i][0], arr[i][1]);
				}
				return str;
			}
		});

		return BaseView;
	}
);