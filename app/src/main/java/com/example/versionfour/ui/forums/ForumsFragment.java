package com.example.versionfour.ui.forums;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.versionfour.R;

import java.util.ArrayList;
import java.util.List;

public class ForumsFragment extends Fragment {

    private RecyclerView forumsRecycleView;
    private RecyclerView.Adapter forumsRecycleViewAdapter;

    private List<ForumsViewModel> viewModelList;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_forums, container, false);

        forumsRecycleView = root.findViewById(R.id.forumsRecycleView);
        forumsRecycleView.setHasFixedSize(true);

        forumsRecycleView.setLayoutManager(new LinearLayoutManager(getContext()));

        viewModelList = new ArrayList<>();
//
//        for(int i = 0; i < 10 ; i++){
//            ForumsViewModel forumsViewModel = new ForumsViewModel("Heading" + (i+1),"Some description here");
//            viewModelList.add(forumsViewModel);
//        }

        ForumsViewModel forumsViewModel = new ForumsViewModel("Book Club" ,"Cat ipsum dolor sit amet, i show my fluffy belly but it's a trap! if you pet it i will tear up your hand for miaow then turn around and show you my bum sit in box. Hack up furballs lies down for Gate keepers of hell. Lick sellotape eat too much then proceed to regurgitate all over living room carpet while humans eat dinner, let me in let me out let me in let me out let me in let me out who broke this door anyway poop in litter box, scratch the walls. Adventure always catto munch salmono lick sellotape. Cat fur is the new black chew master's slippers chase ball of string for lick plastic bags or spend all night ensuring people don't sleep sleep all day chase imaginary bugs, or cat jumps and falls onto the couch purrs and wakes up in a new dimension filled with kitty litter meow meow yummy there is a bunch of cats hanging around eating catnip .");
        viewModelList.add(forumsViewModel);

        ForumsViewModel forumsViewModel1 = new ForumsViewModel("Entrepreneur" ," Stand with legs in litter box, but poop outside kitty ipsum dolor sit amet, shed everywhere shed everywhere stretching attack your ankles chase the red dot, hairball run catnip eat the grass sniff headbutt owner's knee or stare out the window look at dog hiiiiiisssss cat slap dog in face. Terrorize the hundred-and-twenty-pound rottweiler and steal his bed, not sorry. Lick arm hair toilet paper attack claws fluff everywhere meow miao french ciao litterbox and eat a plant, kill a hand. Poop in litter box, scratch the walls crusty butthole but there's a forty year old lady there let us feast hiss and stare at nothing then run suddenly away i is not fat, i is fluffy run outside as soon as door open yet hide from vacuum cleaner. ");
        viewModelList.add(forumsViewModel1);

        ForumsViewModel forumsViewModel2 = new ForumsViewModel("Marketing" ," Why must they do that. I love cats i am one wake up scratch humans leg for food then purr then i have a and relax. Favor packaging over toy demand to be let outside at once, and expect owner to wait for me as i think about it leave dead animals as gifts, so mew and try to jump onto window and fall while scratching at wall. Reaches under door into adjacent room chase the pig around the house for if it smells like fish eat as much as you wish brown cats with pink ears catch eat throw up catch eat throw up bad birds so carefully drink from water glass and then spill it everywhere and proceed to lick the puddle. Sugar, my siamese, stalks me (in a good way), day and night hunt by meowing loudly at 5am next to human slave food dispenser try to jump onto window and fall while scratching at wall shake treat bag be superior so claws in your leg");
        viewModelList.add(forumsViewModel1);

        forumsRecycleViewAdapter = new ForumsAdapter(viewModelList , getContext());
        forumsRecycleView.setAdapter(forumsRecycleViewAdapter);

        return root;
    }
}