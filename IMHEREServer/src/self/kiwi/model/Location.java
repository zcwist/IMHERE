package self.kiwi.model;

public class Location {
	private float latitude;
	private float longitude;
	
	public Location(float latitude, float longitude) {
		super();
		this.latitude = latitude;
		this.longitude = longitude;
	}
	public Location(String latitude, String longitude) {
		super();
		this.latitude = Float.valueOf(latitude);
		this.longitude = Float.valueOf(longitude);
	}
	public float getLatitude() {
		return latitude;
	}
	public void setLatitude(float latitude) {
		this.latitude = latitude;
	}
	public float getLongitude() {
		return longitude;
	}
	public void setLongitude(float longitude) {
		this.longitude = longitude;
	}
}
