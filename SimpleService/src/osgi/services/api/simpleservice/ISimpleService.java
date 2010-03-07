package osgi.services.api.simpleservice;

public interface ISimpleService {

	public String getNow();
	public int sum(int a, int b);
	public void fakeMethod(String a, int b, boolean c);
	public String getDate(java.util.Date date);
	//test type interop
	public SimpleClass generateSimpleClass();
	public void trasformSimpleClass(SimpleClass simple);
}
