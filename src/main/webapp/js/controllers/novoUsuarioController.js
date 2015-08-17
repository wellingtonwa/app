angular.module("listaCompras").controller("novoUsuarioController", function ($scope, usuariosAPI) {
	
	$scope.subtitulo = "Cadastro de Novo Usuário";
	
	$scope.cadastrarUsuario = function (usuario) {
		
		var segUsuarioJson = angular.toJson({objeto : new SegUsuario(usuario.nomeCompleto, usuario.email, usuario.senha)});
		
		usuariosAPI.saveUsuario(segUsuarioJson).success(function(data) {
			delete $scope.usuario;
			$scope.cadastroForm.$setPristine();
			$scope.mensagemSucesso = "Usuário cadastrado com sucesso!";
			$scope.goToFormLogin = true;
		}).error(function(data) {
			$scope.mensagemErro = data.errors[0].message;
		});
		
	};
	
	var SegUsuario = function(nomeCompleto, email, senha) {
		this.nomeCompleto = nomeCompleto;
		this.email = email;
		this.senha = senha;
	};
	
});