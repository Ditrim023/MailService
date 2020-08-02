CREATE TABLE mail_user
(
    user_id       SERIAL PRIMARY KEY,
    user_name     VARCHAR(255) NOT NULL,
    user_password VARCHAR(255) NOT NULL
);
CREATE TABLE mail
(
    mail_id  SERIAL PRIMARY KEY,
    to_who   VARCHAR(255) NOT NULL,
    from_who VARCHAR(255) NOT NULL,
    theme    VARCHAR(255) NOT NULL,
    text     text         NOT NULL
);



insert into mail (to_who, from_who, theme, text)
values ('ToTest@emaple', 'fromTest@examaple', 'testSendIN',
        'test1');
insert into mail (to_who, from_who, theme, text)
values ('ToTest@emaple', 'fromTest@examaple', 'testSendIN',
        'test1');
insert into mail (to_who, from_who, theme, text)
values ('ToTest@emaple', 'fromTest@examaple', 'testSendIN',
        'test1');
insert into mail (to_who, from_who, theme, text)
values ('ivan', 'petrov', 'Разметка',
        'test1');
insert into mail (to_who, from_who, theme, text)
values ('ToTest@emaple', 'fromTest@examaple', 'testSendIN',
        'test1');
insert into mail (to_who, from_who, theme, text)
values ('ToTest@emaple', 'fromTest@examaple', 'testSendIN',
        'test1');
insert into mail (to_who, from_who, theme, text)
values ('ivan', 'petrov', 'Разметка',
        'test1');
insert into mail (to_who, from_who, theme, text)
values ('ToTest@emaple', 'fromTest@examaple', 'testSendIN',
        'test1');
insert into mail (to_who, from_who, theme, text)
values ('ToTest@emaple', 'fromTest@examaple', 'testSendIN',
        'test1');
insert into mail (to_who, from_who, theme, text)
values ('ToTest@emaple', 'fromTest@examaple', 'testSendIN',
        'test1');
insert into mail (to_who, from_who, theme, text)
values ('ivan', 'petrov', 'Разметка',
        'test1');
insert into mail (to_who, from_who, theme, text)
values ('ToTest@emaple', 'fromTest@examaple', 'testSendIN',
        'test1');
insert into mail (to_who, from_who, theme, text)
values ('ToTest@emaple', 'fromTest@examaple', 'testSendIN',
        'test1');
insert into mail (to_who, from_who, theme, text)
values ('ivan', 'petrov', 'Разметка',
        'test1');
insert into mail (to_who, from_who, theme, text)
values ('ToTest@emaple', 'fromTest@examaple', 'testReceiveOut',
        'test');
insert into mail (to_who, from_who, theme, text)
values ('ToTest@emaple', 'fromTest@examaple', 'testReceiveOut',
        'test');
insert into mail (to_who, from_who, theme, text)
values ('ToTest@emaple', 'fromTest@examaple', 'testReceiveOut',
        'test');
insert into mail (to_who, from_who, theme, text)
values ('ToTest@emaple', 'fromTest@examaple', 'testReceiveOut',
        'test');
insert into mail (to_who, from_who, theme, text)
values ('ToTest@emaple', 'fromTest@examaple', 'testReceiveOut',
        'test');
insert into mail (to_who, from_who, theme, text)
values ('ToTest@emaple', 'fromTest@examaple', 'testReceiveOut',
        'test');
insert into mail (to_who, from_who, theme, text)
values ('ToTest@emaple', 'fromTest@examaple', 'testReceiveOut',
        'test');
insert into mail (to_who, from_who, theme, text)
values ('ToTest@emaple', 'fromTest@examaple', 'testReceiveOut',
        'test');
insert into mail (to_who, from_who, theme, text)
values ('ToTest@emaple', 'fromTest@examaple', 'testReceiveOut',
        'test');
insert into mail (to_who, from_who, theme, text)
values ('ToTest@emaple', 'fromTest@examaple', 'testReceiveOut',
        'test');
insert into mail (to_who, from_who, theme, text)
values ('ToTest@emaple', 'fromTest@examaple', 'testReceiveOut',
        'test');
insert into mail (to_who, from_who, theme, text)
values ('ToTest@emaple', 'fromTest@examaple', 'testReceiveOut',
        'test');
insert into mail (to_who, from_who, theme, text)
values ('ToTest@emaple', 'fromTest@examaple', 'testReceiveOut',
        'test');
insert into mail (to_who, from_who, theme, text)
values ('ToTest@emaple', 'fromTest@examaple', 'testReceiveOut',
        'test');

insert into mail_user (USER_NAME, USER_PASSWORD)
values ('sidr.ivanov', '123456');
insert into mail_user (USER_NAME, USER_PASSWORD)
values ('Ivan.Sidiriv', '123456');
insert into mail_user (USER_NAME, USER_PASSWORD)
values ('admin.antonov', '123456');
