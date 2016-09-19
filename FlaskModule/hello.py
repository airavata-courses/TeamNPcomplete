from flask import Flask
app = Flask(__name__)

@app.route('/forecast_trigger')
def fore_cast_trigger():
    print __name__
    return 'Hello World'

# if __name__ == '__main__':
#   app.run(
#       host="127.0.0.1",
#       port=int(5000),
#   )