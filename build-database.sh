#!/bin/bash
DB_FILE=databases/testdata.db
rm ${DB_FILE}
sqlite3 ${DB_FILE} -- "CREATE TABLE person_(id_, name_);"
sqlite3 ${DB_FILE} -- "INSERT INTO person_(id_, name_) values (1, 'Philip');"
sqlite3 ${DB_FILE} -- "INSERT INTO person_(id_, name_) values (2, 'Oy');"
sqlite3 ${DB_FILE} -- "INSERT INTO person_(id_, name_) values (3, 'Marc');"
sqlite3 ${DB_FILE} -- "INSERT INTO person_(id_, name_) values (4, 'Liam');"
