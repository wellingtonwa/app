angular.module("listaCompras").factory("listaAPI", function ($http, config, usuarioAPI) {
	
	var ComLista = function(id, descricao, SegUsuarioProprietario, UltimoUsuario) {
		this.id = id;
		this.descricao = descricao;
		this.segUsuarioProprietario = SegUsuarioProprietario;
		this.ultimoUsuario = UltimoUsuario;
	};
	
	var _newComListaJson = function (json) {
		return angular.toJson({objeto : new ComLista(json.id, json.descricao, usuarioAPI.usuarioLogado(), usuarioAPI.usuarioLogado())});
	}
	
	var _getListas = function() {
		return $http.get(config.baseUrl + "/compra/lista/listarTodos/" + usuarioAPI.usuarioLogado().id);
	};
	
	var _carregaInformacoesLista = function(id) {
		return $http.get(config.baseUrl + "/compra/lista/" + id + "/listar");
	};
	
	var _criarLista = function (listaJson) {
		return $http.post(config.baseUrl + "/compra/lista/salvar", listaJson);
	};
	
	var _editarLista = function (listaJson) {
		return $http.put(config.baseUrl + "/compra/lista/alterar", listaJson);
	}
	
	var _excluirLista = function (listaJson) {
		return $http.post(config.baseUrl + "/compra/lista/excluir", listaJson);
	}
	
	return {
		newComListaJson: _newComListaJson,
		getListas: _getListas,
		carregaInformacoesLista : _carregaInformacoesLista,
		criarLista : _criarLista,
		editarLista : _editarLista,
		excluirLista : _excluirLista
	};
	
});