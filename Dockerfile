FROM adoptopenjdk:11-jre-hotspot
ADD build/libs/*.jar silent-eight-homework.jar
EXPOSE 8081
ENTRYPOINT ["java", "-jar", "silent-eight-homework.jar"]