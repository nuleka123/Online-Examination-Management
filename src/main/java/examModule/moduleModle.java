package examModule;

public class moduleModle {
	private int Id;
	private String moduleName;
	private String moduleNum;
	private String timeDiuration;
	private String picture;
	
	public moduleModle(int id, String moduleName, String moduleNum, String timeDiuration, String picture2) {
		super();
		this.Id = id;
		this.moduleName = moduleName;
		this.moduleNum = moduleNum;
		this.timeDiuration = timeDiuration;
		this.picture = picture2;
	}

	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}

	public String getModuleName() {
		return moduleName;
	}

	public void setModuleName(String moduleName) {
		this.moduleName = moduleName;
	}

	public String getModuleNum() {
		return moduleNum;
	}

	public void setModuleNum(String moduleNum) {
		this.moduleNum = moduleNum;
	}

	public String getTimeDiuration() {
		return timeDiuration;
	}

	public void setTimeDiuration(String timeDiuration) {
		this.timeDiuration = timeDiuration;
	}

	public String getPicture() {
		return picture;
	}

	public void setPicture(String picture) {
		this.picture = picture;
	}
	
	
		
}

