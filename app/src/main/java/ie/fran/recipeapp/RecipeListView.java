package ie.fran.recipeapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
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

        FirebaseRecyclerOptions<Recipes> options =
                new FirebaseRecyclerOptions.Builder<Recipes>()
                .setQuery(mydatabaseref,Recipes.class)
                .build();

        FirebaseRecyclerAdapter FBRA = new FirebaseRecyclerAdapter<Recipes, RecipeHolder>(options){

//
//
//        FirebaseRecyclerAdapter <Recipes, RecipeHolder> FBRA;
//
//        FBRA = new FirebaseRecyclerAdapter<Recipes, RecipeHolder>
//                (mydatabaseref,
//                Recipes.class,
//                R.layout.activity_listlayout,
//                RecipeHolder.class
//                 ){


            @Override
            protected void onBindViewHolder(RecipeHolder holder, int position, Recipes model) {
               holder.setName(model.getrName());
               final String key =getRef(position).getKey().toString();
               holder.view.setOnClickListener(new View.OnClickListener() {
                   @Override
                   public void onClick(View v) {

                   }
               });

            }


            @Override
            public RecipeHolder onCreateViewHolder(ViewGroup parent, int viewType) {
                View view = LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.activity_listlayout,parent,false);
                return new RecipeHolder(view);
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
            TextView r_Name = view.findViewById(R.id.rName);
            r_Name.setText(Name);

        }

        public void  setrIn(String rIn){

        }
        public void  setIn(String instuctions){

        }
    }

}
