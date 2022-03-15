package model;

public class Viewer {
	
	private String name;
	private String id;
	
	public Viewer(String name, String id) {
		this.name = name;
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Viewer) {
			Viewer other = (Viewer) obj;
			return this.id.equals(other.getId());
		}else {
			return false;
		}
	}
	
	
	
}
