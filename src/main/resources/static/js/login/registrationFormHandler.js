//Check messages
var url_string = window.location.href;
var url = new URL(url_string);
var message = url.searchParams.get("message");

if (message !== null) {
    //remove get parameters from url
    window.history.pushState(null, null, window.location.pathname);

    showError(message) ;

}

const registrationForm  = document.getElementById('registrationForm');

registrationForm.addEventListener('submit', function (event) {
    const password = document.getElementById('password');
    const repeatedPassword = document.getElementById('repeatedPassword');

  if(password.value !== repeatedPassword.value) {

    showError("Password and repeated password must be the same!");
    event.preventDefault();
  }
});

function showError(message) {
    alert(message);
}