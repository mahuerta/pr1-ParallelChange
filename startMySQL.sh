#!/bin/sh

docker run --rm --name mysql -d -e MYSQL_ROOT_PASSWORD=pass -e MYSQL_DATABASE=test -p 3306:3306 mysql:8