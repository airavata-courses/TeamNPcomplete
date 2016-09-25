echo 'Installing SG_MICROSERVICE_STORMDETECTOR'
cd '/home/ec2-user/SG_MICROSERVICE_STORMDETECTOR'
mvn -e clean install
mv target/*.war /usr/local/tomcat7/apache-tomcat-7.0.72/webapps/


cd '/home/ec2-user/SG_MICROSERVICE_DATAINGESTOR'
mvn -e clean install
mv target/*.war /usr/local/tomcat7/apache-tomcat-7.0.72/webapps/
cd  /usr/local/tomcat7/apache-tomcat-7.0.72 >> /var/log/tomcat.log
sudo sh ./bin/startup.sh >> /var/log/tomcat.log 2>&1 &
