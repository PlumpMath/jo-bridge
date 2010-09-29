package osgi.services.impl.jythonbridge;

import org.python.util.PythonInterpreter;
//import org.python.core.*;

import osgi.services.api.iscriptbridge.IScriptBridge;

//Test comment - 29/09/10

public class JythonBridgeImpl implements IScriptBridge {

	private PythonInterpreter interpreter = new PythonInterpreter();
	
	@Override
	public void addVariableToContext(String objName,Object varToAdd) {
		interpreter.set(objName,varToAdd);
		//interpreter.
	}

	@Override
	public void execute_script(String fileName) {
		try
		{
			this.interpreter.execfile(fileName);			
		}
		catch(Exception err)
		{
			System.out.println("execute_script ERROR:"+
					err.getMessage());
			err.printStackTrace();
		}
	}
	
	public void exec_script_statement(String scriptToExecute)
	{
		try
		{
			this.interpreter.exec(scriptToExecute);			
		}
		catch(Exception err)
		{
			System.out.println("exec_script_statement ERROR:"+
					err.getMessage());
			err.printStackTrace();
		}
	}

	
	@Override
	public Object getInterpreter() {
		return interpreter;
	}

	@Override
	public Object exec_script_statement(String scriptToExecute,
			String objectResult) {
		exec_script_statement(scriptToExecute);
		return interpreter.get(objectResult);
	}
	
}
