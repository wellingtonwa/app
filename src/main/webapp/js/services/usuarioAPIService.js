angular.module("listaCompras").factory("usuariosAPI", function ($http, config) {
	
	var _saveUsuario = function (segUsuarioJson) {
		return $http.post(config.baseUrl + "/seguranca/usuario/salvar", segUsuarioJson);
	};

	return {
		saveUsuario: _saveUsuario
	};
});