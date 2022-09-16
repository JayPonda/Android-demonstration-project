package com.demo.labpracticals.HandleEmailActivity;

import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TableRow;

import com.demo.labpracticals.R;

public class HandleEmail{

    private final int id;
    private final TableRow tableRow;
    private final EditText editText;
    private final ImageButton imageButton;
    private int currentState = add_email;

    public static final int add_email = R.string.add_email;
    public static final int remove_email = R.string.remove_email;

    public HandleEmail(int id, TableRow tableRow, int editTextId, int imageButtonId, int currentState){
        this.id = id;
        this.currentState = currentState;
        this.tableRow = tableRow;
        this.editText = this.tableRow.findViewById(editTextId);
        this.imageButton = this.tableRow.findViewById(imageButtonId);
        this.imageButton.setTag(this.id);
    }

    public HandleEmail(int id, LayoutInflater layoutInflater, int resId){
        this.id = id;
        this.tableRow = (TableRow) layoutInflater.inflate(resId, null, false);
        this.editText = tableRow.findViewById(R.id.receiverEmail);
        this.imageButton = tableRow.findViewById(R.id.addReceiverEmailAddress);
        this.imageButton.setTag(this.id);
    }

    public int getId() {
        return id;
    }

    public HandleEmail(int id, LayoutInflater layoutInflater, int resId,  int customState){
        this(id, layoutInflater, resId);
        this.currentState = customState;
    }


    public void AddToParent(LinearLayout view){
        view.addView(tableRow);
    }

    public TableRow getTableRow() {
        return tableRow;
    }

    public String getEditTextVal() {
        return editText.getText().toString();
    }

    public Boolean isEmpty(){
        return getEditTextVal().isEmpty();
    }

    public int getButtonStatus() {
        return currentState;
    }

    private void setImage(){
        if(currentState == remove_email){
            int remove_email_drawable = R.drawable.ic_baseline_remove_24;
            imageButton.setImageResource(remove_email_drawable);
        }
        else{
            int add_email_drawable = R.drawable.ic_baseline_add_24;
            imageButton.setImageResource(add_email_drawable);
        }
        imageButton.setTag((int)imageButton.getTag() * -1);
    }

    public void changeStateByString(int id){
        currentState = id;
        setImage();
    }

    public void setClickOnButton(View.OnClickListener clickListener){
        imageButton.setOnClickListener(clickListener);
    }
}
