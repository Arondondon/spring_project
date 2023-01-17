# Создание сайта на Java на тему: Автомобильные перевозки, отдел продаж

## Оглавление

1. [Структура проекта](#Структура-проекта)
   1. [Описание проекта](#Описание-проекта)
   2. [Описание сервиса](#Описание-сервиса)
   3. [Models](#Models)
   4. [Views](#Views)
   5. [Controllers](#Controllers)
2. [Страницы сайта](#Страницы-сайта)
   1. [Блоки Header и Footer](#Блоки-Header-и-Footer)
   2. [Home](#Home)
   3. [Catalog](#Catalog)
   4. [Car Park](#Car-Park)
   5. [About](#About)
   6. [Order](#Order)
   7. [Orders](#Orders)
   8. [Sign up](#Sign-up)
   9. [Sign in](#Sign-in)
   10. [Manager Registration](#Manager_registration)
3. [Как собрать проект](#Как-собрать-проект)


## Структура проекта
 
### Описание проекта
Проект написан на ЯП Java с использованием фреймворка 
Spring, БД MySQL, а также с помощью HTML и CSS. 
Структура проекта соответствует схеме MVC. Таким 
образом, все файлы проекта (за исключением файлов 
свойств, зависимостей и т.д.) попадают под одну 
из категорий: [models](#Models), [views](#Views), 
[controllers](#Controllers). 
### Описание сервиса
Сервис представляет собой сайт для заказа 
втомобильных грузоперевозок. Пользователь может 
ознакомиться со списком услуг и автомобилей, а затем 
заполнить форму и сделать заказ. На сайте присутствует
регистрация и авторизация пользователей. У 
зарегистрированных пользователей может быть одна из 
трёх ролей: user, manager, admin. Обычный 
зарегистрированный пользователь, в отличие от
незагеристрированного может заполнить
и сделать заказ. Менеджеру по сравнению с обычным 
пользователем доступны различные функции по управлению
сервисом. А администратор по сравнению с менеджером
может ещё и регистрировать новых менеджеров. 
### Models
Сервис работает с базой данных, в которой хранится 
информация об услугах фирмы, автомобильном парке, 
пользователях и заказах. Поэтому под категорию моделей
попадают все классы данных, 
хранящихся в БД, репотизориев и сервисов. 
[Ссылка](https://github.com/Arondondon/spring_project/tree/master/src/main/java/com/work/spring_project/models) 
на директорию models. 
### Views
Работу сервиса отображают страницы сайта. Поэтому под 
категорию представлений попадают HTML шаблоны страниц,
которые могут отображать различную информацию, в 
зависимости от различных условий (роль пользователя, 
наполнение базы данных и т.д.).
[Ссылка](https://github.com/Arondondon/spring_project/tree/master/src/main/resources/templates)
на директорию templates.
### Controllers
Для того, чтобы загружать страницы сайта с нужной 
информацией, а также для обработки POST запросов 
нужны классы, которые будут всё это делать. Под эту 
категорию как раз попадают контроллеры. Они достают из
БД нужные данные, а затем отправляют их на страницы, 
которые их уже отображают нужным образом. Также 
контроллеры формы на страницах, добавляя в БД новые
данные.
[Ссылка](https://github.com/Arondondon/spring_project/tree/master/src/main/java/com/work/spring_project/controllers)
на директорию controllers.
## Страницы сайта

### Блоки Header и Footer
На каждой странице (кроме страницы авторизации) есть 
верхний и нижний блоки. В верхнем расположены эмблема
и названии компании, ссылки на другие страницы сайта,
а также кнопки авторизации(если вход не был выполнен),
выхода из аккаунта(если вход был выполнен) и 
регистрации. В нижнем ссылки на другие страницы сайта
и другое. Наполненность ссылками на другие страницы 
в обоих блоках зависит от роли пользователя.
![Alt-text](https://github.com/Arondondon/spring_project/blob/master/src/main/resources/static/images/readme/header1.png)
Хедер без авторизации
![Alt-text](https://github.com/Arondondon/spring_project/blob/master/src/main/resources/static/images/readme/header2.png)
Хедер с авторизацией администратора
![Alt-text](https://github.com/Arondondon/spring_project/blob/master/src/main/resources/static/images/readme/footer.png)
Футер без авторизации
### Home
На главной странице сервиса расположены рекламные 
баннеры, краткое описание преимуществ компании, а 
также кнопки для перехода на другие страницы.
![Alt-text](https://github.com/Arondondon/spring_project/blob/master/src/main/resources/static/images/readme/home1.png)
![Alt-text](https://github.com/Arondondon/spring_project/blob/master/src/main/resources/static/images/readme/home2.png)
### Catalog
На странице с каталогом услуг располагается список 
предоставляемых компанией услуг с описанием и 
минимальной ценой,а также возможностью перейти в
раздел заказа (если вход не выполнен, переадресация 
на страницу авторизации). Если вход выполнен под 
менеджером или администратором, на странице появляются
дополнительные возможности по управлению сервисом.
![Alt-text](https://github.com/Arondondon/spring_project/blob/master/src/main/resources/static/images/readme/catalog1.png)
Для пользователей и посетителей
![Alt-text](https://github.com/Arondondon/spring_project/blob/master/src/main/resources/static/images/readme/catalog2.png)
Для менеджера и админа
### Car Park
На странице с автомобильным парком располагается список
предоставляемых компанией автомобилей с описанием и
минимальной ценой,а также возможностью перейти в
раздел заказа (если вход не выполнен, переадресация
на страницу авторизации). Если вход выполнен под
менеджером или администратором, на странице появляются
дополнительные возможности по управлению сервисом.
![Alt-text](https://github.com/Arondondon/spring_project/blob/master/src/main/resources/static/images/readme/carpark1.png)
Для пользователей и посетителей
![Alt-text](https://github.com/Arondondon/spring_project/blob/master/src/main/resources/static/images/readme/carpark2.png)
Для менеджера и админа
### About
На странице с информацией о компании расположено краткое
описание и контактные данные.
![Alt-text](https://github.com/Arondondon/spring_project/blob/master/src/main/resources/static/images/readme/about.png)
### Order
**Переход на страницу с оформлением заказа возможен только
для авторизованных пользователей, в противном случае 
сайт переадресует посетителя на страницу авторизации.**
На странице с заказом расположена форма, которую нужно
заполнить для оформления заказа. При нажатии на кнопку
"Continue" происходит переход на страницу подтверждения
заказа, где заказчик может проверить свои данные, а 
также узнать итоговую стоимость заказа. Если его всё
устраивает, нужно нажать на кнопку подтверждения, а в
противном случае на кнопку редактирования заказа.
![Alt-text](https://github.com/Arondondon/spring_project/blob/master/src/main/resources/static/images/readme/order.png)
Страница оформления заказа
![Alt-text](https://github.com/Arondondon/spring_project/blob/master/src/main/resources/static/images/readme/confirm.png)
Страница подтверждения заказа
### Orders
**Эта страница доступна только менеджерам и админу.**
На странице с заказами располагается список всех 
оформленных заказов с полным описанием. Заказ можно 
удалить, если он выполнен.
![Alt-text](https://github.com/Arondondon/spring_project/blob/master/src/main/resources/static/images/readme/orders.png)
### Sign up
Страница для регистрации обычных пользователей.
![Alt-text](https://github.com/Arondondon/spring_project/blob/master/src/main/resources/static/images/readme/signup.png)
### Sign in
Страница для авторизации.
![Alt-text](https://github.com/Arondondon/spring_project/blob/master/src/main/resources/static/images/readme/signin.png)
### Manager Registration
**Эта страница доступна только администратору.**
Страница для регистрации менеджеров. Почти ничем
не отличается от обычной страницы регистрации кроме 
того, что зарегистрованный здесь пользователь имеет
права менеджера.
![Alt-text](https://github.com/Arondondon/spring_project/blob/master/src/main/resources/static/images/readme/manreg.png)
## Как собрать проект
Чтобы запустить данный проект на своём пк, нужно:
1. В среде разработки Intellij Idea создать Spring Boot
проект.
2. Подключить к проекту данный репозиторий.
3. Сделать update проекта с репозитория.
4. В СУБД MySQL создать базу данных.
5. В файле [application.properties](https://github.com/Arondondon/spring_project/blob/master/src/main/resources/application.properties)
ввести нужные название базы данных, имя пользователя (стандартно "root")
и пароль.
```
spring.datasource.url=jdbc:mysql://${MYSQL_HOST:localhost}:3306/<название_БД>
spring.datasource.username=<имя_пользователя>
spring.datasource.password=<пароль>
```
6. После этого можно запускать проект и после 
успешного запуска открывать в браузере
[ссылку](http://localhost:8080/)