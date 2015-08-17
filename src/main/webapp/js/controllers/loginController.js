angular.module("listaCompras").controller("loginController", function($scope, $http, $location, config, localStorageService, loginAPI, usuariosAPI) {

	$scope.subtitulo = "Acessar Lista de Compras";

	$scope.login = function (usuario) {
		
		loginAPI.login(usuariosAPI.newSegUsuarioJson(usuario)).success(function(data) {
			
			if(localStorageService.isSupported) {
				
				localStorageService.set(config.storageTokenKey, data.token);
				localStorageService.set(config.storageUsuarioId, data.usuario.id);
				localStorageService.set(config.storageUsuarioNomeCompleto, data.usuario.nomeCompleto);
				localStorageService.set(config.storageUsuarioEmail, data.usuario.email);
				
				delete $scope.usuario;
				$scope.loginForm.$setPristine();
				$location.path("/");
				
			} else {
				$scope.mensagemErro = "Este navegador não esta homologado para esta aplicação. Desculpe!";
			}
			
		}).error(function(data) {
			$scope.mensagemErro = data.errors[0].message;
		});

	};

});