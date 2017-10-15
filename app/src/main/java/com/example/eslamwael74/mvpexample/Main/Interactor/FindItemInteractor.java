package com.example.eslamwael74.mvpexample.Main.Interactor;

import java.util.List;

/**
 * Created by eslamwael74 on 26/08/17.
 */

public interface FindItemInteractor {

    interface OnFinishedListener {
        void onFinished(List<String> items);
    }

    void findItems(OnFinishedListener listener);

}
