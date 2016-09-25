echo 'Installing Science_Gateway_Apex to Maven'
cd '/home/ec2-user/SG_MICROSERVICE_STORMDETECTOR'
mvn -e clean install
echo 'Installing SG_MICROSERVICE_STORMDETECTOR'
cd '/home/ec2-user/SG_MICROSERVICE_STORMDETECTOR'
mvn -e clean install
mv target/*.war /usr/local/tomcat7/apache-tomcat-7.0.72/webapps/
cd /usr/local/tomcat7/apache-tomcat-7.0.72
./bin/startup.sh
sleep 60
