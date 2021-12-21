#!/bin/bash
docker run -d --name elasticsearch-server -e "discovery.type=single-node" -p 9200:9200 -p 9300:9300 elasticsearch:7.16.1 ;
docker run -d --name zipkin-server -e STORAGE_TYPE=elasticsearch -e ES_HOSTS=192.168.0.101:9200 --restart always -p 9411:9411 openzipkin/zipkin

# docker run -d --name test-zipkin --restart always -p 9411:9411 openzipkin/zipkin

#docker run -d --name elasticsearch-server --network my-net -e "discovery.type=single-node" -p 9200:9200 -p 9300:9300 elasticsearch:7.16.1 ;
#docker run -d --name --network my-net -e STORAGE_TYPE=elasticsearch -e ES_HOSTS=localhost:9300 --restart always -p 9411:9411 openzipkin/zipkin

