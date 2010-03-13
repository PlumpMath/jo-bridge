import sys

# Example of using OSGi service objects - direct loading from script
# HACK: it seems that jython doesn't access to OSGi framework classpath directly...
sys.path.append(r'./plugins/osgi.services.api.simpleservice_1.0.0.201003012105.jar')
try:
	from osgi.services.api.simpleservice import SimpleClass
except Exception, err:
	print "Error on loading JAR!"

# print bundles list
print "########################"
print "Test context available!"
print "########################"
print
l=context.getBundles()
print l
print l[1].getLocation()
print
# test simple service by python
print "#####################"
print "Test simple service!"
print "#####################"
print 
sref=context.getServiceReference("osgi.services.api.simpleservice.ISimpleService")
if(sref==None):
	print "ISimpleService not found!"
else:
	service=context.getService(sref)
	if(service!=None):
		try:
			print ".getNow test:"+str(service.getNow())			
			print ".sum test:"+str(service.sum(2,4))
			print ".fakeMethod test:" + str(service.fakeMethod('A', 10, True))
			print			
			print "###########"
			print "Test TYPES!"
			print "###########"
			print
			# test import service
			simple=service.generateSimpleClass()
			print "SIMPLE:"+str(simple)
			# populate data set
			array=[str(i) for i in range(10)]
			print "Adding array:"#+str(array)
			simple.setDataSet(array)
			print simple
			service.trasformSimpleClass(simple)
			print "SIMPLE Transformed:"+str(simple)
			print
			print ">>>>>>>>> TEST COMPLETED: SUCCESS!! <<<<<<<<<<<<"
		except Exception,err:
			print "Error on using service:"+str(err)
