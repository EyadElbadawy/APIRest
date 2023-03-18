package Files;

public class PutParameters {

    private String placeId;
    private String address = "70 winter walk, Egypt";
    private String key = "qaclick123";

    public String getPlaceId() {
        return placeId;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public void setPlaceId(String placeId)
    {

        this.placeId = placeId;
    }

    public void step1()
    {
        placeId = String.format("{\n" +
                "\"place_id\":\""+"%s"+"\",\n" +
                "\"address\":\"%s\",\n" +
                "\"key\":\"%s\"\n" +
                "}\n",placeId,address,key);
    }

}