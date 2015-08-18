angular.module("listaCompras").factory("listaAPI", function ($http, config, usuarioAPI) {
	
	var ComLista = function(descricao, SegUsuarioProprietario, UltimoUsuario) {
		this.descricao = descricao;
		this.segUsuarioProprietario = SegUsuarioProprietario;
		this.ultimoUsuario = UltimoUsuario;
	};
	
	var _usuarioLogado = usuarioAPI.usuarioLogado();
	
	
	var _newComListaJson = function (json) {
		return angular.toJson({objeto : new ComLista(json.descricao, usuarioAPI.usuarioLogado(), usuarioAPI.usuarioLogado())});
	}
	
	
	var _getListas = function() {
		return $http.get(config.baseUrl + "/compra/lista/listarTodos/" + _usuarioLogado.id);
	};
	
	var _carregaInformacoesLista = function(id) {
		return $http.get(config.baseUrl + "/compra/lista/" + id + "/listar");
	};
	
	var _saveLista = function (listaJson) {
		return $http.post(config.baseUrl + "/compra/lista/salvar", listaJson);
	};
	
	return {
		getListas: _getListas,
		carregaInformacoesLista : _carregaInformacoesLista,
		saveLista : _saveLista,
		newComListaJson: _newComListaJson
	};
	
});