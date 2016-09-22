cd '/home/ec2-user/SGA_NPComplete_application/ForecastDecision'
echo 'Activating virtualenv'
pip install virtualenv
virtualenv venv
. venv/bin/activate
pip install Flask
echo 'Running Flask Server'
export FLASK_APP=forecast_decision.py
flask run --port=65000 2>&1 &
sleep 60