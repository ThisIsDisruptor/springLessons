var buttons = document.getElementsByClassName('logoutButton');

for (var i = 0; i < buttons.length; i++) {
    buttons[i].onclick = function() {
        window.location.href = '/logout';
    };
}