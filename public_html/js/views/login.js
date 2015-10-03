define([
    'backbone',
    'tmpl/login',
    'models/login'
], function(
    Backbone,
    tmpl,
    login
){

    var View = Backbone.View.extend({
        el: '.main__page',
        template: tmpl,
        model: new login(),
        events: {
            'click .js-submit': 'validateForm'            
        },
        initialize: function () {
            console.log("login view is initialized");

        },
        render: function () {
            this.$el.html(this.template);
            return this;
        },
        show: function () {
            
        },
        hide: function () {
            // TODO
        },
        validateForm: function(event){
            //event.preventDefault();
            var obj = $(".main").find("form");
            var lgn = obj.find(".js-login").val().length;
            var pass = obj.find(".js-password").val().length;
            //obj.find(".warning1").text("LOL");
            //obj.find(".warning2").text("lol");
            // if (lgn == 0)
            //     obj.find(".warning1").text("Enter login");
            // if (pass < 5)
            //     obj.find(".warning2").text("Password is too short");
        }
    });

    return new View();
});