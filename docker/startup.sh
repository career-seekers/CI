#!/bin/bash
mkdir -p /app

dpkg --configure -a

apt-get update && apt-get install -y git

cd /app

git clone https://github.com/career-seekers/CI.git .

./gradlew build

cd build/libs

chmod +x cs-ci-0.0.1-SNAPSHOT.jar

java -jar cs-ci-0.0.1-SNAPSHOT.jar