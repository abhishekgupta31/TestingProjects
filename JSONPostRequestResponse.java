package restAssuredDemo;

public class JSONPostRequestResponse {
	
	/*{
	    "name": "morpheus",
	    "job": "leader",
	    "id": "260",
	    "createdAt": "2024-08-25T17:50:42.546Z"
	}*/
	
	public String name;
	public String job;
	public String id;
	public String createdAt;
	
	 // Getters and setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

	

}
