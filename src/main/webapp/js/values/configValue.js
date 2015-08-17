angular.module("listaCompras").value("config", {
	
	//baseUrl: "http://localhost:8080/app", // LOCAL
	baseUrl: "http://52.20.90.29:28080", // PRODUCAO
	
	storageTokenKey: "app_token",
	
	storageUsuarioId: "app_usuario_id",
	storageUsuarioNomeCompleto: "app_usuario_nomecompleto",
	storageUsuarioEmail: "app_usuario_email"
		
});