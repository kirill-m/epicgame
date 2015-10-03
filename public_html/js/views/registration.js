define([
    'backbone',
    'tmpl/registration',
    'models/registration'
], function(
    Backbone,
    tmpl,
    registration
){

    var View = Backbone.View.extend({
        el: '.main__page',
        template: tmpl,
        model: registration,
        events: {
            'click .js-submit': ''            
        },
        initialize: function () {
            new registration();
            console.log("registration view is initialized");
        },
        render: function () {
            this.$el.html(this.template);
            return this;
        },
        show: function () {
            // TODO
        },
        hide: function () {
            // TODO
        }

    });

    return new View();
});