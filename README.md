<h1 >Дипломный проект по тестированию API на <a href="https://reqres.in/">reqres.in</a></h1>



## :page_with_curl: Содержание

* <a href="#tools">Технологии и инструменты</a>

* <a href="#cases">Реализованные проверки</a>

* <a href="#console">Запуск тестов из терминала</a>

* <a href="#jenkins">Запуск тестов в Jenkins</a>

* <a href="#telegram">Уведомления в Telegram</a>

* <a href="#allure">Allure Report отчеты</a>

* <a href="#allure-testops">Интеграция с Allure TestOps</a>

* <a href="#jira">Интеграция с Jira</a>


<a id="tools"></a>
## Технологии и инструменты

| Java                                                                                                    | IntelliJ Idea                                                                                                                | Allure                                                                                                                    | Allure TestOps                                                                                                      | GitHub                                                                                                    | JUnit 5                                                                                                          | Gradle                                                                                                    | REST Assured                                                                                                             |                                                                                                         Jenkins | Jira                                                                                                                         |
|:--------------------------------------------------------------------------------------------------------|------------------------------------------------------------------------------------------------------------------------------|---------------------------------------------------------------------------------------------------------------------------|---------------------------------------------------------------------------------------------------------------------|-----------------------------------------------------------------------------------------------------------|------------------------------------------------------------------------------------------------------------------|-----------------------------------------------------------------------------------------------------------|--------------------------------------------------------------------------------------------------------------------------|----------------------------------------------------------------------------------------------------------------:|------------------------------------------------------------------------------------------------------------------------------|
| <a href="https://www.java.com/"><img src="media/logo/Java.svg" width="50" height="50"  alt="Java"/></a> | <a id ="tech" href="https://www.jetbrains.com/idea/"><img src="media/logo/Idea.svg" width="50" height="50"  alt="IDEA"/></a> | <a href="https://github.com/allure-framework"><img src="media/logo/Allure.svg" width="50" height="50"  alt="Allure"/></a> | <a href="https://qameta.io/"><img src="media/logo/Allure_TO.svg" width="50" height="50"  alt="Allure TestOps"/></a> | <a href="https://github.com/"><img src="media/logo/GitHub.svg" width="50" height="50"  alt="Github"/></a> | <a href="https://junit.org/junit5/"><img src="media/logo/Junit5.svg" width="50" height="50"  alt="JUnit 5"/></a> | <a href="https://gradle.org/"><img src="media/logo/Gradle.svg" width="50" height="50"  alt="Gradle"/></a> | <a href="https://rest-assured.io/"><img src="media/logo/RestAssured.svg" width="50" height="50"  alt="RestAssured"/></a> | <a href="https://www.jenkins.io/"><img src="media/logo/Jenkins.svg" width="50" height="50"  alt="Jenkins"/></a> | <a href="https://www.atlassian.com/ru/software/jira"><img src="media/logo/Jira.svg" width="50" height="50"  alt="Jira"/></a> |


<a id="cases"></a>
## :heavy_check_mark: Реализованные проверки

-  Создание нового пользователя
-  Успешная/неуспешная регистрация пользователя
-  Успешная/неуспешная авторизация пользователя

<a id="console"></a>
##  Запуск тестов из терминала
### Локальный запуск тестов

```
gradle clean test  
```

<a id="jenkins"></a>
## <img src="media/logo/Jenkins.svg" width="25" height="25"/></a> Запуск тестов в [Jenkins](https://jenkins.autotests.cloud/job/22_Bubalov_FinalProject_Api/)

<p align="center">

> Для запуска сборки необходимо перейти в раздел "Build with Parameters" и нажать кнопку "Build".

<a href="https://jenkins.autotests.cloud/job/22_Bubalov_FinalProject_Api/"><img src="media/screenshots/Jenkins.png" alt="Jenkins"/></a>

> При клике на сборку после завершения можно увидеть артефакты запуска и полезные ссылки для более детального изучения прогона.

<a href="https://jenkins.autotests.cloud/job/22_Bubalov_FinalProject_Api/10/"><img src="media/screenshots/JenkinsIntegration.png" alt="Jenkins"/></a>
</p>

<a id="telegram"></a>
## <img src="media/logo/Telegram.svg" width="25" height="25"/></a> Уведомления в Telegram

<p >

> С помощью настроенного бота после завершения прогона в Jenkins поступают уведомления в Telegram.

<img title="telegram bot" src="media/screenshots/TelegrammBotApi.png" width="600px">
</p>

<a id="allure"></a>
## <img src="media/logo/Allure.svg" width="25" height="25"/></a> [Allure Report](https://jenkins.autotests.cloud/job/22_Bubalov_FinalProject_Api/allure/) отчеты

### Основное окно

<p align="center">
<a href="https://jenkins.autotests.cloud/job/22_Bubalov_FinalProject_Api/10/allure/"><img title="Allure Dashboard" src="media/screenshots/AllureDashboard.png"></a>
</p>

### Отчеты по тестам

<p align="center">

> В отчете по тестам присутствует развернутая информация по запросам и ответам.

<a href="https://jenkins.autotests.cloud/job/22_Bubalov_FinalProject_Api/10/allure/#behaviors"><img title="Allure Tests" src="media/screenshots/AllureWithInfo.png"></a>
</p>

<a id="allure-testops"></a>
## <img src="media/logo/Allure_TO.svg" width="25" height="25"/></a> Интеграция с [Allure TestOps](https://allure.autotests.cloud/project/3919/dashboards)

### Основное окно

<p align="center">
<a href="https://allure.autotests.cloud/project/3919/dashboards"><img title="Allure TestOps" src="media/screenshots/DashBoard_TO.png"></a>
</p>

### Дерево тестов с разделением по фичам

<p align="center">
<img title="Allure TestOps" src="media/screenshots/TreeByFeatures_TO.png">
</p>

<a id="jira"></a>
## <img src="media/logo/Jira.svg" width="25" height="25"/></a> Интеграция с [Jira](https://jira.autotests.cloud/browse/HOMEWORK-1025)

<p align="center">
<a href="https://jira.autotests.cloud/browse/HOMEWORK-1025"><img title="Jira" src="media/screenshots/JiraApi.png"></a>
</p>
