function buildLines(cars){
	$tbody = $('#carTable tbody');
	$tbody.empty();
	for(var count=0;count<cars.length;count++){
		var car=cars[count];
		$tr=$('<tr>');
		$brand=$('<td>');
		$model=$('<td>');
		$color=$('<td>');
		$horsePower=$('<td>');
		$plateNumber=$('<td>;')
		$kilometerRate=$('<td>');
		$price=$('<td>');
				
		$brand.html(car.brand);
		$model.html(car.model);
		$color.html(car.color);
		$horsePower.html(car.horsePower);
		$plateNumber.html(car.plateNumber);
		$kilometerRate.html(car.kilometerRate);
		$price.html(car.price);
		
		$tr.append($brand);
		$tr.append($model);
		$tr.append($color);
		$tr.append($horsePower);
		$tr.append($plateNumber);
		$tr.append($price);
		$tr.append($kilometerRate);
		$tbody.append($tr);
	}
}

function buildEmptyLine(){
	$tbody = $('#carTable tbody');
	$tbody.empty();
	$tbody.append($("<tr><th colspan='100%'>No data found</th></tr>"))
}
$( document ).ready(function() {
	$.ajax({
		url:"../CarServlet",
		data:{
			 action:"getCars"
		 }
	})
	.done(function(data) {
		if(data!=undefined && data.cars!=undefined && data.cars.length>0 ){
			buildLines(data.cars);
		}
		else{
			buildEmptyLine();
		}
  })
})