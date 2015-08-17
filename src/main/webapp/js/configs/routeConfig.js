angular.module("listaCompras").config(function ($routeProvider) {
	
	$routeProvider.when("/login", {
		templateUrl: "view/login.html",
		controller: "loginController"
	});
	
	$routeProvider.when("/novoUsuario", {
		templateUrl: "view/novoUsuario.html",
		controller: "novoUsuarioController"
	});
	
	$routeProvider.otherwise({redirectTo: "/login"});
	
});