package self.kiwi.dao;

import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import self.kiwi.model.Record;

public class RecordDaoImpl implements RecordDao {
	
	private DataSource dataSource;
	

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	public void insertRecord(Record record) {
		// TODO Auto-generated method stub
		String sql = "INSERT INTO MESSAGE (id, longtitude, latitude, content, tag, date"
				+ "VALUES(?,?,?,?,?,?)";
		java.sql.Connection conn = null;
		try{
			conn = dataSource.getConnection();
			java.sql.PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, String.valueOf(record.getId()));
			ps.setFloat(2, record.getLocation().getLongitude());
			ps.setFloat(3, record.getLocation().getLatitude());
			ps.setString(4, record.getContent());
			ps.setString(5, record.getDate().toString());
			ps.executeUpdate();
			ps.close();
		} catch (SQLException e){
			e.printStackTrace();
		} finally{
			if (conn != null){
				try {
					conn.close();
				} catch (SQLException e){}
			}
		}
		

	}

	public List<Record> getRecordList() {
		// TODO Auto-generated method stub
		return null;
	}

}
