echo 'killing existing flask process if any' >> /var/log/flask-before-install.log
ps -ef | grep python | grep -v grep | awk '{print $2}' | xargs kill >> /var/log/flask-before-install.log
sleep 5
