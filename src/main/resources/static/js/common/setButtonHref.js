function setButtonHref(buttonId, href) {
    var button = document.getElementById(buttonId);

    if (button !== null) {
        button.onclick = function() {
            window.location.href = href;
        };
    }

}