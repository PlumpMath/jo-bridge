package osgi.services.impl.simpleserviceimpl;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;

import osgi.services.api.simpleservice.ISimpleService;

public class Activator implements BundleActivator {

	private ServiceRegistration reg;
	/*
	 * (non-Javadoc)
	 * @see org.osgi.framework.BundleActivator#start(org.osgi.framework.BundleContext)
	 */
	public void start(BundleContext context) throws Exception {
		ISimpleService service=new SimpleServiceImpl();
		reg=context.registerService(ISimpleService.class.getName(), service, null);
		System.out.println("Class name:"+ISimpleService.class.getName());
	}

	/*
	 * (non-Javadoc)
	 * @see org.osgi.framework.BundleActivator#stop(org.osgi.framework.BundleContext)
	 */
	public void stop(BundleContext context) throws Exception {
		if(reg!=null)
		{
			reg.unregister();
			System.out.println("ISimpleService UNREGISTERED!");
		}
	}

}
