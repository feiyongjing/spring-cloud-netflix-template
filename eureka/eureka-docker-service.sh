#!/bin/bash
nohup java -jar target/eureka-1.0.0.jar --spring.profiles.active=eureka8762 -> ./logs/eureka8762.log &
nohup java -jar target/eureka-1.0.0.jar --spring.profiles.active=eureka8763 -> ./logs/eureka8763.log &
nohup java -jar target/eureka-1.0.0.jar --spring.profiles.active=eureka8764 -> ./logs/eureka8764.log &