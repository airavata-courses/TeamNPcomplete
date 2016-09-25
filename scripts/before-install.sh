echo 'killing existing flask process if any'
ps -ef | grep python | grep -v grep | awk '{print $2}' | xargs kill >> /var/log/python-kill.log
sleep 20
