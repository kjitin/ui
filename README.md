# ui
The project can be built using mvn clean package from the root of the project

The Angular files are present but it is not integrated with the services

As there are three microservices and one registry server, please run the following in separate command windows

1. java -jar target/microservice-0.0.1-SNAPSHOT.jar registration
2. java -jar target/microservice-0.0.1-SNAPSHOT.jar location
3. java -jar target/microservice-0.0.1-SNAPSHOT.jar catalog
4. java -jar target/microservice-0.0.1-SNAPSHOT.jar web

This will bring up all the services and will get registered with the registry server.
The services registered can be viewed at http://localhost:1111

