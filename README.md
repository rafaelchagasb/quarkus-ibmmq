# Send message for queue IBM MQ using Quarkus and JMS

## Run IBM MQ local using Docker

```shell
docker volume rm qm1data
docker volume create qm1data
docker run --env LICENSE=accept --env MQ_QMGR_NAME=QM1 --volume qm1data:/mnt/mqm --publish 1414:1414 --publish 9443:9443 --detach --env MQ_APP_PASSWORD=passw0rd ibmcom/mq:latest
```

## IBM Console Administration

https://localhost:9443/ibmmq/console/#/

user: admin

password: passw0rd

## Send message

### Run unit test

```shell
mvn test
```

### Run the application

```shell
## compile and open your browser: http://localhost:8080/message/{your_message}
mvn compile quarkus:dev
```
