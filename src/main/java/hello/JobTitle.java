package hello;

public class JobTitle {
	
	private String title;
	private String description;
	boolean executive = false; //checkbox, false = not selected
	
	public boolean getExecutive() {
		return executive;
	}
	
	public void setExecutive(boolean executive) {
		this.executive = executive;
	}


	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	@Override
	public String toString() {
		return String.format("Title: %s Description: %s Executive: %b", this.getTitle(),this.getDescription(),this.getExecutive());
	}

}
