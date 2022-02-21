# Forumx

# How to run

First of all you need to build a project. Using ```.\mvnw.cmd clean package``` fow Windows or ```.\mvnw clean package``` for Linux in root folder

For creating compose:

```
docker compose -p forumx up
```

For shutting it down:

```
docker compose -p forumx down //shut down
docker rmi forumx //remove forumx image
```

# Update in Docker

In src\main\docker folder run commands:

```
docker build -t forumx .\src\main\docker\
docker compose -p forumx up -d
```

```
copy C:\Users\gegac\Documents\GitHub\ForumX\forumx-backend\target\*.jar C:\Users\gegac\Documents\GitHub\ForumX\forumx-backend\src\main\docker\app.jar
```