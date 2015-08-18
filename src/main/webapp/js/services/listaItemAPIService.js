angular.module("listaCompras").factory("listaItemAPI", function ($http, config) {
	
	var _carregaItensDaLista = function(id) {
		return $http.get(config.baseUrl + "/compra/listaitem/listarTodos/" + id);
	};
	
	var _excluirItensPorLista = function (id) {
		return $http.post(config.baseUrl + "/compra/listaitem/excluirItensPorLista/" + id);
	};
	
	return {
		carregaItensDaLista: _carregaItensDaLista,
		excluirItensPorLista: _excluirItensPorLista
	};
	
});