/**
 * @extends BaseView
 * Base class for the all the back bone views which need communication with others generated by the application
 * Holds the common functions and implementation for all the views which need communication with other views
 * 
 * @author Terry 
 */
define(['jquery', 'views/base-view', 'util/eventhub-backbone'], function($, BaseView, EventHub) {
	var CommunicationBaseView = BaseView.extend({
		viewType: 'CommunicationBaseView',
		eventHub: EventHub,
		/**
		 * subscribe events, will be trigered when the relevant event published.
		 */
		subscribeEvents: function() {
			return this;
		},
		/**
		 * @Override the BaseView's preRender function.
		 * If we want to overright the preRender() in the child view which extend CommunicationBaseView we shoud call the subscribeEvents().
		 */
		preRender: function() {
			this.subscribeEvents();
		}
	});
	return CommunicationBaseView;
});