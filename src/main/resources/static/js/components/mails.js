document.getElementById('deleteButt').addEventListener('click', getModalDelete);
document.getElementById('writeButt').addEventListener('click', getModalWrite);

const modal = $('#modal');

function getModalWrite() {
    const modalBody = document.createElement('div');
    modalBody.classList.add('modal-body');
    const modalInputToWho = document.createElement('input');
    modalInputToWho.classList.add('form-control');
    modalInputToWho.setAttribute('id', 'mail-who');
    modalInputToWho.setAttribute('placeholder', 'Имя получателя');
    const modalInputTheme= document.createElement('input');
    modalInputTheme.classList.add('form-control');
    modalInputTheme.setAttribute('id', 'mail-theme');
    modalInputTheme.setAttribute('placeholder', 'Тема');
    const modalText= document.createElement('textarea');3
    modalText.classList.add('form-control');
    modalText.setAttribute('id', 'mail-text');
    modalText.setAttribute('placeholder', 'Текст');
    modalBody.append(modalInputToWho);
    modalBody.append(modalInputTheme);
    modalBody.append(modalText);

    modal.empty();
    createModal("Новое письмо", modalBody, writeMail);
    modal.modal('toggle');
    return modal;
}

function getModalDelete() {
    modal.empty();
    createModal("Удалить выбранные письма?", "", deleteMail);
    modal.modal('toggle');
    return modal;
}

function createModal(title, modalBody, acceptFunction) {
    const modalDialog = document.createElement('div');
    modalDialog.classList.add('modal-dialog');
    modalDialog.role = 'document';

    const modalContent = document.createElement('div');
    modalContent.classList.add('modal-content');
    // Header
    const modalHeader = document.createElement('div');
    modalHeader.classList.add('modal-header');

    const modalTitle = document.createElement('h5');
    modalTitle.classList.add('modal-title');
    modalTitle.innerText = title;

    const dismissButton = document.createElement('button');
    dismissButton.classList.add('close');
    dismissButton.setAttribute('type', 'button');
    dismissButton.setAttribute('data-dismiss', 'modal');
    dismissButton.innerHTML = `<span aria-hidden="true">×</span>`;

// Footer
    const modalFooter = document.createElement('div');
    modalFooter.classList.add('modal-footer');

    const acceptButton = document.createElement('button');
    acceptButton.classList.add('btn', 'btn-primary');
    acceptButton.type = 'button';
    acceptButton.textContent = 'Принять';
    acceptButton.addEventListener('click', acceptFunction);

    const rejectButton = document.createElement('button');
    rejectButton.classList.add('btn', 'btn-secondary');
    rejectButton.type = 'button';
    rejectButton.textContent = 'Отмена';
    rejectButton.addEventListener('click', () => {
        modal.modal('toggle');
    });
    modalFooter.append(acceptButton, rejectButton);

    //create modal

    modalHeader.append(modalTitle, dismissButton);
    modalContent.append(modalHeader);
    modalContent.append(modalBody);
    modalContent.append(modalFooter);

    modalDialog.append(modalContent);
    document.getElementById('modal').append(modalDialog);

}

function writeMail(){}


function deleteMail() {
        $('#mails-list').find('input[type="checkbox"]:checked').each(function () {
            console.log(this.value);
            const row = this.parentElement.parentElement;
            let mailId = this.value;
            fetch(`/api/mail/${mailId}`, {
                method: 'DELETE',
            })
                .then(response => {
                    if (response.ok) {
                        row.remove();
                    } else {
                        return response.json().then(object => {
                            throw new Error(JSON.stringify(object));
                        })
                    }
                })
                .catch(error => {
                    console.error(error);
                });
        });
    modal.modal('toggle');
}
