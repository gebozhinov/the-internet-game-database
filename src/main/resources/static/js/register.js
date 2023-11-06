let loginForm = document.querySelector(".my-form");

fetch("http://localhost:8080/register", {
    method: "POST",
    headers: {"Content-type": "application/json"},
    body: JSON.stringify({
        text: text
    })
}).then((response) => response.json());

loginForm.addEventListener("submit", (e) => {
    e.preventDefault();
    let username = document.getElementById("username");
    let email = document.getElementById("email");
    let age = document.getElementById("age");
    let password = document.getElementById("password");
    let confirmPassword = document.getElementById("confirmPassword");

    console.log('Username:', username.value);
    console.log('Email:', email.value);
    console.log('Age:', age.value);
    console.log('Password:', password.value);
    console.log('Confirm Password:', confirmPassword.value);
    // process and send to API
});