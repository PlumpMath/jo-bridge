import org.osgi.framework.BundleContext
import org.osgi.framework.ServiceReference

println "########################"
println "Test context available!"
println "########################"
l=context.getBundles()
println l
println l[1].getLocation()

println "#####################"
println "Test simple service!"
println "#####################"
println "" 

sref=context.getServiceReference("osgi.services.api.simpleservice.ISimpleService")
if(sref==null){
	println "ISimpleService not found!"
}
else{
	service=context.getService(sref)
	if(service!=null){
		println "ISimpleService acquired!"
		println service
		try{
			println ".getNow test:"+service.getNow()
			println ".sum test:"+service.sum(2,4)
			println ".fakeMethod test:" + service.fakeMethod('A', 10, true)
			println	""	
			println "###########"
			println "Test TYPES!"
			println "###########"
			println ""
			simple=service.generateSimpleClass()
			println "SIMPLE:"+simple.toString()
			array=["1","2","3","4"]
			println "Adding array"
			simple.setDataSet(array)
			println simple.toString()
			service.trasformSimpleClass(simple)
			println "SIMPLE Transformed:"+simple
			println ""
			println ">>>>>>>>> TEST COMPLETED: SUCCESS!! <<<<<<<<<<<<"
		}catch(Exception e){
			println e.getMessage()
		}
	}
}
