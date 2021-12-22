#!/bin/bash
nohup java -jar target/config-server-1.0.0.jar --spring.profiles.active=config-server8887 -> ./logs/config-server8887.log &
nohup java -jar target/config-server-1.0.0.jar --spring.profiles.active=config-server8888 -> ./logs/config-server8888.log &
nohup java -jar target/config-server-1.0.0.jar --spring.profiles.active=config-server8889 -> ./logs/config-server8889.log &