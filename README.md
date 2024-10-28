For this project to work you need 
**Java 17** and **Docker** be installed on your machine 
you also need a **docker bridge nework** named "my-network".

go to the project's dorectory and run the following command:
1) gradle clean build
2) docker build -t challenge:latest .
3) docker-compose up -d

Now the app is running on port 8080 accessible on http://localhost:8080/challenge
you can also access the database on http://localhost:8090

to connect to the DB:
Server: database
UserName: ehsan
Pasword: ehsan
Database: eventdb

next you can use postman to upload two json file on "http://localhost:8080/challenge/event/upload" POST verb

the files are processed and saved in the DB you can check it (tables: impression, click)

********This application needs some improvement regarding bulk insertion and validation.******
