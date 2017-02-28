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