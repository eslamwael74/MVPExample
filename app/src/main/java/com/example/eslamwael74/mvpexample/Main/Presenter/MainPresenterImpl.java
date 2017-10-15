package com.example.eslamwael74.mvpexample.Main.Presenter;

import android.widget.Toast;

import com.example.eslamwael74.mvpexample.Main.Interactor.FindItemInteractor;
import com.example.eslamwael74.mvpexample.Main.View.MainView;

import java.util.List;

/**
 * Created by eslamwael74 on 26/08/17.
 */

public class MainPresenterImpl implements MainPresenter, FindItemInteractor.OnFinishedListener {

    private MainView mainView;
    private FindItemInteractor findItemsInteractor;


    public MainPresenterImpl(MainView mainView, FindItemInteractor findItemsInteractor) {
        this.mainView = mainView;
        this.findItemsInteractor = findItemsInteractor;
    }

    @Override
    public void onResume() {
        if(mainView != null){
            mainView.showProgress();
        }
        findItemsInteractor.findItems(this);
    }

    @Override
    public void onItemClicked(int position) {
        if(mainView != null){
            mainView.showMessage("item" + position + " clicked!!");
        }
    }

    @Override
    public void onDestroy() {
        mainView = null;
    }

    @Override
    public void onFinished(List<String> items) {
        if(mainView != null){
            mainView.setItems(items);
            mainView.hideProgress();
        }
    }
    public MainView getMainView(){
        return mainView;
    }
}
