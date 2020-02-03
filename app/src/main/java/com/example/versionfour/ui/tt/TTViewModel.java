package com.example.versionfour.ui.tt;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class TTViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public TTViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("TimeTable");
    }

    public LiveData<String> getText() {
        return mText;
    }
}