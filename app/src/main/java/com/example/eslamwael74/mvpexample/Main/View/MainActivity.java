package com.example.eslamwael74.mvpexample.Main.View;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.eslamwael74.mvpexample.Main.Interactor.FindItemInteractorImpl;
import com.example.eslamwael74.mvpexample.Main.Presenter.MainPresenter;
import com.example.eslamwael74.mvpexample.Main.Presenter.MainPresenterImpl;
import com.example.eslamwael74.mvpexample.R;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnItemClick;

public class MainActivity extends AppCompatActivity implements MainView, AdapterView.OnItemClickListener {

    @BindView(R.id.list)ListView listView;
    @BindView(R.id.progress)ProgressBar progress;

    private MainPresenter presenter;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);


        presenter = new MainPresenterImpl(this, new FindItemInteractorImpl());


    }

    @Override
    protected void onResume() {
        super.onResume();
        presenter.onResume();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter.onDestroy();
    }

    @Override
    public void showProgress() {
        progress.setVisibility(View.VISIBLE);
        listView.setVisibility(View.INVISIBLE);
    }

    @Override
    public void hideProgress() {
        progress.setVisibility(View.GONE);
        listView.setVisibility(View.VISIBLE);
    }

    @Override
    public void setItems(List<String> items) {
        listView.setAdapter(new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,items));
    }

    @Override
    public void showMessage(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    @Override
    @OnItemClick(R.id.list)
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        presenter.onItemClicked(i);
    }
}
