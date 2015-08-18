angular.module("listaCompras").factory("listaItemAPI", function ($http, config) {
	
	var _carregaItensDaLista = function(id) {
		return $http.get(config.baseUrl + "/compra/listaitem/listarTodos/" + id);
	};
	
	return {
		carregaItensDaLista: _carregaItensDaLista
	};
	
});