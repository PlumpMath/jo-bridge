# Files and architecture #

Jars files:

  * jython.jar: Jython 2.5.1 OSGi bundle
  * IScriptBridge\_1.0.0.201002281614.jar: OSGi bundle containing the jo-bridge API
  * JythonBridge\_1.0.0.201002281622.jar: core of jo-bridge, it is the implementation of IScriptBridge for Jython
  * osgi.services.api.simpleservice\_1.0.0.201002281614.jar: simple OSGi service API (for test)
  * osgi.services.impl.simpleserviceimpl\_1.0.0.201002281638.jar: simple OSGi service implementation (for test)

Jython scripts:

  * test.py: simple script to check Jython interpreter interop.
  * osgi.py: jython script that uses OSGi SimpleService

# How to test and use jo-bridge (EQUINOX ONLY) #

I think that the bundles work with all OSGi framework, but the command line statements are available only for Equinox.

  * Deploy jars on Equinox OSGi framework
  * start Equinox in console mode
  * install jars on Equinox using install statement

![http://jo-bridge.googlecode.com/files/installation_1.png](http://jo-bridge.googlecode.com/files/installation_1.png)

  * start bundles in this order: Jython, IScriptBridge, JythonBridge, SimpleService API and SimpleServiceImplementation
  * test jo-bridge calling : execute\_statement test.py, execute\_statement osgi.py

![http://jo-bridge.googlecode.com/files/commands_1.png](http://jo-bridge.googlecode.com/files/commands_1.png)

![http://jo-bridge.googlecode.com/files/test_py_1.png](http://jo-bridge.googlecode.com/files/test_py_1.png)

![http://jo-bridge.googlecode.com/files/osgi_py_1.png](http://jo-bridge.googlecode.com/files/osgi_py_1.png)