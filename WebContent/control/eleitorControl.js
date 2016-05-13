var app = angular.module('eleitorModule',[]);

app.controller('eleitorControl',function($scope,$http){
	
	var url = 'http://localhost:8080/PDS2-Trabalho01/rs/eleitor';
	
	$scope.pesquisar = function(){
		$http.get(url).success(function (eleitoresRetorno) {
			$scope.eleitores = eleitoresRetorno;
		}).error(function(mensagemErro) {
			alert(mensagemErro);
		});   
	}
	
	$scope.pesquisar();
	
	$scope.novo = function(){
		$scope.eleitor = {};
	}

    $scope.salvar = function() {
		if ($scope.eleitor.codigo == '') {
			$http.post(url,$scope.eleitor).success(function(eleitor) {
				$scope.eleitores.push($scope.eleitor);
				$scope.novo();
			}).error(function (erro) {
				alert(erro);
			});
		} else {
			$http.put(url,$scope.eleitor).success(function(eleitor) {
				$scope.pesquisar();
				$scope.novo();
			}).error(function (erro) {
				alert(erro);
			});
		}		
	}
	
	$scope.excluir = function() {
		if ($scope.eleitor.codigo == '') {
			alert('Selecione um eleitor');
		} else {
			urlExcluir = url+'/'+$scope.eleitor.codigo;
			$http.delete(urlExcluir).success(function () {
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