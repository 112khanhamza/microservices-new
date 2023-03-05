# Spring Boot Microservice Project

[![Build Status](https://travis-ci.org/joemccann/dillinger.svg?branch=master)](https://travis-ci.org/joemccann/dillinger)

Following technologies have been used in this project.

- API Gateway
- Auth Server (Keycloak)
- Discovery Server (Netflix Eureka)
- Config Server
- Mongo Db (Store Products)
- MySQL (Store Order and Inventory)
- Zipkin (Distributed Logging)
- Resilience 4J (Circuit Breaker)
- Kafka (Async Communication)

## Installation

Install Mongo DB Binary files from https://www.mongodb.com/try/download/community.
Once done run these commands

```sh
cd <mongo-db-binary-folder>
mkdir data
cd data
mkdir db
# go into the bin folder of the mongo binary 
./mongod --dbpath <path to binary>/mongodb-macos-x86_64-4.4.18/data/db > <path to binary>/mongodb-macos-x86_64-4.4.18/logs/mongod.log 2>&1 &
# mongo server should be up and running
```
If you did not understand anything pls refer this video https://www.youtube.com/watch?v=p2EQUrA6SjU

Install MySQL Server and MySQL Workbench

We will run our Auth Server (KeyCloak) on a docker instanace so pls install docker desktop on your local machine.
