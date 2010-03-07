package osgi.services.api.simpleservice;

import java.util.List;

public class SimpleClass {

	private String name;
	private boolean isReady;
	private List<String> dataSet;
	private int dataCount;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public boolean isReady() {
		return isReady;
	}
	public void setReady(boolean isReady) {
		this.isReady = isReady;
	}
	public List<String> getDataSet() {
		return dataSet;
	}
	public void setDataSet(List<String> dataSet) {
		this.dataSet = dataSet;
	}
	public int getDataCount() {
		if(this.dataSet!=null) return this.dataSet.size();
		return -1;
	}
	@Override
	public String toString() {
		return "SimpleClass [dataCount=" + dataCount + ", dataSet=" + dataSet
				+ ", isReady=" + isReady + ", name=" + name + "]";
	}
	
	
	
	
}
