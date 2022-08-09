package servlet;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/firebase.do")
public class FirebaseServlet extends HttpServlet {

	private static final long serialVersionUID = 8493105349818704723L;

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		var data = retrieveDataFromRequest(request);
		FirebaseService firebaseService = new FirebaseService();
		firebaseService.connectFirebaseDatabase();
		firebaseService.saveData(data);
		firebaseService.fetchData();
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		FirebaseService firebaseService = new FirebaseService();
		firebaseService.connectFirebaseDatabase();
		firebaseService.fetchData();
	}

	private Map<String, Object> retrieveDataFromRequest(HttpServletRequest request) {
		Map<String, Object> data = new HashMap<>();

		data.put("id", request.getParameter("id"));
		data.put("date", request.getParameter("date"));
		data.put("game_id", request.getParameter("game_id"));
		data.put("play_count", request.getParameter("play_count"));
		data.put("sess_count", request.getParameter("sess_count"));
		data.put("ply_chip", request.getParameter("ply_chip"));
		data.put("win_chip", request.getParameter("win_chip"));
		return data;
	}

}
