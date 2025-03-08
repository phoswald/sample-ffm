# sample-ffm

Experiments with Foreign Function &amp; Memory API

## Build

~~~
$ mvn clean verify
~~~

## Installation

Install Jextract from https://jdk.java.net/jextract/

Install SQLite:

~~~
$ sudo apt install sqlite3 libsqlite3-0 libsqlite3-dev
~~~

Alternatively, install specific version of SQLite from:

~~~
$ curl 'https://www.sqlite.org/2024/sqlite-tools-linux-x64-3460000.zip' -s -o sqlite.zip
$ unzip sqlite.zip -d src/sqlite
~~~

## Database

~~~
$ DB_FILE=databases/testdata.db && \
  sqlite3 ${DB_FILE} -- "CREATE TABLE person_(id_, name_);" && \
  sqlite3 ${DB_FILE} -- "INSERT INTO person_(id_, name_) values (1, 'Philip');" && \
  sqlite3 ${DB_FILE} -- "INSERT INTO person_(id_, name_) values (2, 'Oy');" && \
  sqlite3 ${DB_FILE} -- "INSERT INTO person_(id_, name_) values (3, 'Marc');" && \
  sqlite3 ${DB_FILE} -- "INSERT INTO person_(id_, name_) values (4, 'Liam');"
~~~
