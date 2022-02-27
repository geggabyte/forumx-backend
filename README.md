# Forumx

## How to run

There is two ways to start this app:

- Start it in docker
- Start it in IntelliJIdea

For both of them you need to clone project

## IntelliJIdea app

For this method you need install and set up PostgresSQL.

After installation:

1. Create user and database called `forumx`, set user password `forumx`.
2. Open cloned repository as folder.
3. Set up environment
   variables `mailUserName=sample.mail@gmail.com; mailPassword=password; privateMail=private@gmail.com`
4. Hit beautiful green button.
5. Open [webpage](http://localhost:8080)
6. Enjoy

## Docker app

If you want to run app in docker follow nex steps:

1. Execute in root
   folder `mvnw -DmailUserName=agentMail -DmailPassword=password -DprivateMail=privateMail clean package`
2. Copy `jar` file from `target` directory to `src/main/docker/app.jar`
3. Change `mailPassword, mailUserName privateMail` to your own in `.env` file
4. Now you can run docker compose

- For starting/update docker:`docker-compose -p forumx up -d`
- For shutting it down:`docker-compose -p forumx down`
- For removing: `docker rmi forumx` (removes forumx image)

### Update in Docker

If you want update forumx in docker follow those steps:

1. Repeat steps 1 and 2 from init running
2. Build new docker image: `docker build -t forumx src/main/docker/`
3. Run `docker-compose -p forumx up -d` as shown earlier
4. Wait till it updates, if updates exists
5. Enjoy

### Dozzle

I've set up Dozzle as logs viewer in docker. It's available at [webpage](http://localhost:9999) when docker container is
up and running