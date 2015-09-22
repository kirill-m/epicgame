define([
    'backbone',
    'tmpl/scoreboard',
    'models/score',
    'collections/scores'
], function(
    Backbone,
    tmpl,
    player,
    players
){

    var View = Backbone.View.extend({
        el: '.main__page',
        template: tmpl,
        initialize: function () {
            console.log("scoreboard view is initialized");
        },
        render: function () {
            this.$el.html(this.template);
            return this;
        },
        show: function () {
            var p1 = new player({name: "Kirill", score: 99});
            var p2 = new player({name: "Kostya", score: 78});
            var p3 = new player({name: "Serioga", score: 42});
            var p4 = new player({name: "p4", score: 100});
            var p5 = new player({name: "p5", score: 82});
            var p6 = new player({name: "p6", score: 46});
            var p7 = new player({name: "p7", score: 85});
            var p8 = new player({name: "p8", score: 71});
            var p9 = new player({name: "p9", score: 22});
            var p10 = new player({name: "p10", score: 96});
            var arr = [p1, p2, p3, p4, p5, p6, p7, p8, p9, p10];
            var allPlayers = players;
            allPlayers.comparator = function(player) {
                return (-player.get("score"));
            }
            for (i = 0; i < arr.length; i++){
                allPlayers.add(arr[i]);    
            }
            for (i = 0; i < arr.length; i++){
                this.$el.find("div").append("<p class='js-score'>"
                    + allPlayers.at(i).get("name") + " "
                    + allPlayers.at(i).get("score") + "</p>");
            }        
            console.log(allPlayers.pluck("name"));
        },
        hide: function () {
            // TODO
        }

    });

    return new View();
});