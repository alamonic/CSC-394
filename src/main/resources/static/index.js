const loginButton = document.getElementById("loginFormSubmit");
const loginForm = document.getElementById("loginForm");
const loginErrorMsg = document.getElementById("loginErrorMsg");

function isRememberMe() {
    const username = loginForm.username.value;
    const password = loginForm.password.value;
    fetch(`api/auth?username=${username}&password=${password}`, {method: "GET"})
        .then(response => response.json())
        .then(data => {
            console.log(data)
            if (data.status === "user") {
                alert("Successful, logging in now");
                location.href = `${location.href}userPage.html`;
            }
            else if (data.status === "admin") {
                alert("Successful, logging in now");
                location.href = `${location.href}adminDashboard.html`;
            }
            else {
                loginErrorMsg.style.opacity = 1;
                loginForm.username.value = ""
                loginForm.password.value = ""
            }
        })
}
loginButton.addEventListener("click", isRememberMe)



