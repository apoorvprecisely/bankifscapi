web: target/universal/stage/bin/bankapi -Dhttp.port=${PORT} -Dplay.evolutions.db.default.autoApply=true -Ddb.default.driver=org.postgresql.Driver -Ddb.default.url=${DATABASE_URL}
web: bundle exec thin start -p $PORT
