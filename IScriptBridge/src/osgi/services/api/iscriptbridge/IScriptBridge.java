package osgi.services.api.iscriptbridge;

public interface IScriptBridge {

	public void execute_script(String fileName);
	public Object exec_script_statement(String scriptToExecute, String objectResult);
	public void exec_script_statement(String scriptToExecute);
	public Object getInterpreter();
	public void addVariableToContext(String objName,Object varToAdd);
}
