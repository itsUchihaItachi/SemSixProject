package com.example.versionfour.ui.attendance;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class attendanceViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public attendanceViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is attendance fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}