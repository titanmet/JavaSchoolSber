ARG registryUrl
ARG rhelOpenJdkUrl
FROM ${registryUrl}${rhelOpenJdkUrl}

ARG version=DEV-SNAPSHOT

COPY ./calendar-$version.jar /usr/app/calendar.jar
COPY Starter.sh /usr/app/Starter.sh

WORKDIR /usr/app
USER root
ENV LANG en_US.UTF-8
ENV LANGUAGE en_US:en
ENV LC_ALL en_US.UTF-8

RUN chgrp -R 0 /usr/app/ && chmod -R g=u /usr/app/; \
    chmod +x /usr/app/Starter.sh; \
    su -c 'rm -f /etc/localtime && ln -s /usr/share/zoneinfo/Europe/Moskov /etc/localtime'
ENV RUN_DEBUG=false
EXPOSE 8080#
USER 0

CMD ./Starter.sh

---------------------------------------------------------------------------------------------

docker build ./ -t calendar-less:0.0.1-SNAPSHOT

docker build --build-arg registryUrl=downloads.redhat.com --build-arg rhelOpenJdkUrl=/redhat/containers/openjdk/openjdk-11-rhel7/1
.10-1.1630314161.txt ./ -t calendar-less:0.0.1-SNAPSHOT

----------------------------------------------------------------------------------------------

docker rmi -f (docker rmi -f 9dc2100a5aa7 9dc2100a5aa7 удалить образы )

docker run -p 8080:8080 calendar-less:0.0.1-SNAPSHOT
(-p 8080:8080 port host port docker)

docker ps  - все работающие контейнеры список
docker ps -a   - статусы плюсом покажет
docker rm -f 1d94....   - остановить выполнение images
docker rmi название - удалить images
docker push
docker pull
docker system prune -a - очистка системы

docker image build -t docker-calendarsimple-v1 .

docker run -p 8080:8080 docker-calendarsimple-v1:latest

json 
{"key":"String", key2: {}, key3: []}
yaml
key: "String"               ports:
                               - 8080:8080
                               - 8081:8081
                                          
примитив        объект      массив

docker-compose up