package com.example.versionfour.ui.contacts;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class contactsViewModel extends ViewModel {

    public String title = " ";
    public String contactNumber = "";
    public int imgResId = 0;

    public contactsViewModel(int imgResId, String title, String contactNumber) {
        this.imgResId = imgResId;
        this.title = title;
        this.contactNumber = contactNumber;
    }
}