"use strict";

function validate() {
    var name = document.getElementById("name").value;
    var login = document.getElementById("login").value;
    var password = document.getElementById("password").value;
    var errorMessage = document.getElementById("errorMessage");

    if (name === "") {
        errorMessage.innerHTML = "Enter your name";
        return false;
    }

    if (name.length > 10) {
        errorMessage.innerHTML = "Name too long";
        return false;
    }

    if (login === "" || password === "") {
        errorMessage.innerHTML = "login and password are required";
        return false;
    }

    if (login.length > 10) {
        errorMessage.innerHTML = "login too long";
        return false;
    }

    if (password.length > 10) {
        errorMessage.innerHTML = "password too long";
        return false;
    }
}