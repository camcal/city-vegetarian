(function(){
	var app = angular.module("editMenu",[]);
	
	app.controller("MealController",function(){
		this.meal = 
             {
            	 base:"Chleba s maslom",
            	 price:0.5,
            	 variants: [
            	     {
            	    	 variant:"a medom",
            	         variantOrder:1
            	     },
            	     {
            	    	 variant:"lekvarom",
            	         variantOrder:2
            	     }
            	 ]
             }
        ;
		this.addVariant = function(){
			console.log(this.meal.variants.length+1);
			this.meal.variants.push({variant:"",variantOrder:this.meal.variants.length+1});
		};
		
		this.removeVariant = function(index){
			this.meal.variants.splice(index, 1);
		};
		
		this.logMeal = function(){
			console.log(this.meal);
		};

	});
})();