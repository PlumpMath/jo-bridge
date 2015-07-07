## News ##

- 03 August 2011: Added bridge implementation for Groovy in jo-bridge trunk

- September 2010: Added ant support for Hudson integration

## Goal ##

This project provides a set of OSGi bundles to use the Jython interpreter within a OSGi framework.

The main goal that the project aims is the complete interoperability between OSGi and Python.

Another goal is to provide a simple OSGi architecture to embedd any Java based interpreter  in a complex OSGi framework.

## Architecture ##

The following image shows the current jo-bridge architecture:

![http://jo-bridge.googlecode.com/files/jo-bridge-architecture_2.png](http://jo-bridge.googlecode.com/files/jo-bridge-architecture_2.png)

The roles of modules are:

  * IScriptBridge: Interface for (potentially) any java-based interpreter,it is the layer between OSGi platform and the interpreter component; OSGi service and framework know only this interface, and have not direct link with interpreter;
  * JythonBridge: Implementation of IScriptBridge interface for Jython, It directly knows the details about the Jython interpreter, and It implements the real OSGi service Object;
  * Jython interpreter version 2.5.1 (wrapped in OSGi bundle with bnd utility)
  * GroovyBridge **(new)**: Implementation of IScriptBridge interface for Groovy, it directly knows the details about Groovy engine, and it implements the real OSGi service object;
  * Groovy embeddable engine version 1.8.1 **(new)**