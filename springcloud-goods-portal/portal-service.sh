#!/bin/bash
nohup java -jar target/portal-1.0.0.jar --spring.profiles.active=portal8083 -> ./logs/portal8083.log &
nohup java -jar target/portal-1.0.0.jar --spring.profiles.active=portal8084 -> ./logs/portal8084.log &