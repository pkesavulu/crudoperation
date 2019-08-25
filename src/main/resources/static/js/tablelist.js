$.ajax({
    url: host + 'http://localhost:8080/getallcustomer',
    method: 'get',
    dataType: 'json',
    success: function(data) {

        console.log(data);

        data.forEach(function(item) {
            $('tbody').append('<tr><td>' + item.customerId + '</td><td>' + item["customerName"] + '</td><td>' + item["email"] + '</td><td>' + item.mobileno + '</td><td>' + new Date(item.timestamp).toLocaleString() + '</td></tr>')
        });
    }
});