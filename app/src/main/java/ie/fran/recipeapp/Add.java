package ie.fran.recipeapp;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
public class Add extends AppCompatActivity {

    private ImageButton image;
    private static final int galley=1;
    private EditText rName,rIn, instruction;
    private Uri uri = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);

        rName= findViewById(R.id.rName);
        rIn= findViewById(R.id.rIn);
        instruction= findViewById(R.id.instuctions);
    }

    public void AddRecipe(View view) {
    }
    //to get the food image
    public void foodimage(View view){
        Intent galleryimage = new Intent(Intent.ACTION_GET_CONTENT);
        galleryimage.setType("Image/*");
        startActivityForResult(galleryimage,galley);
    }
    protected void onActivityResult(int code, int code2, Intent data){
        super.onActivityResult(code, code2, data);
        if(code == galley && code2 == RESULT_OK){
            uri = data.getData();
            image = findViewById(R.id.foodimage);
            image.setImageURI(uri);
        }
    }
}
