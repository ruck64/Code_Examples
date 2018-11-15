
/**
 * @author rutgerluther
 * all the gets and sets for my objects
 * @param <T>
 */
public class HashObject<T> {

	private T object;
	private int key;
	private int dupl;
	private int pro;
	
	public HashObject(T object, int key) {
		setObject(object);
		setKey(key);
	}
	
	public T getObject() {
		return object;
	}
	
	public int getKey() {
		return key;
	}
		
	public int getProbe() {
		return pro;
	}
	
	public int getDuplicate() {
		return dupl;
	}
	
	public void setObject(T object) {
		this.object = object;
	}
	
	public void setKey(int key) {
		this.key = key;
	}
	
	public void setProbe(int probe) {
		this.pro = probe;
	}
	
	public void setDuplicate(int dupl) {
		this.dupl = dupl;
	}
	
	public String toString(HashObject input, int place) {
		
		return "Table[" + place + "]: " + input.getObject() + " "  + input.getProbe() + " " + input.getDuplicate();
		
	}
	
	public boolean equals(HashObject input) {
		
		if(this.getKey() == input.getKey()) {
		
			return true;
		}
		
		else {return false;}
		}
}
	
	// throw in two constructors different names

