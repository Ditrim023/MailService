function init() {
    fetch(`/check/role`, {method: 'GET'})
        .then(response => {
            if (response.ok) {
                return response.text();
            } else {
                return response.json().then(object => {
                    throw new Error(JSON.stringify(object));
                })
            }
        })
        .then(role => {
            if (role === 'ROLE_APICALL') {
                $('#checkApi').prop('checked', true);
            } else {
                $('#checkApi').prop('checked', false);
            }
        })
        .catch(error => {
            console.error(error);
        });
}

$('#check').click(function () {
    let status = $('#checkApi').prop('checked');
    return fetch(`/api/set`, {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(status),
    })
        .then(response => {
            if (response.ok) {
                return response.json();
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

$(document).ready(() => {
    init();
});