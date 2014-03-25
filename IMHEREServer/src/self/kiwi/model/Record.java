package self.kiwi.model;

import java.util.Date;

public class Record {
	private int id;
	private Location location;
	private String content;
	private String tag;
	private Date date;
	
	public Record(int id, Location location, String content, String tag,
			Date date) {
		super();
		this.id = id;
		this.location = location;
		this.content = content;
		this.tag = tag;
		this.date = date;
	}
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Location getLocation() {
		return location;
	}
	public void setLocation(Location location) {
		this.location = location;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getTag() {
		return tag;
	}
	public void setTag(String tag) {
		this.tag = tag;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}

}
