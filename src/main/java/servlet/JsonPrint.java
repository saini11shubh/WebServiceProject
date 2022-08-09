package servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import org.json.simple.JSONObject;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import bean.Game;

/**
 * Servlet implementation class MyServlet2
 */
public class JsonPrint extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		PrintWriter out=response.getWriter();
		response.setContentType("text/plain");
		out.print("Succes page");
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/GameData?verifyServerCertificate=false&useSSL=false","root","root");
			Statement stmt=conn.createStatement();
			ResultSet rst=stmt.executeQuery("select * from Game ");
			
			ArrayList<Game> ar=new ArrayList<Game>();
			while(rst.next()) {
				 int cl_id=rst.getInt(1);	//column index
				 int game_id=rst.getInt(2);
				 java.sql.Date date = rst.getDate(3);
				 int play_count=rst.getInt(4);
				 int sess_count=rst.getInt(5);
				 int ply_chip=rst.getInt(6);
				 int win_chip=rst.getInt(7);
				 
				 Game g1=new Game();
				 g1.setCl_id(cl_id);
				 g1.setGame_id(game_id);
				 g1.setDate(date);
				 g1.setPlay_count(play_count);
				 g1.setSess_count(sess_count);
				 g1.setPly_chip(ply_chip);
				 g1.setWin_chip(win_chip);
				 ar.add(g1);
			}
			
//			File jsonfile=new File("D:\\Adv.Program\\Practice\\GameData.json");
//			ObjectMapper om=new ObjectMapper();
//			om.writeValue(jsonfile, g1);
			
			JsonArray jr=new JsonArray();
			for(int i=0;i<ar.size();i++) {
				Gson g=new Gson();
				String jsonString = g.toJson(ar.get(i));
				 jr.add(jsonString);
			}
			JSONObject jo=new JSONObject();
			jo.put("data", jr);
			
			String jsonformat=jo.toJSONString().replace("\\\"","\"");
			String finalJson = jsonformat.replace("\"{","{").replace("}\"", "}");
			
			System.out.println(finalJson);
			System.out.println("Done");
			out.print("Done");
			stmt.close();
			conn.close();
		}
		catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
	}
}
