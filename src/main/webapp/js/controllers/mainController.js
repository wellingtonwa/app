angular.module("listaCompras").controller("mainController", function($route, $scope, $location, config, usuarioAPI, listas) {
	
	$scope.subtitulo = "Lista de Compras";
	$scope.usuario = usuarioAPI.usuarioLogado();
	$scope.listaSelecionada = 0;
		
	//Verificando se o usuario possui permissao de acesso
	if($scope.usuario.token == null) {
		$location.path("/login");
	}
	
	$scope.listas = listas.data;
	
	$scope.logout = function() {
		usuarioAPI.doLogout();
		$location.path("/login");
	};
	
	$scope.selecionarLista = function(id) {
		$scope.listaSelecionada = id;
	};

});