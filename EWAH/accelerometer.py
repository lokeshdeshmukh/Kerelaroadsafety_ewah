#!/usr/bin/python
 
import smbus
import math
from time import sleep
import os
import threading
import bluetooth
import MySQLdb
import urllib2
import urllib
 
# Power management registers
power_mgmt_1 = 0x6b
power_mgmt_2 = 0x6c
 
def read_byte(adr):
    return bus.read_byte_data(address, adr)
 
def read_word(adr):
    high = bus.read_byte_data(address, adr)
    low = bus.read_byte_data(address, adr+1)
    val = (high << 8) + low
    return val
 
def read_word_2c(adr):
    val = read_word(adr)
    if (val >= 0x8000):
        return -((65535 - val) + 1)
    else:
        return val
 
def dist(a,b):
    return math.sqrt((a*a)+(b*b))
 
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



 
bus = smbus.SMBus(1) # or bus = smbus.SMBus(1) for Revision 2 boards
address = 0x68       # This is the address value read via the i2cdetect command
 
# Now wake the 6050 up as it starts in sleep mode
bus.write_byte_data(address, power_mgmt_1, 0)
 
while 1:
        print
        print "accelerometer data"
        print "------------------"
 
        accel_xout = read_word_2c(0x3b)
        accel_yout = read_word_2c(0x3d)
        accel_zout = read_word_2c(0x3f)
 
        accel_xout_scaled = accel_xout / 16384.0
        accel_yout_scaled = accel_yout / 16384.0
        accel_zout_scaled = accel_zout / 16384.0
 
        if accel_yout_scaled>0.7 :
         

         query_args={'RPI':'Active'}
         url='http://www.cchat.in/hack/addaccelerometer.php?level=1&id='+getserial();
         data=urllib.urlencode(query_args)
         request=urllib2.Request(url,data);
         response=urllib2.urlopen(request).read()
         print response
	 print "Accident!!!"
        
        if accel_yout_scaled<-0.7 :
         query_args={'RPI':'Active'}
         url='http://www.cchat.in/hack/addaccelerometer.php?level=1&id='+getserial();
         data=urllib.urlencode(query_args)
         request=urllib2.Request(url,data);
         response=urllib2.urlopen(request).read()
         print response
	 print "Accident!!!"
        

        print "accel_xout: ", accel_xout, " scaled: ", accel_xout_scaled
        print "accel_yout: ", accel_yout, " scaled: ", accel_yout_scaled
        print "accel_zout: ", accel_zout, " scaled: ", accel_zout_scaled
        
        sleep(1)