#!/bin/bash
# Workaround: jextract does not work as a symlink because it references /usr/local/bin/../runtime/bin/java
/usr/local/jextract-22/bin/jextract \
  --library sqlite3 \
  --target-package org.sqlite.ffm.extracted \
  --output target/generated-sources/jextract \
  --include-dir /usr/include \
  /usr/include/sqlite3.h
