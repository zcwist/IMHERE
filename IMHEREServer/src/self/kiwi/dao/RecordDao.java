package self.kiwi.dao;

import java.util.List;

import self.kiwi.model.Location;
import self.kiwi.model.Record;

public interface RecordDao {
	public void insertRecord(Record record);
	public List<Record> getRecordList(Location location);

}
