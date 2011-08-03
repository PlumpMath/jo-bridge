package osgi.services.impl.groovybridge;

import java.util.Dictionary;
import java.util.Hashtable;

import org.eclipse.osgi.framework.console.CommandProvider;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;

import osgi.services.api.iscriptbridge.IScriptBridge;

public class Activator implements BundleActivator {

	ServiceRegistration reg;
	ServiceRegistration cmdReg;
	
	/*
	 * (non-Javadoc)
	 * @see org.osgi.framework.BundleActivator#start(org.osgi.framework.BundleContext)
	 */
	public void start(BundleContext context) throws Exception {
		//TODO: configuration!!!
		String[] roots=new String[]{".","./scripts","/home/dario/Sviluppi/python/jo-bridge/jo-bridge_test_scripts"};
		IScriptBridge sb=new GroovyBridgeImpl(roots);
		sb.addVariableToContext("context", context);
		Dictionary<String, String> properties=new Hashtable<String, String>();
		properties.put("language","groovy");
		reg=context.registerService(IScriptBridge.class.getName(), sb, properties);
		cmdReg = context.registerService(CommandProvider.class.getName(), new CommandManager(sb), null);
	}

	/*
	 * (non-Javadoc)
	 * @see org.osgi.framework.BundleActivator#stop(org.osgi.framework.BundleContext)
	 */
	public void stop(BundleContext context) throws Exception {
		if(reg!=null) reg.unregister();
		if(cmdReg!=null) cmdReg.unregister();
	}

}
