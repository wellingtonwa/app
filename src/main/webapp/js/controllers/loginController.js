angular.module("listaCompras").controller("loginController", function($scope, $http, $location, loginAPI, usuariosAPI) {

	$scope.subtitulo = "Acessar Lista de Compras";

	$scope.login = function (usuario) {
		
		loginAPI.login(usuariosAPI.newSegUsuarioJson(usuario)).success(function(data) {
			delete $scope.usuario;
			$scope.loginForm.$setPristine();
			$location.path("/");
		}).error(function(data) {
			$scope.mensagemErro = data.errors[0].message;
		});

	};

});