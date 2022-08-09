package servlet;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Map;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.DatabaseReference.CompletionListener;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class FirebaseService {

	private static final String FIREBASE_DB_URL = "https://game-91ae1-default-rtdb.firebaseio.com/";
	private static final String SERVICE_ACCOUNT_JSON_PATH = "D:\\Intenship\\3rd\\project\\game-91ae1-13145e0357e2.json";

	private FirebaseDatabase firebaseDatabase;
	
	public void connectFirebaseDatabase() throws IOException {

		FileInputStream serviceAccount = new FileInputStream(SERVICE_ACCOUNT_JSON_PATH);

		FirebaseOptions options = FirebaseOptions.builder()
				.setCredentials(GoogleCredentials.fromStream(serviceAccount)).setDatabaseUrl(FIREBASE_DB_URL).build();

		FirebaseApp.initializeApp(options);
		firebaseDatabase = FirebaseDatabase.getInstance(FIREBASE_DB_URL);
	}
	
	public void saveData(Map<String, Object> data) {
		DatabaseReference ref = firebaseDatabase.getReference();
		ref.setValue(data, new CompletionListener() {
			
			@Override
			public void onComplete(DatabaseError error, DatabaseReference ref) {
				System.out.println("Data Successfully Saved");
			}
		});
	}
	
	public void fetchData() {
		DatabaseReference ref = firebaseDatabase.getReference();
		ref.addListenerForSingleValueEvent(new ValueEventListener() {
			
			@Override
			public void onDataChange(DataSnapshot snapshot) {
				Object res = snapshot.getValue();
				System.out.println(res);
			}
			
			@Override
			public void onCancelled(DatabaseError error) {

			}
		});
	}
}
