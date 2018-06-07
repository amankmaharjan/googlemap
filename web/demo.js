var placesearchurl = "https://maps.googleapis.com/maps/api/place/details/json?placeid=ChIJSRvK4r4Y6zkRW1oV3_aWqTY&key=AIzaSyCmDzNapYvBM7xs95lX5Hh5tEKFZyJWYwk";

$.getJSON(placesearchurl)
    .done(function (json) {
        console.log("JSON Data: " + json.result);
    })
    .fail(function (jqxhr, textStatus, error) {
        var err = textStatus + ", " + error;
        console.log("Request Failed: " + err);
    });


var placesearchurl = "https://maps.googleapis.com/maps/api/place/details/json?placeid=ChIJSRvK4r4Y6zkRW1oV3_aWqTY&key=AIzaSyCmDzNapYvBM7xs95lX5Hh5tEKFZyJWYwk";
var baseurl = "https://maps.googleapis.com/maps/api/place/textsearch/json?key=AIzaSyCmDzNapYvBM7xs95lX5Hh5tEKFZyJWYwk&query=balaju nearby &type=gym";

$.ajax({
    url: placesearchurl
}).then(second,err1);


var show=function display(msg) {
    console.log("secon");
}

var second=function (data) {
    console.log("first");
    $.ajax({
        url: baseurl
    }).then(function (data) {
        show("alert")
    });

};
var err1=function (err) {
    console.log("err in 1");
}