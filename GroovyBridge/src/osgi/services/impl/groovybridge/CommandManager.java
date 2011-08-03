package osgi.services.impl.groovybridge;

import org.eclipse.osgi.framework.console.CommandInterpreter;
import org.eclipse.osgi.framework.console.CommandProvider;

import osgi.services.api.iscriptbridge.IScriptBridge;

public class CommandManager implements CommandProvider {

	IScriptBridge groovyBridge;
	
	public CommandManager(IScriptBridge groovyBridge) {
		super();
		this.groovyBridge = groovyBridge;
	}

	@Override
	public String getHelp() {
		StringBuffer buffer=new StringBuffer();
		buffer.append("---Groovy service command---\r\n");
		buffer.append("\texecute_groovy_script [fileName] - execute a Python script\r\n");
		return buffer.toString();
	}
	
	public void _execute_groovy_script(CommandInterpreter ci){
		try{						
			String nextArg=ci.nextArgument();
			if(nextArg==null || nextArg.isEmpty())
				//System.out.println("Syntax not valid - Insert BUNDLE ID");
				ci.println("Syntax not valid - Insert valid filename!");
			else
				//System.out.println(this.manager.info_tkdata_service(Integer.parseInt(nextArg)));
				this.groovyBridge.execute_script(nextArg);
		}
		catch(Exception err){
			//System.out.println("Error: " + err.getMessage());
			ci.println("Error: " + err.getMessage());
			err.printStackTrace();
		}
	}
}
