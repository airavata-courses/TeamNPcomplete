#!/usr/bin/env python

#echo 'starting installation process' >> /var/log/sga-npcomplete-flask-install.log
cd '/home/ec2-user/ForecastDecision'
echo 'Activating virtualenv'
pip install virtualenv 
virtualenv venv >> /var/log/sga-npcomplete-flask-install.log
. venv/bin/activate >> /var/log/sga-npcomplete-flask-install.log
pip install Flask >> /var/log/sga-npcomplete-flask-install.log
#echo 'Running Flask Server' >> /var/log/sga-npcomplete-flask-install.log
export FLASK_APP=forecast_decision.py
flask run --host=0.0.0.0 --port=65000 >> /var/log/sga-npcomplete-flask.log 2>&1 &