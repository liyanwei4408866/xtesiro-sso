requirejs.config({
	waitSeconds: 0,
	config:{
		text: {
			useXhr:function(){return true;}
		}
	},
	paths: {
		"seedsui":"lib/seedsui/seedsui.min",
		"jquery":"lib/jquery/jquery-1.7.2.min",
		"underscore":"lib/underscore",
		"text":"lib/text-2.0.12",
		"domReady":"lib/domReady-2.0.1.js",
		"backbone":"lib/backbone",
		"spin":"lib/spinjs-rails/spin",
        "constants":"util/constants"
	},
	//依赖和导出配置
	shim: {
		"underscore": {
			deps: [],
			exports: "_"
		},	
		"backbone": {
			deps: ["jquery", "underscore", "text"],
			exports: "Backbone"
		},
		"spin": {
			deps: [],
			exports: "spin"
		}
	}
});

require(["jquery", "app"],
	function ($,  Application){
		$(document).ready(webViewReady($, Application));
	}
);
function webViewReady($, Application) {
	webViewAfterReady(Application);
	return;
}

function webViewAfterReady(Application){
	Application.create({
		routeOnStart: true,
		popupDisplayMode: 'NonBlocking'
	}).start();
}