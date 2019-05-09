FROM adoptopenjdk/openjdk12:latest

VOLUME /tmp
ADD target/backend-1.0-SNAPSHOT.jar backend.jar
ENV JAVE_OPTS=""
RUN bash -c 'touch /backend.jar'
ENTRYPOINT ["java","-Djasecurity.egd=file:/dev/./urandom","-jar","/backend.jar"]