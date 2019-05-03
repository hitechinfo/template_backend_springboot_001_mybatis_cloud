FROM java:11
 
VOLUME /tmp 
ADD target/cont-0.0.1-SNAPSHOT.jar app.jar
ENV JAVE_OPTS=""
RUN bash -c 'touch /app.jar'
ENTRYPOINT ["java","-Djasecurity.egd=file:/dev/./urandom","-jar","/app.jar"]
