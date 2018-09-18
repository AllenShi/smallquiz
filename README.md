# Demo Project for Small Quit

## Pre-requisition

### Install MongoDB on MacOS

Refer to [Install MongoDB Community Edition on macOS](https://docs.mongodb.com/manual/tutorial/install-mongodb-on-os-x/)

#### 1. Laydown binary

~~~
cd Downloads
wget https://www.mongodb.com/dr/fastdl.mongodb.org/osx/mongodb-osx-ssl-x86_64-4.0.2.tgz/download
tar -zxvf mongodb-osx-ssl-x86_64-4.0.2.tgz
cp -r mongodb-osx-x86_64-4.0.2 /Applications/
~~~

#### 2. Edit PATH

~~~
vi ~/.bashrc 
~~~

> export PATH=/Applications/mongodb-osx-x86_64-4.0.2/bin:$PATH

~~~
source ~/.bashrc
~~~

### Run MongoDB

#### 1. Create data directory

~~~
sudo mkdir -p /var/lib/mongo/data/db
~~~

#### 2. Set Permission (Optional)

~~~
sudo mkdir -p /var/lib/mongo/data
~~~

#### 3. Start MongoDB

~~~
mongod --dbpath /var/lib/mongo/data/db
~~~

#### 4. Connect from client

~~~
mongo --host 127.0.0.1:27017
~~~

## MongoDB Preparation

### Create DB and Collection using Mongo Shell

~~~
mongo --host 127.0.0.1:27017
~~~

~~~
show dbs
~~~

> admin   0.000GB  
> config  0.000GB  
> local   0.000GB  
> test    0.000GB  

~~~
use quizdb

db.question.insert({"_id": 100, "passageid": 100, "stem": "stem0", "order": 0, "analysis": "Farmer0", "rightAnswer": "B"})  
~~~

> WriteResult({ "nInserted" : 1 })TORAGE  [conn2] createCollection: quizdb.question with generated UUID: d93614ac-65b5-4e59-a141-a0e426e8d53c

~~~
db.question.insert({"_id": 101, "passageid": 101, "stem": "stem1", "order": 1, "analysis": "Farmer1", "rightAnswer": "B"})  
~~~

> WriteResult({ "nInserted" : 1 })

~~~
db
~~~

> quizdb

~~~
db.question.find()
~~~

> { "_id" : 100, "passageid" : 100, "stem" : "stem0", "order" : 0, "analysis" : "Farmer0", "rightAnswer" : "B" }
> { "_id" : 101, "passageid" : 101, "stem" : "stem1", "order" : 1, "analysis" : "Farmer1", "rightAnswer" : "B" }

~~~
show dbs
~~~

> admin   0.000GB  
> config  0.000GB  
> local   0.000GB  
> quizdb  0.000GB  
> test    0.000GB  

### Install Redis on MacOS

[Reference](https://gist.github.com/tomysmile/1b8a321e7c58499ef9f9441b2faa0aa8)

#### Laydown Redis
~~~
brew update
sudo chown -R $(whoami) /usr/local/share/zsh /usr/local/share/zsh/site-functions
brew install redis
~~~

#### Start Redis service
~~~
brew services start redis
~~~

Alternatively  

~~~
redis-server /usr/local/etc/redis.conf
~~~

#### Access from redis-cli
~~~
redis-cli
~~~

## Run Application

### Configure DB

~~~
vi src/main/resources/application.properties
~~~

> spring.data.mongodb.uri=mongodb://localhost:27017/quizdb

### Start Application

* Start using CLI

~~~
cd smallquiz
./gradlew bootRun
~~~

* Start from Eclipse

~~~
Run As -> Run Configurations -> Gradle Project

Gradle Tasks: bootRun
Working Directory: Select from Workspace
~~~

### Run Test

#### Run unit test

> Run test using default profile for MonogoDB

~~~
./gradlew test
~~~

> Run test using JPA profile

~~~
./gradlew test -Dspring.profiles.active=JPA
~~~

> Run test using Redis profile

~~~
./gradlew test -Dspring.profiles.active=Redis
~~~

#### Run Open API

~~~
http://localhost:8080/swagger-ui.html
~~~
