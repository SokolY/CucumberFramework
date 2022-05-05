package recources;

import pojo.AddPlaceRequest;
import pojo.Location;

public class TestDataBuild {

	public AddPlaceRequest addPlacePayload(String name, String website, String language) {
		String[] tp = { "shoe park", "shop" };

		AddPlaceRequest addPlace = new AddPlaceRequest();
		Location location = new Location();
		location.setLat(-38.383494);
		location.setLng(33.427362);

		addPlace.setLocation(location);
		addPlace.setAccuracy(30);
		addPlace.setName(name);
		addPlace.setPhone_number("(+91) 983 893 3937");
		addPlace.setAddress("29, side layout, cohen 09");
		addPlace.setTypes(tp);
		addPlace.setWebsite(website);
		addPlace.setLanguage(language);
		return addPlace;
	}
}
