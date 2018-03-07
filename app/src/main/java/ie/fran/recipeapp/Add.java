package ie.fran.recipeapp;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;

import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.FirebaseStorage;

public class Add extends AppCompatActivity {

    private ImageButton image;
    private static final int galley=1;
    private EditText rName,rIn, instruction;
    private Uri uri = null;
    private StorageReference mStorageRef;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);

        rName= findViewById(R.id.rName);
        rIn= findViewById(R.id.rIn);
        instruction= findViewById(R.id.instuctions);
        mStorageRef = FirebaseStorage.getInstance().getReference("FullRecipe");

    }


    public void foodimage(View view){
        Intent galleryintent = new Intent(Intent.ACTION_GET_CONTENT);
        galleryintent.setType("Image/*");
        startActivityForResult(galleryintent,galley);

        int[] mArray = new int[2];
        mArray[0] = R.drawable.grocery;
        mArray[1] = R.drawable.back;
    }
    protected void onActivityResult(int requestcode, int resultcode, Intent data){
        super.onActivityResult(requestcode, resultcode, data);
        //check the code
        if(requestcode == galley && resultcode == RESULT_OK){
            uri = data.getData();
            image = findViewById(R.id.foodimage);

            //set the uri at the image button
            image.setImageURI(uri);
            // then you will have to give the app permission to read the external storage
        }
    }
    public void AddRecipeButton(View view){
        String rNameText = rName.getText().toString().trim(); //trim cleans the code
        String rInText = rIn.getText().toString().trim(); //trim cleans the code
        String instructionText = instruction.getText().toString().trim(); //trim cleans the code

    }
}
