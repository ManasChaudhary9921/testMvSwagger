var app = angular.module('app',['ngImageCompress']);

app.controller('getAllMovies', function($scope, $http, $location) {
	
	//$scope.showAllMovies = false;

	$scope.getAllMovies = function() {
		var url = $location.absUrl() + "/jpa/getAllMovies";

		var config = {
			headers : {
				'Content-Type' : 'application/json;charset=utf-8;'
			}
		}

		$http.get(url, config).then(function(response) {
			//if (response.data.status == "OK") {
				$scope.allMovies = response.data;
				//console.log("data==== "+$scope.allMovies);
				$scope.showAllMovies = true;
				$scope.getResultMessage = " Movies Data fetched!";
			/*} else {
				$scope.getResultMessage = "get All Movies Data Error!";
			}*/

		}, function(response) {
			$scope.getResultMessage = "Fail!";
		});

	}
});