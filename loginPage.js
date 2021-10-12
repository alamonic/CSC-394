const loginButton = document.getElementById("loginFormSubmit");
const loginForm = document.getElementById("loginForm");
const loginErrorMsg = document.getElementById("loginErrorMsg");

loginButton.addEventListener("click", (input) => {
        input.preventDefault();
        const username = loginForm.username.value;
        const password = loginForm.password.value;
    }
   /*
   We'll need to change this to be universal for each user
            if (username === "user" && password === " ") {
                alert("Successful, logging in now");
                location.reload();
            } else {
                loginErrorMsg.style.opacity = 1;
            }
        }
    */
)