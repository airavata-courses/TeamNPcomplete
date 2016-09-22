cd '/home/ec2-user/SGA_NPComplete_application/ForecastDecision' >> /var/log/sga-npcomplete-flask-install.log
echo 'Activating virtualenv'
pip install virtualenv >> /var/log/sga-npcomplete-flask-install.log
virtualenv venv >> /var/log/sga-npcomplete-flask-install.log
. venv/bin/activate >> /var/log/sga-npcomplete-flask-install.log
pip install Flask >> /var/log/sga-npcomplete-flask-install.log
echo 'Running Flask Server'
export FLASK_APP=forecast_decision.py
flask run --host=0.0.0.0 --port=65000 >> /var/log/sga-npcomplete-flask.log 2>&1 &