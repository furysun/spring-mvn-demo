function validate() {
    var login = document.getElementById("login").value;
    var password = document.getElementById("password").value;
    var errorMessage = document.getElementById("errorMessage");

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

