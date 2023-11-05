let loginForm = document.querySelector(".my-form");

fetch("http://localhost:8080/login", {
    method: "POST",
    headers: {"Content-type": "application/json"},
    body: JSON.stringify({
        text: text
    })
}).then((response) => response.json());

loginForm.addEventListener("submit", (e) => {
    e.preventDefault();
    let username = document.getElementById("username");
    let password = document.getElementById("password");

    console.log('Username:', username.value);
    console.log('Password:', password.value);
    // process and send to API
});