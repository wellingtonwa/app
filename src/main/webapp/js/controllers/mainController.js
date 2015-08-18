angular.module("listaCompras").controller("mainController", function($route, $scope, $location, config, usuarioAPI, listaAPI, listaItemAPI) {
	
	$scope.subtitulo = "Lista de Compras";
	$scope.usuario = usuarioAPI.usuarioLogado();
	$scope.listas = [];
	$scope.listaSelecionada = 0;
	$scope.listaSelecionadaItens = [];
	$scope.valorTotalLista = 0.00;
		
	//Verificando se o usuario possui permissao de acesso
	if($scope.usuario.token == null) {
		$location.path("/login");
	}
	
	$scope.logout = function() {
		usuarioAPI.doLogout();
		$location.path("/login");
	};
	
	$scope.selecionarLista = function(id) {
		$scope.listaSelecionada = id;
		carregarInformacoesLista(id);
		carregaItensDaLista(id);
	};
	
	$scope.$watchCollection('listaSelecionadaItens',function() {
		// Função disparada sempre que o objeto $scope.listaSelecionadaItens sofrer alterações
		$scope.valorTotalLista = 0;
		angular.forEach($scope.listaSelecionadaItens, function(item, key) {
			$scope.valorTotalLista += item.cadItem.valor * item.quantidade;
		});
	});
	
	var carregaItensDaLista = function(id) {
		listaItemAPI.carregaItensDaLista(id).success(function(data) {
			$scope.listaSelecionadaItens = data;
		});
	};
	
	var carregarInformacoesLista = function(id) {
		listaAPI.carregaInformacoesLista(id).success(function(data) {
			$scope.listaSelecionadaDetail = data;
		});
	};
	
	var carregarListas = function() {
		listaAPI.getListas().success(function(data) {
			$scope.listas = data;
		});
	};
	
	carregarListas();

});