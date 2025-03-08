# sample-ffm

Experiments with Foreign Function &amp; Memory API

## Build

~~~
$ ./build-database.sh
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
