package osgi.services.impl.jythonbridge;

import java.util.Hashtable;


import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.eclipse.osgi.framework.console.CommandInterpreter;
import org.eclipse.osgi.framework.console.CommandProvider;

import osgi.services.api.iscriptbridge.IScriptBridge;


public class Activator implements BundleActivator,CommandProvider {

	private IScriptBridge bridge=null;
	
	/*
	 * (non-Javadoc)
	 * @see org.osgi.framework.BundleActivator#start(org.osgi.framework.BundleContext)
	 */
	@SuppressWarnings("unchecked")
	public void start(BundleContext context) throws Exception {		
		context.registerService(CommandProvider.class.getName(), this, new Hashtable());
		//registro il servizio per esporre questi statement verso il mondo
		bridge=new JythonBridgeImpl();
		bridge.addVariableToContext("context", context);
		context.registerService(IScriptBridge.class.getName(), bridge, null);		
	}

	/*
	 * (non-Javadoc)
	 * @see org.osgi.framework.BundleActivator#stop(org.osgi.framework.BundleContext)
	 */
	public void stop(BundleContext context) throws Exception {
	}

	@Override
	public String getHelp() {
		StringBuffer buffer=new StringBuffer();
		buffer.append("---Jython service command---\r\n");
		buffer.append("\texecute_script [fileName] - execute a Python script\r\n");
		buffer.append("\texecute_statement [pythonStatement] - execute a Python statement\r\n");
		return buffer.toString();
	}
	
	public void _execute_script(CommandInterpreter ci)
	{
		try
		{						
			String nextArg=ci.nextArgument();
			if(nextArg==null || nextArg.isEmpty())
				//System.out.println("Syntax not valid - Insert BUNDLE ID");
				ci.println("Syntax not valid - Insert valid filename!");
			else
				//System.out.println(this.manager.info_tkdata_service(Integer.parseInt(nextArg)));
				this.bridge.execute_script(nextArg);
		}
		catch(Exception err)
		{
			//System.out.println("Error: " + err.getMessage());
			ci.println("Error: " + err.getMessage());
			err.printStackTrace();
		}
	}

	public void _execute_statement(CommandInterpreter ci)
	{
		try
		{						
			String nextArg=ci.nextArgument();
			if(nextArg==null || nextArg.isEmpty())
				//System.out.println("Syntax not valid - Insert BUNDLE ID");
				ci.println("Syntax not valid - Insert valid statement!");
			else
			{
				//this.bridge.exec_script_statement(nextArg);
				Object result=this.bridge.exec_script_statement(nextArg, "_");
				System.out.println("Result of execution:"+result);
			}
				
		}
		catch(Exception err)
		{
			//System.out.println("Error: " + err.getMessage());
			ci.println("Error: " + err.getMessage());
			err.printStackTrace();
		}
	}

}
