const mailsList = document.getElementById('mails-list');

function init() {
    fetch(`/api/mails`, {method: 'GET'})
        .then(response => {
            if (response.ok) {
                return response.json();
            } else {
                return response.json().then(object => {
                    throw new Error(JSON.stringify(object));
                })
            }
        })
        .then(mails => {
            mails.forEach(mail => {
                mailsList.append(new MailElement(mail));
            });
        })
        .catch(error => {
            console.error(error);
        });
}

window.customElements.define('mail-element', MailElement);
import MailElement from "/js/elements/MailElement.js";

$(document).ready(() => {
    init();
});