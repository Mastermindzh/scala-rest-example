port = 9003

run:
	sbt run -Dhttp.port=$(port)

prod:
	sbt start -Dhttp.port=$(port)

test:
	sbt test

docker:
	docker-compose up
	
