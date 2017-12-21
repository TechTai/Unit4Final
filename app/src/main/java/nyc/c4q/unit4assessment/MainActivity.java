package nyc.c4q.unit4assessment;

import android.app.FragmentTransaction;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.LinearLayoutManager;


public class MainActivity extends AppCompatActivity implements MainFragment.MainListener {

    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = (RecyclerView) findViewById(R.id.);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);

        List<String> names = new ArrayList<>();
    }
    @Override
    public void itemClicked(long id){
        View fragmentContainer = findViewById(R.id.fragment_container);
        if (fragmentContainer != null) {
            MainFragment main = new MainFragment();
            FragmentTransaction ft = getFragmentManager().beginTransaction();
            FragmentTransaction replace = ft.replace(R.id.fragment_container, main);
            ft.addToBackStack(null);
            ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
            ft.commit();
        } else {
            Intent intent = new Intent(this, DisplayFragment.class);
            startActivity(intent);
        }
    }

}

