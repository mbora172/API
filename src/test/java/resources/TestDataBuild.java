package resources;

import pojo.AddPlace;
import pojo.Location;

import java.util.ArrayList;
import java.util.Arrays;

public class TestDataBuild {
    public AddPlace addPlacePayLoad(String name,String lang,String addy){
        AddPlace addPlace=new AddPlace();
        addPlace.setAddress(addy);
        addPlace.setAccuracy(50);
        addPlace.setLanguage(lang);
        addPlace.setPhone_number("87246583");
        addPlace.setName(name);
        ArrayList<String> mList = new ArrayList<String>();
        mList.addAll(Arrays.asList("shoe park","shop"));
        addPlace.setType(mList);
        Location location=new Location();
        location.setLat(-38.344);
        location.setLng(33.836);
        addPlace.setLocation(location);
        return addPlace;
    }
    public String deletePlacePayload(String placeId)
    {
        return "{\r\n    \"place_id\":\""+placeId+"\"\r\n}";
    }
}
