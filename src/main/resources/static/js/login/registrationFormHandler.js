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