FROM java:3.6.1-jdk-8-alpine

VOLUME /tmp
ADD target/backend-1.0-SNAPSHOT.jar backend.jar
ENV JAVE_OPTS=""
RUN bash -c 'touch /backend.jar'
ENTRYPOINT ["java","-Djasecurity.egd=file:/dev/./urandom","-jar","/backend.jar"]