package com.demo.labpracticals.HandleEmailActivity;

import static com.demo.labpracticals.HandleEmailActivity.HandleEmail.add_email;

import android.content.Context;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import android.widget.Toast;

import java.util.ArrayList;

public class HandleEmilStack {

    private int id = 0;
    private final int layoutId;
    private final LayoutInflater layoutInflater;
    private final LinearLayout parent;
    private final Context context;
    private final ArrayList<HandleEmail> receiver;

    public HandleEmilStack(LayoutInflater layoutInflater, int layoutId, LinearLayout linearLayout, Context context){
        this.layoutInflater = layoutInflater;
        this.layoutId = layoutId;
        this.parent = linearLayout;
        this.context = context;
        this.receiver  = new ArrayList<>();
    }

    private Boolean checkIsPossible(){
        for(HandleEmail handleEmail: receiver){
            if(handleEmail.isEmpty())
                return false;
        }
        return true;
    }

    private int getInstance(int _id){
        for(int i =0 ; i < receiver.size(); i++){
            if(receiver.get(i).getId() == _id)
                return i;
        }
        return -1;
    }

    public Boolean addNewInstOfMail(){
        if(checkIsPossible()){
            int limit = receiver.size() - 1;
            if(limit >= 0){
                HandleEmail lastMail =  receiver.get(limit);
                lastMail.changeStateByString(HandleEmail.remove_email);
            }
            HandleEmail handleEmail = new HandleEmail(++id, layoutInflater, layoutId);
            handleEmail.setClickOnButton(
                    v -> {
                        if((int) v.getTag() >= 0){
                            if(!addNewInstOfMail())
                                Toast.makeText(context, "Make sure you give all mail address properly", Toast.LENGTH_SHORT).show();
                        }
                        else {
                            if(!deleteInstOfMail((int) v.getTag()))
                                Toast.makeText(context, "Some Error Occured", Toast.LENGTH_SHORT).show();
                        }

                    }
            );
            receiver.add(handleEmail);
            handleEmail.AddToParent(parent);
            return true;
        }
        return false;
    }

    public Boolean deleteInstOfMail(int removeId){
        int k = getInstance(removeId * -1);
        System.out.println("tag " + removeId);
        System.out.println("id " + id);
        System.out.println("k " + k);
        System.out.println("size " + receiver.size());

        if(receiver.size() == 1 || k == -1)
            return false;

        if(k - 1 == receiver.size() || k - 1 >= 0)
            receiver.get(k - 1).changeStateByString(add_email);

        receiver.remove(k);
        parent.removeViewAt(k);
        return true;
    }

    public String[] getEmail(){
        String[] emails = new String[receiver.size()];

        for(int c = 0; c < receiver.size(); c++){
            emails[c] = receiver.get(c).getEditTextVal();
        }
        return emails;
    }
}