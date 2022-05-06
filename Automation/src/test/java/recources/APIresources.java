package recources;

public enum APIresources {

	addPlaceAPI("/maps/api/place/add/json"),
	getPlaceAPI("/maps/api/place/get/json"),
	deletePlaceAPI("/maps/api/place/delete/json");
	
	String resource;	
	
	APIresources (String resource){
		this.resource = resource;
	}
	public String getResourse() {
		return resource;
	}
}
