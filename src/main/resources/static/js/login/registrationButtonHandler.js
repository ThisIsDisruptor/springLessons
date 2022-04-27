var buttons = document.getElementsByClassName('registrationButton');

for (var i = 0; i < buttons.length; i++) {
    buttons[i].onclick = function() {
        window.location.href = '/registration';
    };
}