function commitJsonData(url, type, data, suc, err) {
    $.ajax({
        url: url
        , type: type
        , data: JSON.stringify(data)
        , async: true
        , contentType: "application/json;charset=utf-8"
        , dataType: 'json'
        , success: function (r) {
            suc(r)
        }, error: function (e) {
            err(e)
        }
    })
}

function get(url, data, suc, err) {
    request(url, "GET", data, suc, err);
}

function requestByJson(url, type, data, suc, err) {
    $.ajax({
        url: url
        , type: type
        , data: data
        , async: true
        , contentType: "application/json;charset=utf-8"
        , dataType: 'json'
        , success: function (r) {
            suc(r)
        }, error: function (e) {
            err(e)
        }
    })
}

function request(url, type, data, suc, err) {
    $.ajax({
        url: url
        , type: type
        , data: data
        , async: true
        , dataType: 'json'
        , success: function (r) {
            suc(r)
        }, error: function (e) {
            err(e)
        }
    })
}

function requestWithParams(url, type, data, suc, err, params) {
    $.ajax({
        url: url
        , type: type
        , data: data
        , async: true
        , dataType: 'json'
        , global : (params == undefined || params == null || params.global == undefined || params.global == null) ? true : params.global
        , success: function (r) {
            suc(r)
        }, error: function (e) {
            err(e)
        }
    })
}

function uploadFile(formData, success, err) {
    $.ajax({
        url : '/file/upload'
        , type : "POST"
        , data : formData
        , cache : false
        , processData : false
        , contentType : false
        , success : success
        , error : err
    })
}