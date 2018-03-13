package ie.fran.recipeapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class RecipeListView extends AppCompatActivity {
private RecyclerView recipelist;
    private DatabaseReference mydatabaseref;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipe_list_view);

        recipelist = findViewById(R.id.listview);
        recipelist.setHasFixedSize(true);
        recipelist.setLayoutManager(new LinearLayoutManager(this));
        mydatabaseref = FirebaseDatabase.getInstance().getReference().child("FullRecipe");

    }

    protected void onStart(){
        super.onStart();

        FirebaseRecyclerAdapter <Recipes, RecipeHolder> FBRA = new FirebaseRecyclerAdapter<Recipes, RecipeHolder>
                (
                Recipes.class,
                R.layout.activity_recipe,
                RecipeHolder.class,
                mydatabaseref
                 ){


            @Override
            protected void onBindViewHolder( RecipeHolder holder, int position, Recipes model) {
               // RecipeHolder.setName(  model.getrName());


            }



            @Override
            public RecipeHolder onCreateViewHolder(ViewGroup parent, int viewType) {
                return null;
            }

        };
        recipelist.setAdapter(FBRA);
    }
    public static class RecipeHolder extends RecyclerView.ViewHolder{
         View view;
        public RecipeHolder(View itemView) {
            super(itemView);
            view = itemView;

        }

        public void setName(String Name){
            TextView rName = view.findViewById(R.id.rName);
            rName.setText(Name);

        }

        public void  setrIn(String rIn){

        }
        public void  setIn(String instuctions){

        }
    }

}
