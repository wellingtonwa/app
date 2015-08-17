angular.module("listaCompras").controller("mainController", function($scope, $location, config, localStorageService) {

	//-- INICIO - Verificando se o usuario possui permissao de acesso
	
	var _isLogado = false;
	
	if(localStorageService.isSupported) {
		var _token = localStorageService.get(config.storageTokenKey);
		_isLogado = _token != null;
	}
	
	if(!_isLogado) {
		$location.path("/login");
	}
	
	//-- FIM - Verificando se o usuario possui permissao de acesso
	
	$scope.subtitulo = "Lista de Compras";
	
	$scope.logout = function() {
		localStorageService.remove(config.storageTokenKey);
		localStorageService.remove(config.storageUsuarioId);
		localStorageService.remove(config.storageUsuarioNomeCompleto);
		localStorageService.remove(config.storageUsuarioEmail);
		$location.path("/login");
	};

});