$( "#myinput" ).rules( "add", {
    minlength: 2
});

$('#mail-form').validate({
    rules: {
        receivers: {
            required: true,
        },
        theme: {
            required: true,
            maxlength: 150
        },
        text: {
            required: true,
            maxlength: 1024
        },
    },
    messages: {
        receivers: {
            required: 'Поле не должно быть пустым'
        },
        theme: {
            required: 'Поле не должно быть пустым',
            maxlength: 'Максимум 150 символов'
        },
        text: {
            required: 'Поле не должно быть пустым',
            maxlength: 'Максимум 1024 символа'
        }
    },
    errorPlacement: function (error, element) {
        if (element.attr('type') == 'radio') {
            error.insertBefore(element.parent());
        } else {
            error.insertBefore(element);
        }
    }
});

