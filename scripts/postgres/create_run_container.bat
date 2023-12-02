@REM create_run_container.bat

@REM build docker image
docker build -t compstore-postgres .

@REM run docker container
docker run --name compstore-postgres -p 5431:5432 -d compstore-postgres