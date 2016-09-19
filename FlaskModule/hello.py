from flask import Flask, jsonify


app = Flask(__name__)

@app.route('/forecast_trigger/json')
def forecast_trigger():
  print __name__
  parsed_json = {'result':'yes'}
  # print parsed_json
  return jsonify(parsed_json)


# if __name__ == '__main__':
#   app.run(
#       host="127.0.0.1",
#       port=int(5000),
#   )