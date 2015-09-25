define([
    'backbone',
    'tmpl/main'
], function(
    Backbone,
    tmpl
){

    var View = Backbone.View.extend({
        el: '.main__page',
        template: tmpl,
        initialize: function () {
            console.log("main view is initialized");
        },
        render: function () {
            this.$el.html(this.template);
            return this;
        },
        show: function () {
            
        },
        hide: function () {
            // TODO
        }

    });

    return new View();
});