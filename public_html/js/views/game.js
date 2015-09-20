define([
    'backbone',
    'tmpl/game'
], function(
    Backbone,
    tmpl
){

    var View = Backbone.View.extend({
        el: '.main__page',
        template: tmpl,
        initialize: function () {
            console.log("game view is initialized");
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