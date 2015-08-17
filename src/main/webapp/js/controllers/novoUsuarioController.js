angular.module("listaCompras").controller("novoUsuarioController", function ($scope, usuariosAPI) {
	
	$scope.subtitulo = "Cadastro de Novo Usuário";
	
	$scope.cadastrarUsuario = function (usuario) {
		
		usuariosAPI.saveUsuario(usuariosAPI.newSegUsuarioJson(usuario)).success(function(data) {
			delete $scope.usuario;
			$scope.cadastroForm.$setPristine();
			$scope.mensagemSucesso = "Usuário cadastrado com sucesso!";
			$scope.goToFormLogin = true;
		}).error(function(data) {
			$scope.mensagemErro = data.errors[0].message;
		});
		
	};
	
});