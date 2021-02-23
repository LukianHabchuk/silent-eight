FROM adoptopenjdk:11-jre-hotspot
ADD build/libs/*.jar silent-eight-homework.jar
COPY genderNames/male.txt genderNames/male.txt
COPY genderNames/female.txt genderNames/female.txt
EXPOSE 8081
ENTRYPOINT ["java", "-jar", "silent-eight-homework.jar"]