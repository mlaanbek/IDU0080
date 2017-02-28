<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
 
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Users</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.2/jquery.min.js"></script>
</head>
<body onload="load();">
 
        Wash Code: <input type="text" id="wash_id" name="wash_id">
        Name: <input type="text" id="name" required="required" name="wash_name"><br>
        Duration: <input type="number" id="duration" required="required" name="wash_duration"><br>
        Price: <input type="number" id="price" required="required" name="wash_price"><br>
        <button onclick="submit();">Submit</button>
     
     
 
        <table id="table" border=1>
            <tr> <th> Wash Code </th> <th> Name </th> <th> Duration </th> <th> Price </th><th> Edit </th> <th> Delete </th> </tr>
         
        </table>
             
     
    <script type="text/javascript">
    data = "";
    submit = function(){
          
            $.ajax({
                url:'saveOrUpdate',
                type:'POST',
                data:{wash_id:$("#wash_id").val(),wash_name:$('#name').val(),wash_duration:$('#duration').val(), wash_price:$('#price').val()},
                success: function(response){
                        alert(response.message);
                        load();    
                }              
            });        
    }
     
    delete_ = function(wash_id){
    	console.log("Deleting: " + wash_id);
         $.ajax({
            url:'delete',
            type:'POST',
            data:{wash_id:wash_id},
            success: function(response){
                    alert(response.message);
                    load();
            }              
        });
	}
    
   
 
    edit = function (index){
        $("#wash_id").val(data[index].wash_id);
        $("#name").val(data[index].wash_name);
        $("#duration").val(data[index].wash_duration);
        $("#price").val(data[index].wash_price);
         
    }
     
     
    load = function(){
    	var text = "hola";
        $.ajax({
            url:'list',
            type:'POST',
            success: function(response){
                    data = response.data;
                    $('.tr').remove();
                    for(i=0; i<response.data.length; i++){                  
                        $("#table").append("<tr class='tr'> <td> "
                        		+response.data[i].wash_id + " </td> <td> " 
                        		+response.data[i].wash_name +" </td> <td> " 
                        		+response.data[i].wash_duration+ " </td> <td> " 
                        		+response.data[i].wash_price+" </td> <td> <a href='#' onclick= edit("+i+");> Edit </a>  </td> <td> <a href='#' onclick='delete_(\"" + response.data[i].wash_id + "\");'> Delete </a>  </td> </tr>");
                    }          
            }              
        });
         
    }
    
         
    </script>
     
</body>
</html>