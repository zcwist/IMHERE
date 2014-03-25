package self.kiwi.util;

import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import self.kiwi.model.Record;

public class RecordToJson {
	
	@SuppressWarnings("deprecation")
	public static JSONObject RecordToJSON(Record record){
		JSONObject jsonObject = new JSONObject();
		try {
			jsonObject.put("id", record.getId());
			jsonObject.put("content", record.getContent());
			jsonObject.put("date", record.getDate().toLocaleString());
			jsonObject.put("tag", record.getTag());
			jsonObject.put("laitude", record.getLocation().getLatitude());
			jsonObject.put("longitude", record.getLocation().getLongitude());
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

        return jsonObject; 
		
	}
	
	public static JSONObject RecordListToJSON(List<Record> recordList){
		JSONObject jsonObject = new JSONObject();
		try {
			jsonObject.put("total",recordList.size());
			JSONArray jsonArray = new JSONArray();
			for(Record record:recordList){
				jsonArray.put(RecordToJSON(record));
				
			}
			jsonObject.put("list", jsonArray);
			
			
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		return jsonObject;
	}
	
	public static Record StringToRecord(String str){
		return null;
		
	}
	

}
