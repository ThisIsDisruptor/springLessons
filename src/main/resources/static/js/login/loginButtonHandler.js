var buttons = document.getElementsByClassName('loginButton');

for (var i = 0; i < buttons.length; i++) {
    buttons[i].onclick = function() {
        window.location.href = '/login';
    };
}