#!/bin/bash
/usr/local/jextract-22/bin/jextract \
  --library sqlite3 \
  --target-package org.sqlite.ffm.extracted \
  --output target/generated-sources/jextract \
  --include-dir /usr/include \
  /usr/include/sqlite3.h
