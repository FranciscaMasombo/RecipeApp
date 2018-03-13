package ie.fran.recipeapp;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.StorageReference;


public class Add extends AppCompatActivity {

    //    private ImageButton image;
    //    private static final int galley=1;
    private EditText rName, rIn, instruction;
    //    private Uri uri = null;
    private StorageReference mStorageRef;
    private DatabaseReference mydatabaseref;
    private FirebaseDatabase fireref;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);

        rName = findViewById(R.id.rName);
        rIn = findViewById(R.id.rIn);
        instruction = findViewById(R.id.instuctions);
        mydatabaseref = FirebaseDatabase.getInstance().getReference("FullRecipe");

    }

    //
//    protected void onActivityResult(int requestcode, int resultcode, Intent data){
//        super.onActivityResult(requestcode, resultcode, data);
//        //check the code
//        if(requestcode == galley && resultcode == RESULT_OK){
//            uri = data.getData();
//            image = findViewById(R.id.foodimage);
//
//            //set the uri at the image button
//            image.setImageURI(uri);
//            // then you will have to give the app permission to read the external storage
//        }
//    }
    public void AddRecipeButton(View view) {
        String rNameText = rName.getText().toString().trim(); //trim cleans the code
        String rInText = rIn.getText().toString().trim(); //trim cleans the code
        String instructionText = instruction.getText().toString().trim(); //trim cleans the code

        //check if the fields are empty
if (!TextUtils.isEmpty(rNameText) && !TextUtils.isEmpty(rInText) && !TextUtils.isEmpty(instructionText)) {
    final DatabaseReference newpost = mydatabaseref.push();
    newpost.child("rName").setValue(rNameText);
    newpost.child("rIn").setValue(rInText);
    newpost.child("instruction").setValue(instructionText);

    Toast.makeText(this, "The Recipe has now been added", Toast.LENGTH_SHORT).show();
}

    }
}