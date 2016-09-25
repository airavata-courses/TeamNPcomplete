echo 'Installing SG_MICROSERVICE_STORMDETECTOR' >> /var/log/tomcat.log
cd '/home/ec2-user/SG_MICROSERVICE_STORMDETECTOR'
mvn -e clean install >> /var/log/tomcat.log
mv target/*.war /usr/local/tomcat7/apache-tomcat-7.0.72/webapps/
echo 'Installing SG_MICROSERVICE_DATAINGESTOR' >> /var/log/tomcat.log
cd '/home/ec2-user/SG_MICROSERVICE_DATAINGESTOR'
mvn -e clean install >> /var/log/tomcat.log
cp target/*.war /usr/local/tomcat7/apache-tomcat-7.0.72/webapps/ >> /var/log/tomcat.log
cd  /usr/local/tomcat7/apache-tomcat-7.0.72
echo 'Installing SG_MICROSERVICE_STROMCLUSTERING' >> /var/log/tomcat.log
cd '/home/ec2-user/SG_MICROSERVICE_STROMCLUSTERING'
mvn -e clean install >> /var/log/tomcat.log
cp target/*.war /usr/local/tomcat7/apache-tomcat-7.0.72/webapps/ >> /var/log/tomcat.log
cd  /usr/local/tomcat7/apache-tomcat-7.0.72

sudo sh ./bin/startup.sh >> /var/log/tomcat.log 2>&1 &
