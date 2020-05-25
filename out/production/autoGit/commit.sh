#!/bin/bash

cd "$1" &&
git add . &&
git commit -am "FromPlugin$2"