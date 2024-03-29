define( ["jquery"], function ($) {

	/**
	 * Defines constants used across the application
	**/
	return {
		// Constants related AJAX request handling
		AJAX: {
			GET: "GET",
			POST: "POST",
			PATH: "/content"
		},
		IMAGEPATH: 'client/images',
		EVENTS: {
			PAGE_LOADED:"page_loaded",
			APPLICATION_START: "application_start",
			APPLICATION_SESSION_TIMEOUT: "application_session_timeout",
			RANDER_MAIN_PAGE : "RANDER_MAIN_PAGE"
		}
	};
});