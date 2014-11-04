(function(){
	var app = angular.module("editMenu",[]);
	
	app.controller("MealController",["$http", function($http){
		
		var editMenu = this;
		editMenu.menuDay = ""; 
		$http.get("http://localhost:8080/cv-rest/rest/currentMenuDay").success(function(menuDayJSON){
			editMenu.menuDay = menuDayJSON; 
		});

		this.addVariant = function(index){
			console.log(index);
			lastVariantOrder = this.menuDay.meals[index].variants.length;
			console.log(lastVariantOrder);
			this.menuDay.meals[index].variants.push({variant:"",variantOrder:lastVariantOrder + 1});
		};
		
		this.removeVariant = function(parentIndex, index){
			console.log("parentIndex: " + parentIndex + " index: " + index);
			console.log(this.menuDay.meals[parentIndex]);
			this.menuDay.meals[parentIndex].variants.splice(index, 1);
		};
		
		this.logMeal = function(){
			console.log(this.menuDay);
		};

	}]);
})();