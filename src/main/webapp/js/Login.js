
var registration = function () {
};


document.getElementById("log-in button").onclick = function () {

    console.log("WTF?");
    var log = document.getElementById("email").value;
    var pass = document.getElementById("password").value;
    $.ajax({
        type: "POST",
        url: "/lol",
        data: {login: log, password: pass},
        success: function (data) {
            console.log("WATMAN?");
            console.log(data);
        }
    });
}