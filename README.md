# sample-ffm

Experiments with Foreign Function &amp; Memory API

# Build

~~~
$ ./build-database.sh
$ mvn clean verify
~~~

## Install SQLite

~~~
$ sudo apt install sqlite3 libsqlite3-0 libsqlite3-dev
~~~

Alternatively, download specific verson:

~~~
$ curl 'https://www.sqlite.org/2024/sqlite-tools-linux-x64-3460000.zip' -s -o sqlite.zip
$ unzip sqlite.zip -d src/sqlite
~~~
