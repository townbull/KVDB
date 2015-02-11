package core;

import java.util.Hashtable;
import java.util.Set;

public class DB {
	private Hashtable<String, String> storage;
	private Hashtable<String, Integer> count;

	public DB() {
		this.storage = new Hashtable<String, String>();
		this.count = new Hashtable<String, Integer>();
	}

	public void setValue(String key, String value) {
		if(storage.containsKey(key)){
			String v = storage.get(key);
			count.put(v, count.get(v)-1);
		}
		storage.put(key, value);
		int c = 0;
		if (count.containsKey(value)) {
			c = count.get(value);
		}
		count.put(value, c + 1);
	}

	public String getValue(String key) {
		if (!storage.containsKey(key)) {
			return "NULL";
		}
		return storage.get(key);
	}

	public void deleteValue(String key) {
		int c = count.get(storage.get(key));
		count.put(storage.get(key), c - 1);
		storage.remove(key);
	}

	public int countValue(String value) {
		if (!count.containsKey(value)) {
			return 0;
		}
		return count.get(value);
	}

	public void copyValues(DB cache) {
		for (String k : cache.getKeys()) {
			String v = cache.getValue(k);
			if("NULL".equals(v)) this.deleteValue(k);
			else this.setValue(k, v);
		}
	}

	public boolean isEmpty() {
		return this.storage.isEmpty();
	}
	
	public Set<String> getKeys(){
		return this.storage.keySet();
	}

	public boolean countainsKey(String key) {
		// TODO Auto-generated method stub
		return this.storage.containsKey(key);
	}
}
