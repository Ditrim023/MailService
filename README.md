
GET /api/users - возвращает список зарегистрированных пользователей;

GET /api/mails - возвращает последние 20 писем пользовательского почтового ящика;

POST /api/mails - поиск писем. На вход принимает строку, 

DELETE /api/mail/{mail_id} - удаление письма пользователя по ID письма;

POST /api/mail - отправить новое письмо. На вход принимает JSON пример ниже:
```
 {
        "receiver": "Jhon.Doe",
        "theme": "test.api",
        "text": "beberberberwberbrebfdvbhvbsdjqwertyvbsdovbdlsjbvdlsjbfldbflkbdslkfbdslkfbdslkfbdsk"
}
```
Зарегестрированные пользователи
```
admin.antonov
Jhon.Doe
Ivan.Sidorov
пароль
123456
```