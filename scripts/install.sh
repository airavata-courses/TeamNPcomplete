echo 'Installing SG_MICROSERVICE_STORMDETECTOR' >> /var/log/tomcat.log
cd '/home/ec2-user/SG_MICROSERVICE_STORMDETECTOR'
mvn -e clean install
mv target/*.war /usr/local/tomcat7/apache-tomcat-7.0.72/webapps/
echo 'Installing SG_MICROSERVICE_STORMDETECTOR' >> /var/log/tomcat.log
cd '/home/ec2-user/SG_MICROSERVICE_DATAINGESTOR'
pwd >> /var/log/tomcat.log
mvn -e clean install >> /var/log/tomcat.log
mv target/*.war /usr/local/tomcat7/apache-tomcat-7.0.72/webapps/
cd  /usr/local/tomcat7/apache-tomcat-7.0.72
sudo sh ./bin/startup.sh >> /var/log/tomcat.log 2>&1 &
