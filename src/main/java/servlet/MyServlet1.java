package servlet;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;


/**
 * Servlet implementation class MyServlet1
 */
public class MyServlet1 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	
		
		int id=Integer.parseInt(request.getParameter("id"));	
		System.out.println("Id is"+id);
		int gameId=Integer.parseInt(request.getParameter("game_id"));
		
		String date=request.getParameter("date");
		System.out.println("Date is"+ date);
		
		
		
		int play_count=Integer.parseInt(request.getParameter("play_count"));
		int sess_count=Integer.parseInt(request.getParameter("sess_count"));
		int ply_chip=Integer.parseInt(request.getParameter("ply_chip"));
		int win_chip=Integer.parseInt(request.getParameter("win_chip"));
		
		PrintWriter out=response.getWriter();
		response.setContentType("text/plain");
		out.println("Id id"+id);
		out.println("Game Id is "+gameId);
		out.println("Play count is "+play_count);
		out.println("Session count is "+sess_count);
		out.println("play chip is "+ply_chip);
		out.println("win chip is "+win_chip);
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/GameData","root","root");
			Statement stmt=conn.createStatement();
			
					
							
			int cnt =stmt.executeUpdate("insert into Game (cl_id, game_id, play_count,date,sess_count,ply_chip,win_chip) values "
					+ "("+id+","+gameId+","+play_count+",'"+date+"',"+sess_count+","+ply_chip+","+win_chip+")");		
			
				request.setAttribute("cnt", cnt);
		//	RequestDispatcher rd=request.getRequestDispatcher("back.jsp");
		//	rd.forward(request, response);
			if (cnt==1)
				out.println("Data inserted successfully");
			else 
				out.println("Failed insert!!!");
			
			stmt.close();
			conn.close();	
		}
		catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
//		   RequestDispatcher rd=request.getRequestDispatcher("index.jsp");  
//	        rd.include(request,response);  
	}
}
