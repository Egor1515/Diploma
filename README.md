## Запуск тестового приложения
1. Для запуска тестируемого приложения скачайте jar-файл из текущего каталога и добавьте его в artifacts 
2. Подключите DataBase(используя контейнера: mySql, postgresql),задав имена и остальные параметрами командами:
* docker run --name some-mysql -e MYSQL_ROOT_PASSWORD=my-secret-pw -d mysql:tag
* docker run --name some-postgres -e POSTGRES_PASSWORD=mysecretpassword -d postgres
3. Запустите gate-simulator, предварительно развернув docker на node.js командой npm start
4. Запустите само приложение командой java -jar artifacts/aqa-shop.jar
5. Приложение будет запущено на порту 8080
6. Если по каким-то причинам порт 8080 на вашей машине используется другим приложением, используйте:
java -jar app-order.jar -port=9090



