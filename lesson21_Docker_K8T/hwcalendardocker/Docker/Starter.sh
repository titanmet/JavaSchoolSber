SPRING_CONFIG="-Dspring.config.location=classpath:/application.properties,optional:file:/deployments/config/override.yml,optional:file:/deployments/config/override.properties"
if [ "$RUN_DEBUG" == "true" ];
then
  DEBUG_CONFIG="-agentlib:jdwp=transport=dt_socket,server=y,suspend=n,address=8000"
fi

java  ${JVM_OPTION} ${DEBUG_CONFIG} -cp hwcalendardocker.jar ${SPRING_CONFIG} -Dloader.path=./ext/*,./lib/* org.springframework.boot.loader.PropertiesLauncher ${RUN_ARG}