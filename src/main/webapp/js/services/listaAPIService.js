angular.module("listaCompras").factory("listaAPI", function ($http, config, usuarioAPI) {
	
	var _usuarioLogado = usuarioAPI.usuarioLogado();
	
	var _getListas = function() {
		return $http.get(config.baseUrl + "/compra/lista/listarTodos/" + _usuarioLogado.id);
	};
	
	var _carregaInformacoesLista = function(id) {
		return $http.get(config.baseUrl + "/compra/lista/" + id + "/listar");
	};
	
	return {
		getListas: _getListas,
		carregaInformacoesLista : _carregaInformacoesLista,
	};
	
});