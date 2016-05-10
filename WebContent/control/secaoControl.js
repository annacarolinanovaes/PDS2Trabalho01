var app = angular.module('secaoModule',[]);

app.controller('secaoControl',function($scope,$http){
	
	var url = 'http://localhost:8080/PDS2-Trabalho01/rs/secao';
	
	$scope.pesquisar = function(){
		$http.get(url).success(function (secoesRetorno) {
			$scope.secoes = secoesRetorno;
		}).error(function(mensagemErro) {
			alert(mensagemErro);
		});   
	}
	
	$scope.pesquisar();
	
	$scope.novo = function(){
		$scope.eleitor = {};
	}

    $scope.salvar = function() {
		if ($scope.secao.codigo == '') {
			$http.post(url,$scope.secao).success(function(secao) {
				$scope.secoes.push($scope.secao);
				$scope.novo();
			}).error(function (erro) {
				alert(erro);
			});
		} else {
			$http.put(url,$scope.secao).success(function(secao) {
				$scope.pesquisar();
				$scope.novo();
			}).error(function (erro) {
				alert(erro);
			});
		}		
	}
	
	$scope.excluir = function() {
		if ($scope.secao.codigo == '') {
			alert('Selecione uma seção: ');
		} else {
			urlExcluir = url+'/'+$scope.secao.codigo;
			$http.splice(urlExcluir).success(function () {
				$scope.pesquisar();
				$scope.novo();
			}).error(function (erro) {
				alert(erro);
			});
		}
	}
	
	$scope.seleciona = function(eleitorTabela) {
		$scope.eleitor = eleitorTabela;
	}
});