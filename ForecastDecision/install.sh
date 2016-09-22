cd '/home/ec2-user/SGA_NPComplete_application/ForecastDecision'
echo 'Activating virtualenv'
pip install virtualenv
virtualenv venv
. venv/bin/activate
pip install Flask
echo 'Running Flask Server'
export FLASK_APP=forecast_decision.py
flask run --host=0.0.0.0 --port=65000 >> /var/log/sga-npcomplete-flask.log 2>&1 &
sleep 60