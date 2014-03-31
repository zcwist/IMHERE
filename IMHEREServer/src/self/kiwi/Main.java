package self.kiwi;

import java.util.Date;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import self.kiwi.dao.RecordDao;
import self.kiwi.dao.RecordDaoImplJDBC;
import self.kiwi.model.Location;
import self.kiwi.model.Record;
import self.kiwi.util.RecordToJson;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ApplicationContext context =
				new ClassPathXmlApplicationContext("applicationContext.xml");
		RecordDao recordDao = (RecordDao) context.getBean("recordDao");
		Location location = new Location(1, 1);
		Record record = new Record(1,location,"123","123",new Date(System.currentTimeMillis()));
		recordDao.insertRecord(record);
//		
		List<Record> recordList = recordDao.getRecordList(location);
//		System.out.println(recordList.get(0).getContent());
		
		System.out.println(RecordToJson.RecordToJSON(record));
		System.out.println(RecordToJson.RecordListToJSON(recordList));
	}
	
	public void test(){
		ApplicationContext context =
				new ClassPathXmlApplicationContext("applicationContext.xml");
		RecordDao recordDao = (RecordDao) context.getBean("recordDao");
		Location location = new Location(1, 1);
//		Record record = new Record(1,location,"123","123",new Date(System.currentTimeMillis()));
//		recordDao.insertRecord(record);
//		
		List<Record> recordList = recordDao.getRecordList(location);
//		System.out.println(recordList.get(0).getContent());
		
		Record record = new Record(1,location,"123","123",new Date(System.currentTimeMillis()));
		System.out.println(RecordToJson.RecordToJSON(record));
		System.out.println(RecordToJson.RecordListToJSON(recordList));
		System.out.println("here");
//		
	}
	
	public void test2(){
		RecordDao recordDao = new RecordDaoImplJDBC();
		Location location = new Location(1, 1);
//		Record record = new Record(1,location,"123","123",new Date(System.currentTimeMillis()));
//		recordDao.insertRecord(record);
//		
		List<Record> recordList = recordDao.getRecordList(location);
//		System.out.println(recordList.get(0).getContent());
		
		Record record = new Record(1,location,"123","123",new Date(System.currentTimeMillis()));
		System.out.println(RecordToJson.RecordToJSON(record));
		System.out.println(RecordToJson.RecordListToJSON(recordList));
	}
}
