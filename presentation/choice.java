package presentation;
/*
	This class is used to save the user choice to use it 
	for "where" in sql
*/

public class choice {
	private String type;
	private String value;
	
	public choice(String type, String value) {
		this.setType(type);
		this.setValue(value);
	}

	public choice(String type2) {
		this.type = type2;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	@Override
	public String toString() {
		return "choice [type=" + type + ", value=" + value + "]";
	}

}
