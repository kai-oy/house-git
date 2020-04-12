function queyHousetype() {
    $.ajax({
        url: "/queryHouseType",
        type: "get",
        data: {},
        success: function (data) {
            for (var i = 0; i < data.length; i++) {
                var text = '<option value="' + data[i].id + '" >' + data[i].name + '</option>';
                var reg = new RegExp('"', "g");
                text = text.replace(reg, "");
                $("#houseType").append(text);
            }
        }
    })
}
function queyHouseByprice() {
    $.ajax({
        url: "/queryHouseByPrice",
        type: "get",
        data: {},
        success: function (data) {
            for (var i = 0; i < data.length; i++) {
                var text = '<option value="' + data[i].price + '" >' + data[i].price + '</option>';
                var reg = new RegExp('"', "g");
                text = text.replace(reg, "");
                $("#price").append(text);
            }
        }
    })
}

function queyHouseByFloorage() {
    $.ajax({
        url: "/queryHouseByFloorage",
        type: "get",
        data: {},
        success: function (data) {
            for (var i = 0; i < data.length; i++) {
                var text = '<option value="' + data[i].floorage + '" >' + data[i].floorage + '</option>';
                var reg = new RegExp('"', "g");
                text = text.replace(reg, "");
                $("#floorage").append(text);
            }
        }
    })
}


function showStreet(districtId){
    $.ajax({
        url: "/queryStreet",
        type: "get",
        data: {"districtId": districtId},
        success: function (data) {
            $('#Street option').not(":first").remove();
            for (var i = 0; i < data.length; i++) {
                var text = '<option value="' + data[i].id + '" >' + data[i].name + '</option>';
                var reg = new RegExp('"', "g");
                text = text.replace(reg, "");
                $("#Street").append(text);
            }
        }
    })}

function queyDistrict() {
    $.ajax({
        url: "/queryDistrict",
        type: "get",
        data: {},
        success: function (data) {
            for (var i = 0; i < data.length; i++) {
                var text = '<option value="' + data[i].id + '" >' + data[i].name + '</option>';
                var reg = new RegExp('"', "g");
                text = text.replace(reg, "");
                $("#District").append(text);
            }
        }
    })
}
