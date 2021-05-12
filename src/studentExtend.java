

import com.sun.xml.internal.bind.v2.runtime.Name;

@bean(id = "student")
public class studentExtend extends student {

	private int id;
	private String name;
	public void setId(int id) {
		this.id = id;
	}
	public void setName(String name) {
		
		this.name = name;
	}
	public int getId() {
		return this.id;
	}
	public String getName() {
		return this.name;
	}
	public void learning() {
		System.out.println("I am learning in my style");
	}
}
