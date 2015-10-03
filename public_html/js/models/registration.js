define([
    'backbone'
], function(
    Backbone
){

    var Model = Backbone.Model.extend({
    	initialize: function(){
            this.on('submit', function(){
                this.onSubmit();
            });	
            console.log("Registration model initialized.");
    	},
        onSubmit: function(event) {
            // $('form').on('submit', function(event){
            //     console.log($(this).serialize());
            //     $.post('/api/v1/auth/signin', $(this).serialize(), function(response) { 
            //     console.log('RESPONSE');
            //     });
            // });
        }

    });

    return Model;
});