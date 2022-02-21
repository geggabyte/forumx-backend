# Forumx

# How to run

After cloning project sertan variables must be: ```mailPassword=password; mailUserName=mail; privateMail=mail;```

Next step, executing ```mvnw.cmd clean package``` fow Windows or ```mvnw clean package``` for Linux in root folder, you build project

After building, copy ```jar``` file from ```target``` directory to ```src/main/docker/app.jar```

For starting compose:

```
docker-compose -p forumx up -d
```

For shutting it down:

```
docker-compose -p forumx down //shut down
```
And removing:
```
docker rmi forumx //remove forumx image
```

# Update in Docker

Rebuild updated program using ```mvnw```. Then build docker image

```
docker build -t forumx src/main/docker/
```

After success build start docker-compose again. It automatically update to newer version if it's being