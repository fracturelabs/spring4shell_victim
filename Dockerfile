#
# Build WAR with Maven
#
FROM maven:3.8.4-openjdk-11 as build

WORKDIR /app

ADD ./pom.xml .
RUN ["/usr/local/bin/mvn-entrypoint.sh", "mvn", "verify", "clean", "--fail-never"]

ADD ./src ./src

# Build WAR
RUN mvn package

#
# Run Tomcat with vulnerable WAR
#
FROM tomcat:9.0

COPY --from=build /app/target/*.war /usr/local/tomcat/webapps/

