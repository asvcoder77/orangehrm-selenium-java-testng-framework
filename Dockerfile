FROM bellsoft/liberica-openjre-alpine:21.0.10-cds

#workspace
WORKDIR /home/orange-asv-docker

#Add the required files
ADD target/orange-docker-resources ./

#Run the tests
