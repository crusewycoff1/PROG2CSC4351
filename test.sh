#!/usr/bin/env sh
clear
make clean
make
java -cp lib:../:./ Parse/Main.java test.c