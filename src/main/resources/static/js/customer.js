/*$.ajax({
    url: host + '/home/allpropertylist',
    method: 'get',
    dataType: 'json',
    success: function(data) {

        console.log(data);

        data.forEach(function(item) {
            $('tbody').append('<tr><td>' + item.site_id + '</td><td>' + item["add_creation_data"] + '</td><td>' + item["city"] + '</td><td>' + '<img src="data:image/jpg;base64,' + item.site_img_1 + '" alt="chennai" width="50" height="50"/></td></td>' + '</td><td>' + '<img src="data:image/jpg;base64,' + item.site_img_2 + '" alt="chennai" width="50" height="50"/>' + '</td></td>' + '</td><td>' + '<img src="data:image/jpg;base64,' + item.site_img_3 + '" alt="chennai" width="50" height="50"/>' + '</td></td>' + '</td><td>' + '<img src="data:image/jpg;base64,' + item.site_img_4 + '" alt="chennai" width="50" height="50"/>' + '</td></td>' + '</td><td>' + item["small_description"] + '</td></td>' + '</td><td class="wordbreak">' + item["detailed_description"] + '</td></td>' + '</td><td>' + item["price"] + '</td></td>' + '</td><td>' + item["builder_name"] + '</td></td>' + '</td><td>' + '<button id="btnedit" class="w3-btn w3-white w3-large" data-toggle="modal" data-target="#myModal" onclick="Edit()"><i class="w3-margin-center fa fa-edit"></i></button>' + '</td></td>' + '</td><td>' + '<button class="w3-btn w3-white w3-large" onclick="deleteProperty(' + item.site_id + ')"><i class="w3-margin-center fa fa-trash"></i></button>' + '</td><td>' + '<button class="w3-btn w3-black w3-large" onclick="viewproperty()"><i class="w3-margin-center fa fa-refresh"></i></button>' + '</td><td>' + '<span id="result"></span>' + '</td></tr>')
        }); //    <button class="w3-btn w3-green w3-large" onclick="viewproperty()"><i class="w3-margin-left fa fa-refresh"></i></button>
    }
});*/
//<pre > < span id = "result" > < /span></pre >

$.ajax({
    url: 'http://localhost:8080/getallcustomer',
    method: 'get',
    dataType: 'json',
    success: function(data) {
    	console.log(data);
        data.forEach(function(item) {
            $('tbody').append('<tr><td>' + item.id + '</td><td>' + item["name"] + '</td><td>' + item["email"] + '</td><td>' + item.phone + '</td><td>' + item.currentbalance + '</td><td><button id="btnedit" class="btn btn-light" data-toggle="modal" data-target="#myModal" onclick="Edit()">Update</button></td><td><button class="btn btn-danger" onclick="deletecustomer(' + item.id + ')">Delete</button></td></tr>')
        });
    }
});

function deletecustomer(id) {
    $.ajax({
        type: 'DELETE',
        url: 'http://localhost:8080/delete/'+id,
        success: function(id) {
        	console.log("deleted"+id);
        }
    });
}

function Edit() {
  var table = document.getElementById("tblprt"),
        rIndex;

      for (var i = 1; i < table.rows.length; i++) {
        table.rows[i].onclick = function() {
            rIndex = this.rowIndex;
            document.getElementById("id").value = this.cells[0].innerHTML;
            document.getElementById("name").value = this.cells[1].innerHTML;
            document.getElementById("email").value = this.cells[2].innerHTML;
            document.getElementById("phone").value = this.cells[3].innerHTML;
            document.getElementById("currentbalance").value = this.cells[4].innerHTML;
        };
    }
}

$(document).ready(function() {
    $("#btnSubmit").click(function(event) {
        event.preventDefault();
        updatedCurrentBalance();
    });

});

function updatedCurrentBalance() {
  
    $("#btnSubmit").prop("disabled", true);
    
	var id = $("#id").val();
    var name = $("#name").val();
    var email = $("#email").val();
    var phone = $("#phone").val();
    var currentbalance = $("#currentbalance").val();
    var jsondata = { id:id,name: name, email: email, phone: phone,currentbalance: currentbalance }
    console.log(jsondata);
   $.ajax({
        type: 'PUT',
        url: 'http://localhost:8080/update/'+id+'/'+currentbalance,
    });
    
   $('#myModal').modal('toggle');
}

$(document).ready(function() {

    $("#btnSave").click(function(event) {
        event.preventDefault();
        addCustomer();
    });
});

function addCustomer() {
	 console.log("add customer clicking");
	    $("#btnSave").prop("disabled", true);    
	    var name = $("#addname").val();
	    var email = $("#addemail").val();
	    var phone = $("#addphone").val();
	    var currentbalance = $("#addcurrentbalance").val();
	    var jsondata = {name: name, email: email, phone: phone,currentbalance: currentbalance }
	    console.log(jsondata);
	   $.ajax({
	        type: 'POST',
	        url: 'http://localhost:8080/createcustomer',
	       data: jsondata,
	        dataType: 'json',
	        success: function(data) {
	            console.log(data)
	        },
	        error: function(err) {
	            console.log("error" + err)
	        }
	    });
	    
	   $('#addModal').modal('toggle');
	}