package org.upm.btb.accelerometer.fbcloudfirestore;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;

import android.util.Log;
import android.widget.TextView;
import androidx.annotation.NonNull;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.Map;


public class ListaActivity extends AppCompatActivity {

    private static final String TAG = "btb";

    FirebaseFirestore db;

    private TextView retrieveTV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista);

        retrieveTV = findViewById(R.id.tvFirebase);
        db = FirebaseFirestore.getInstance();

        // Obtain an element from CloudFirestore
        DocumentReference docRef = db.collection("moves").document("max");
        docRef.get()
                .addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
                    @Override
                    public void onSuccess(DocumentSnapshot documentSnapshot) {
                        if (documentSnapshot.exists()) {
                            Log.d(TAG, "Element found: " + documentSnapshot.getData());
                            Map<String,Object> data = documentSnapshot.getData();
                            retrieveTV.setText("Max value: X["+data.get("x")+"] Y["+data.get("y")+"] Z["+data.get("z")+"]");

                        } else {
                            Log.d(TAG, "Element not found.");
                        }
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Log.w(TAG, "Error getting element.", e);
                    }
                });

    }

}