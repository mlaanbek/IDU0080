<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
	<title>IDU0080 KT1 Laanbek</title>
</head>
<body onload="load();">
    <div class="container">
    	<h1>All available car washes</h1>
    	<table class="table table-striped" id="table">
    		<thead>
    			<tr>
    				<th>Wash Code</th>
    				<th>Name</th>
    				<th>Type</th>
    				<th>Duration (min)</th>
    				<th>Price</th>
    			</tr>
    		</thead>
    		<tbody>
    			<tr>
    				<td><input type="text" id="wash_id" name="wash_id"></td>
    				<td><input type="text" id="name" required="required" name="wash_name"></td>
    				<td><input type="text" id="type" required="required" name="wash_type"></td>
    				<td><input type="number" id="duration" required="required" name="wash_duration"></td>
    				<td><input type="number" id="price" required="required" name="wash_price"></td>
    				<td><button class="btn btn-primary" onclick="submit()">Save/Update</button></td>
    			</tr>
    		</tbody>
    	
    	</table>
    </div>
    
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.2/jquery.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
	<script type="text/javascript">
		data = "";
	    submit = function(){
	          
	            $.ajax({
	                url:'saveOrUpdate',
	                type:'POST',
	                data:{wash_id:$("#wash_id").val(),wash_name:$('#name').val(),wash_duration:$('#duration').val(), wash_price:$('#price').val(), wash_type:$('#type').val()},
	                success: function(response){
	                		emptyFields();
	                        load();    
	                }              
	            });        
	    }
	     
	    delete_ = function(wash_id){
	         $.ajax({
	            url:'delete/wash/' + wash_id,
	            type:'DELETE',
	            contentType : 'application/json',
	            success: function(response){
	                    load();
	            }              
	        });
		}
	    
	   
	 
	    edit = function (index){
	        $("#wash_id").val(data[index].wash_id);
	        $("#name").val(data[index].wash_name);
	        $("#type").val(data[index].wash_type);
	        $("#duration").val(data[index].wash_duration);
	        $("#price").val(data[index].wash_price);
	         
	    }
	     
	     
	    load = function(){
	        $.ajax({
	            url:'list',
	            type:'GET',
	            success: function(response){
	                    data = response.data;
	                    $('.tr').remove();
	                    for(i=0; i<response.data.length; i++){                  
	                        $("#table").append("<tr class='tr'> <td> "
	    		                    		+response.data[i].wash_id + " </td> <td> " 
	                        		+response.data[i].wash_name +" </td> <td> "
	                        		+response.data[i].wash_type +" </td> <td> "
	                        		+response.data[i].wash_duration+ " </td> <td> " 
	                        		+response.data[i].wash_price+" </td> <td> <button class='btn btn-warning' onclick= edit("+i+");> Edit </button>  </td> <td> <button class='btn btn-danger' onclick='delete_(\"" + response.data[i].wash_id + "\");'> Delete </button>  </td> </tr>");
	                    }          
	            }              
	        });
	         
	    }
	    
	    emptyFields = function() {
	    	$("#wash_id").val("");
	        $("#name").val("");
	        $("#type").val("");
	        $("#duration").val("");
	        $("#price").val("");	
	    }
	</script>
</body>
</html>