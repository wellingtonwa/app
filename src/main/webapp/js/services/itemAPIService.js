angular.module("listaCompras").factory("itemAPI", function ($http, config, usuarioAPI) {
	
	var CadItem = function(id, descricao, valor, cadUnidadeMedida, SegUsuarioProprietario, UltimoUsuario) {
		this.id = id;
		this.descricao = descricao;
		this.valor = valor;
		this.cadUnidadeMedida = cadUnidadeMedida;
		this.segUsuarioProprietario = SegUsuarioProprietario;
		this.ultimoUsuario = UltimoUsuario;
	};
	
	var _newCadItemJson = function(json) {
		return angular.toJson({objeto : new CadItem(json.id, json.descricao, json.valor, json.cadUnidadeMedida, usuarioAPI.usuarioLogado(), usuarioAPI.usuarioLogado())});
	};
	
	var _criarItem = function (itemJson) {
		return $http.post(config.baseUrl + "/cadastro/item/salvar", itemJson);
	};
	
	return {
		newCadItemJson : _newCadItemJson,
		criarItem: _criarItem
	};
	
});