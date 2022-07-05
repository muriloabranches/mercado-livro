Create MySQL Database with Docker:

```sh
docker run --name kotlin-mysql -e MYSQL_ROOT_PASSWORD=root -e MYSQL_DATABASE=mercadolivro -p 3306:3306 -d mysql:latest
```