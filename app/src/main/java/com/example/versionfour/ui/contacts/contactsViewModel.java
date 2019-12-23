package com.example.versionfour.ui.contacts;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class contactsViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public contactsViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is Contacts fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}