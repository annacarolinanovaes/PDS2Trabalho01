var app = angular.module('zonaEleitoralModule',[]);

app.controller('zonaEleitoralControl',function($scope,$http){
	
	var url = 'http://localhost:8080/PDS2-Trabalho01/rs/zonaeleitoral';
	
	$scope.pesquisar = function(){
		$http.get(url).success(function (zonaseleitoraisRetorno) {
			$scope.zonaseleitorais = zonaseleitoraisRetorno;
		}).error(function(mensagemErro) {
			alert(mensagemErro);
		});   
	}
	
	$scope.pesquisar();
	
	$scope.novo = function(){
		$scope.eleitor = {};
	}

    $scope.salvar = function() {
		if ($scope.zonaEleitoral.codigo == '') {
			$http.post(url,$scope.zonaEleitoral).success(function(zonaEleitoral) {
				$scope.zonaseleitorais.push($scope.zonaEleitoral);
				$scope.novo();
			}).error(function (erro) {
				alert(erro);
			});
		} else {
			$http.put(url,$scope.zonaEleitoral).success(function(zonaEleitoral) {
				$scope.pesquisar();
				$scope.novo();
			}).error(function (erro) {
				alert(erro);
			});
		}		
	}
	
	$scope.excluir = function() {
		if ($scope.zonaEleitoral.codigo == '') {
			alert('Selecione uma zona eleitoral');
		} else {
			urlExcluir = url+'/'+$scope.zonaEleitoral.codigo;
			$http.splice(urlExcluir).success(function () {
				$scope.pesquisar();
				$scope.novo();
			}).error(function (erro) {
				alert(erro);
			});
		}
	}
	
	$scope.seleciona = function(zonaEleitoralTabela) {
		$scope.zonaEleitoral = zonaEleitoralTabela;
	}
});