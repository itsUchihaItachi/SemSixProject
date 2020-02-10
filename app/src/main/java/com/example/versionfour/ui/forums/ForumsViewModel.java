package com.example.versionfour.ui.forums;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.security.PrivateKey;

public class ForumsViewModel extends ViewModel {
    private String head;
    private String desc;

    public ForumsViewModel(String head, String desc) {
        this.head = head;
        this.desc = desc;
    }
     public String getHead(){
         return head;
        }

        public String getDesc(){
        return desc;
        }


}