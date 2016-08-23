package info.arimateia.androidmvm.view;

import android.databinding.BindingAdapter;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;
import java.util.Collection;

import info.arimateia.androidmvm.R;
import info.arimateia.androidmvm.databinding.ActivityMainBinding;
import info.arimateia.androidmvm.viewmodel.PeopleViewModel;
import info.arimateia.androidmvm.viewmodel.PersonViewModel;

public class MainActivity extends AppCompatActivity {

    private PeopleViewModel peopleViewModel;
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        peopleViewModel = new PeopleViewModel();
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        binding.setPeopleViewModel(peopleViewModel);
        binding.setView(this);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        peopleViewModel.loadPeople();

        LinearLayoutManager manager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        RecyclerView recyclerView = (RecyclerView)findViewById(R.id.list_items);
        recyclerView.setLayoutManager(manager);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @BindingAdapter("items")
    public static void setItems(RecyclerView recyclerView, Collection<PersonViewModel> items) {
        recyclerView.setAdapter(new PeopleAdapter(recyclerView.getContext(), new ArrayList<>(items)));
    }
}
