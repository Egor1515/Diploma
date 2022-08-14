# Запуск тестового приложения
## Инструменты и Файлы: 
* IDEA intellij 123
* Java 11
* Allure
* Для запуска тестируемого приложения скачайте jar-файл из текущего каталога и добавьте его в artifacts 
## Запуск ДБ:
* Подключите DataBase(используя контейнера: mySql, postgresql),задав имена и остальные параметрами через докер
## Для запуска контейнеров докер используйте команды:
* docker run --name some-mysql -e MYSQL_ROOT_PASSWORD=my-secret-pw -d mysql:tag
* docker run --name some-postgres -e POSTGRES_PASSWORD=mysecretpassword -d postgres
## Запуск gate-simulator:
* Установить node.js или развернуть образ докер
* Добавьте в корень проекта папку с названием gate-simulator(из исходников дипломной работы)
* Перейдите в данную папку и используйте команду npm start
## Запуск jar-файла с передачей данных в jvm 
* Запустите само приложение командой java -jar artifacts/aqa-shop.jar, через флаг -D передайте все параметры
* Приложение будет запущено на порту 8080
* Если по каким-то причинам порт 8080 на вашей машине используется другим приложением, используйте:
java -jar app-order.jar -port=9090
## Команды для передачи параметров для запуска тестов с разными БД
* ./gradlew test -DUSER=app -DPASSWORD=9mREsvXDs9Gk89E -Durl=jdbc:mysql://localhost:3306/app - MYSQL
* ./gradlew test -DUSER=postgres -DPASSWORD=root -Durl=jdbc:postgresql://localhost:5432/app - POSTGRESQL




