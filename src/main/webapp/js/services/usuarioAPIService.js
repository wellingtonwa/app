angular.module("listaCompras").factory("usuariosAPI", function ($http, config) {
	
	var SegUsuario = function(nomeCompleto, email, senha) {
		this.nomeCompleto = nomeCompleto;
		this.email = email;
		this.senha = senha;
	};
	
	var _newSegUsuarioJson = function (usuario) {
		return angular.toJson({objeto : new SegUsuario(usuario.nomeCompleto, usuario.email, usuario.senha)});
	}
	
	var _saveUsuario = function (segUsuarioJson) {
		return $http.post(config.baseUrl + "/seguranca/usuario/salvar", segUsuarioJson);
	};

	return {
		newSegUsuarioJson: _newSegUsuarioJson,
		saveUsuario: _saveUsuario
	};
	
});