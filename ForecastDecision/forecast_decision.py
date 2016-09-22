from flask import Flask, jsonify, request
import httplib
import ast, random

app = Flask(__name__)

@app.route('/forecast_decision/json', methods=['POST'])
def forecast_decision():
  response_json = {}
  random_no = int(random.uniform(0, 100))

  if(request.method=='POST'):
  	for param in request.form:
  		print "%s %s"%(request.form, request.form[param])

  if(random_no%2==0):
	  parsed_json = {'result':'yes'}
	  connection = httplib.HTTPConnection("127.0.0.1:5000");
	  connection.request("GET", "/forecast/json")
	  result = connection.getresponse()
	  response_json = ast.literal_eval(result.read())
	 	
	  return jsonify(response_json)
  else:
	  return jsonify({'result':'no'})


# if __name__ == '__main__':
#   app.run(
#       host="127.0.0.1",
#       port=int(5000),
#   )