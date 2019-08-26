var host = "http://localhost:8080";
$.ajax({
    url: host + '/getallcustomer',
    method: 'get',
    dataType: 'json',
    success: function(data) {
        console.log(data);
        data.forEach(function(item) {
            $('tbody').append('<tr><td>' + item.id + '</td><td>' + item["name"] + '</td><td>' + item["email"] + '</td><td>' + item.phone + '</td><td>' + item.currentbalance + '</td><td><button id="btnedit" class="btn btn-light" data-toggle="modal" data-target="#myModal" onclick="updateBalance()">Update</button></td><td><button class="btn btn-danger" onclick="deletecustomer(' + item.id + ')">Delete</button></td></tr>')
        });
    }
});

function deletecustomer(id) {
    $.ajax({
        type: 'DELETE',
        url: host + '/delete/' + id
    });
    window.location.href = host + "/";
}

function updateBalance() {
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
    var jsondata = { id: id, name: name, email: email, phone: phone, currentbalance: currentbalance }
    console.log(jsondata);
    $.ajax({
        type: 'PUT',
        url: host + '/update/' + id + '/' + currentbalance,
    });
    $('#myModal').modal('toggle');
    window.location.href = host + "/";
    $.ajax({
        type: 'POST',
        url: host + '/smsservice/' + name + '/' + currentbalance + '/' + phone,
    });
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
    var jsondata = { name: name, email: email, phone: phone, currentbalance: currentbalance }
    console.log(jsondata);
    $.ajax({
        type: 'POST',
        url: host + '/createcustomer',
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
    window.location.href = host + "/";
}