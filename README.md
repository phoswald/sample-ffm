# sample-ffm

Experiments with Foreign Function &amp; Memory API (Java 22)

## Extract API using `jextract`

~~~
$ sudo apt install sqlite3 libsqlite3-0 libsqlite3-dev

$ /usr/local/jextract-22/bin/jextract \
  --library sqlite3 \
  --target-package org.sqlite.ffm.extracted \
  --output target/generated-sources/jextract \
  --include-dir /usr/include \
  /usr/include/sqlite3.h
~~~

Move code from `target/generated-sources/jextract` to `src/main/java` (temporarily).

## Download specific version

~~~
$ curl 'https://www.sqlite.org/2024/sqlite-tools-linux-x64-3460000.zip' -s -o sqlite.zip
$ unzip sqlite.zip -d src/sqlite
~~~
