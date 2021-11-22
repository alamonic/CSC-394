function changeUsername(username){
    document.getElementById("userHeader").innerHTML = "Welcome ";
}

function startTimer(duration, display) {

    var timer = duration, minutes, seconds;
    setInterval(function () {
        minutes = parseInt(timer / 60, 10);
        seconds = parseInt(timer % 60, 10);

        if (minutes<1) {
            document.getElementById("time").style.color = "red";
        }
        minutes = minutes < 10 ? "0" + minutes : minutes;
        seconds = seconds < 10 ? "0" + seconds : seconds;

        display.textContent = minutes + ":" + seconds;

        if (--timer < 0) {
           // timer = duration;
            document.location.href = "/userQuestionPage.html";
        }
    }, 1000);
}

window.onload = function () {
    var fiveMinutes = 3,
        display = document.querySelector('#time');
    startTimer(fiveMinutes, display);
};

function init() {
    changeUsername("username")
}

init();