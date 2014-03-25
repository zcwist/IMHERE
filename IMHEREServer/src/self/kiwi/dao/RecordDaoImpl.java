package self.kiwi.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.sql.DataSource;

import self.kiwi.model.Location;
import self.kiwi.model.Record;

public class RecordDaoImpl implements RecordDao {
	
	private DataSource dataSource;
	

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	@SuppressWarnings("deprecation")
	public void insertRecord(Record record) {
		// TODO Auto-generated method stub

		String sql = "INSERT INTO MESSAGE (id, longitude, latitude, content, tag, date)"
				+ "VALUES(?,?,?,?,?,?)";
		Connection conn = null;
		try{
			conn = dataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, String.valueOf(getNum(conn)+1));
			ps.setFloat(2, record.getLocation().getLongitude());
			ps.setFloat(3, record.getLocation().getLatitude());
			ps.setString(4, record.getContent());
			ps.setString(5, record.getTag());
			ps.setString(6, record.getDate().toLocaleString());
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
	
	public int getNum(Connection conn){
		String getNum = "SELECT COUNT(*) FROM MESSAGE";
		PreparedStatement ps;
		try {
			ps = conn.prepareStatement(getNum);
			ResultSet rs = ps.executeQuery();
			return rs.getInt(1);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;

	}

	public List<Record> getRecordList(Location location) {
		// TODO Auto-generated method stub
		String sql = "SELECT * FROM MESSAGE";
		Connection conn = null;
		List<Record> recordList = new ArrayList<Record>();
		try{
			
			conn = dataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			
			//Each Record, Location
			Record record = null;
			Location loc = null;
			
			ResultSet rs = ps.executeQuery();
			if (rs.next()){
				loc = new Location(rs.getString("longitude"), rs.getString("latitude"));
				SimpleDateFormat strToDate = new SimpleDateFormat ("yyyy-m-dd hh:mm:ss");
				Date date = new Date();
				try {
					date = strToDate.parse(rs.getString("date"));
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				record = new Record(Integer.valueOf(rs.getString("id")),
							loc,
							rs.getString("content"),
							rs.getString("tag"),
							date);
				recordList.add(record);
	
			}
		} catch (SQLException e){
			e.printStackTrace();
		} finally{
			if (conn != null){
				try {
					conn.close();
				} catch (SQLException e){}
			}
		}
		
		return recordList;
	}

}
