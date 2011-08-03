package osgi.services.impl.groovybridge;

import java.io.IOException;

import osgi.services.api.iscriptbridge.IScriptBridge;
import groovy.util.GroovyScriptEngine;
import groovy.util.ResourceException;
import groovy.util.ScriptException;
import groovy.lang.Binding;

public class GroovyBridgeImpl implements IScriptBridge {

	private String[] roots;
	private GroovyScriptEngine gse;
	Binding binds;
	
	public GroovyBridgeImpl(String[] roots) throws IOException {
		super();
		this.roots = roots;
		this.binds=new Binding();
		gse=new GroovyScriptEngine(this.roots);
	}

	@Override
	public void addVariableToContext(String objName, Object varToAdd) {
		binds.setVariable(objName, varToAdd);
	}

	@Override
	public Object exec_script_statement(String scriptToExecute,
			String objectResult) {
		Exception err=null;
			try {
				if(binds!=null){
					gse.run(scriptToExecute, binds);
				}else
					gse.run(scriptToExecute, "");				
			} catch (ResourceException e) {
				err=e;
				e.printStackTrace();
			} catch (ScriptException e) {
				err=e;
				e.printStackTrace();
			}
		
		if(err!=null)
			return err.getMessage();
		else
			return binds.getVariable(objectResult);
	}

	@Override
	public void exec_script_statement(String scriptToExecute) {
		//HACK: groovy engine accepts only FILES...
		System.err.println("Operation not yet implemented...");
	}

	@Override
	public void execute_script(String fileName) {
		try {
			if(binds!=null){
				gse.run(fileName, binds);
			}else
				gse.run(fileName, "");				
		} catch (ResourceException e) {
			e.printStackTrace();
		} catch (ScriptException e) {
			e.printStackTrace();
		}
	}

	@Override
	public Object getInterpreter() {
		return gse;
	}

}
