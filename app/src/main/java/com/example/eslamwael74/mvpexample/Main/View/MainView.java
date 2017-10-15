package com.example.eslamwael74.mvpexample.Main.View;

import java.util.List;

/**
 * Created by eslamwael74 on 26/08/17.
 */

public interface MainView {

    void showProgress();

    void hideProgress();

    void setItems(List<String> items);

    void showMessage(String message);

}
