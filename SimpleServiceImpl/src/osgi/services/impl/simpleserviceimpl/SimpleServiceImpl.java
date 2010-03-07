package osgi.services.impl.simpleserviceimpl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import osgi.services.api.simpleservice.ISimpleService;
import osgi.services.api.simpleservice.SimpleClass;

public class SimpleServiceImpl implements ISimpleService {

	@Override
	public void fakeMethod(String a, int b, boolean c) {
		System.out.println(a +" " + b +" " +c);
	}

	@Override
	public String getNow() {
		Date date= new Date();
		return date.toString();		
	}

	@Override
	public int sum(int a, int b) {
		return a+b;
	}

	@Override
	public String getDate(Date date) {
		return "Given date = " + date.toString();
	}

	@Override
	public SimpleClass generateSimpleClass() {
		SimpleClass result=new SimpleClass();
		result.setName("simple class");
		result.setReady(true);
		List<String> data=new ArrayList<String>();
		for (int i=0;i<10;i++)
			data.add("str"+i);
		return result;
	}

	@Override
	public void trasformSimpleClass(SimpleClass simple) {
		if(simple!=null)
		{
			simple.setReady(false);
			simple.setName(this.getNow().toString());
			simple.setDataSet(new ArrayList<String>());
		}
		
		
	}
}
