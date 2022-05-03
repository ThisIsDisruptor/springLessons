
let url = "users/me"

fetch(url)
  .then(response => response.json())
  .then(user => {
    let div = document.getElementById('textField');
    div.innerHTML += "Hello, " + user.login;
  });

var myTasksButtons = document.getElementsByClassName('myTasksButton');

for (var i = 0; i < myTasksButtons.length; i++) {
    myTasksButtons[i].onclick = function() {
        window.location.href = '/tasks/myTasks';
    };
}

