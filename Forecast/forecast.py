from flask import Flask, jsonify


app = Flask(__name__)

@app.route('/forecast/json')
def forecast():
  print __name__
  parsed_json = {'result':'forecast_ran'}
  # print parsed_json
  return jsonify(parsed_json)