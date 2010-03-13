import sys
import datetime
from datetime import datetime

# Example of using OSGi service objects - direct loading from script
# HACK: it seems that jython doesn't access to OSGi framework classpath directly...
sys.path.append(r'./plugins/osgi.services.api.simpleservice_1.0.0.201003012105.jar')
try:
	from osgi.services.api.simpleservice import SimpleClass, ISimpleService
except Exception, err:
	print "Error on loading JAR!"

# api implementation
class JySimpleService(ISimpleService):
	def __init__(self):
		print "called JySimpleService ctor"
	
	def getNow(self):
		return str(datetime.now())

	def sum(self,a,b):
		return a+b
	
	def fakeMethod(self, a, b, c):
		print "JySimpleService.fakeMethod : "+str(a) +","+ str(b) +","+ str(c)
	
	def getDate(self,date):
		print "JySimpleService.getDate"
		return str(date)

	def generateSimpleClass(self):
		result=SimpleClass()
		return result

	def trasformSimpleClass(self,simple):
		simple.setName("JySimpleService modified at:"+str(datetime.now()))
