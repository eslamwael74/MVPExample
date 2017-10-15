package com.example.eslamwael74.mvpexample.Main.Interactor;

/**
 * Created by eslamwael74 on 26/08/17.
 */


import android.os.Handler;

import java.util.Arrays;
import java.util.List;

public class FindItemInteractorImpl implements FindItemInteractor {
    @Override
    public void findItems(final OnFinishedListener listener) {

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                listener.onFinished(createList());
            }
        }, 2000);
    }

    private List<String> createList() {
        return Arrays.asList(

                "Item 0",
                    "Item 1",
                    "Item 2",
                    "Item 3",
                    "Item 4",
                    "Item 5"


        );
    }
}
