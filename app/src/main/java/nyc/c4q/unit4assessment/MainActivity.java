package nyc.c4q.unit4assessment;

import android.app.FragmentTransaction;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity implements MainFragment.MainListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    @Override
    public void itemClicked(long id){
        View fragmentContainer = findViewById(R.id.fragment_container);
        if (fragmentContainer != null) {
//    Step 3 - Adding the Fragment transaction so that the back button can be used properly (back stack)
            MainFragment main = new MainFragment();
            FragmentTransaction ft = getFragmentManager().beginTransaction();   // Starts the fragment transaction
            FragmentTransaction replace = ft.replace(R.id.fragment_container, main);//  Replaces the fragment and adds to the backstack
            ft.addToBackStack(null);     //  Replaces the fragment and adds to the backstack. Most of the time transaction retrieval not needed so you can set to "null"/ If using then its a String
            ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);    //  Gets the new and old fragments to fade in and out
            ft.commit();    //  Commit the transaction
        } else {
            Intent intent = new Intent(this, DisplayFragment.class);
            startActivity(intent);
//    If the frame layout isnt there, the app must be running on a device with a smaller screen so start DetailActivity by passing it the ID of the workout.
        }
    }

}

