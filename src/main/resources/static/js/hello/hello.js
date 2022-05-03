
let url = "users/me"

fetch(url)
  .then(response => response.json())
  .then(user => {
    let div = document.getElementById('textField');
    div.innerHTML += "Hello, " + user.login;
  });






