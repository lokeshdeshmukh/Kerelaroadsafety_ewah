import sys
import time
import RPi.GPIO as GPIO
import urllib2
import urllib

def getserial():
  # Extract serial from cpuinfo file
  cpuserial = "0000000000000000"
  try:
    f = open('/proc/cpuinfo','r')
    for line in f:
      if line[0:6]=='Serial':
        cpuserial = line[10:26]
    f.close()
  except:
    cpuserial = "ERROR000000000"
 
  return cpuserial

GPIO.setmode(GPIO.BCM)
GPIO.setup(05,GPIO.OUT)

data = []

GPIO.output(05,GPIO.HIGH)
time.sleep(0.0025)
GPIO.output(05,GPIO.LOW)
time.sleep(0.050)

for i in range(0,500):
	data.append(GPIO.input(05))

for j in range(0,len(data)):
	bits = data[i]
while 1:
  if bits != 0:

	query_args={'RPI':'Active'}

	url='http://www.cchat.in/hack/addalcohol.php?level='+str(1)+'&id='+getserial()
	data=urllib.urlencode(query_args)

	request=urllib2.Request(url,data);
	response=urllib2.urlopen(request).read()
	print response

	print "The number of alcohol bits are :"+ str(bits)

GPIO.cleanup()