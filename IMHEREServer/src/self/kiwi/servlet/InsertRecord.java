package self.kiwi.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import self.kiwi.Main;
import self.kiwi.dao.RecordDao;
import self.kiwi.model.Location;
import self.kiwi.model.Record;
import self.kiwi.util.RecordToJson;

@SuppressWarnings("serial")
public class InsertRecord extends HttpServlet {
	ApplicationContext context = null;
	RecordDao recordDao = null;
	
	/**
	 * Constructor of the object.
	 */
	public InsertRecord() {
		super();
	}

	/**
	 * Destruction of the servlet. <br>
	 */
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	/**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		
		Location loc = new Location(request.getParameter("latitude"),
				request.getParameter("longitude"));
		
		System.out.println("Get a get");
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println(printResponse(loc));
		out.flush();
		out.close();
		
	}

	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred 
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {		
		Location loc = new Location(request.getParameter("latitude"),
		request.getParameter("longitude"));
				
		Record rec = new Record(0, loc, request.getParameter("content"), "", new Date(System.currentTimeMillis()));
		recordDao.insertRecord(rec);
		
		System.out.println("Get a post");
		

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println(printResponse(loc));
		out.flush();
		out.close();
	}
	
	private String printResponse(Location loc){
		return RecordToJson.RecordListToJSON(recordDao.getRecordList(loc)).toString();

	}

	/**
	 * Initialization of the servlet. <br>
	 *
	 * @throws ServletException if an error occurs
	 */
	public void init() throws ServletException {
		// Put your code here
		context = new ClassPathXmlApplicationContext("applicationContext.xml");
		recordDao = (RecordDao) context.getBean("recordDao");
	}

}
