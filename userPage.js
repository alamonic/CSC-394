function changeUsername(username){
    document.getElementById("userHeader").innerHTML = "Welcome ";

}

function startTimer(duration, display) {
<<<<<<< HEAD
    fetch("/responses/starttimer", {method: "GET"})
        .then(res => res.json())
=======
>>>>>>> main
    var timer = duration, minutes, seconds;
    setInterval(function () {
        minutes = parseInt(timer / 60, 10);
        seconds = parseInt(timer % 60, 10);

<<<<<<< HEAD
=======
        if (minutes<1) {
            document.getElementById("time").style.color = "red";

        }
>>>>>>> main
        minutes = minutes < 10 ? "0" + minutes : minutes;
        seconds = seconds < 10 ? "0" + seconds : seconds;

        display.textContent = minutes + ":" + seconds;

        if (--timer < 0) {
            timer = duration;
        }
    }, 1000);
}

<<<<<<< HEAD
=======

>>>>>>> main
window.onload = function () {
    var fiveMinutes = 60 * 5,
        display = document.querySelector('#time');
    startTimer(fiveMinutes, display);
};

function init() {
    
    changeUsername("username")
  }
  
  
  init();