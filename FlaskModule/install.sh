cd '/home/ec2-user/SGA_NPComplete_application/FlaskModule'
echo 'Activating virtualenv'
pip install virtualenv
virtualenv venv
. venv/bin/activate
pip install nose
pip install Flask
echo 'Running Flask Server'
export FASK_APP=hello.py
flask run 2>&1 &