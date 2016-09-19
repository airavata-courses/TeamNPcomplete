from flask import Flask
app = Flask(__name__)

@app.route('/')
def hello_world():
    print __name__
    return 'Abhi turns 26 in 2 weeks. He will be old'

hello_world()