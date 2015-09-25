define([
    'backbone',
    'views/main',
    'views/scoreboard',
    'views/game',
    'views/login'
], function(
    Backbone,
    main,
    scoreboard,
    game,
    login
){

    var Router = Backbone.Router.extend({
        routes: {
            'scoreboard': 'scoreboardAction',
            'game': 'gameAction',
            'login': 'loginAction',
            '*default': 'defaultActions'
        },
        defaultActions: function () {
            console.log("from default");
            var mainView = main; //new main() ???
            mainView.render();
        },
        scoreboardAction: function () {
            console.log("from scoreboard");
            var scoreboardView =  scoreboard;
            scoreboard.render();
            scoreboard.show();
        },
        gameAction: function () {
            console.log("from game");
            var gameView = game;
            gameView.render();
        },
        loginAction: function () {
            console.log("from login");
            var loginView = login;
            loginView.render();
        }
    });

    return new Router();
});