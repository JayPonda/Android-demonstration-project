package com.demo.labpracticals;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import com.demo.labpracticals.databinding.ActivityTodoListDemoBinding;

import java.util.ArrayList;
import java.util.Objects;

public class TodoListDemoActivity extends AppCompatActivity {

    ActivityTodoListDemoBinding binding;
    ArrayList<String> todos = new ArrayList<>();
    Toast toast;
    Boolean isUpdate = false;
    int itemPosition;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityTodoListDemoBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);

        // Read
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, todos);
        binding.listViewTodos.setAdapter(adapter);

        // Write
        binding.submitFormElm.setOnClickListener(v -> {
            String newTodo = binding.todosFormElm.getText().toString();
            if(newTodo.isEmpty())
                showToast("empty todo can not be inserted");
            else{
                binding.todosFormElm.setText("");
                if(isUpdate){
                    todos.set(itemPosition, newTodo);
                    isUpdate = false;
                    binding.submitFormElm.setText(getString(R.string.add));
                }
                else
                    todos.add(newTodo);

                adapter.notifyDataSetChanged();
            }
        });

        // Update
        binding.listViewTodos.setOnItemClickListener((parent, view, position, id) -> {
            String oldVal = todos.get(position);
            binding.todosFormElm.setText(oldVal);
            showToast("you can update value from above control");
            binding.submitFormElm.setText(getString(R.string.edit));
            isUpdate = true;
            itemPosition = position;
        });

        // Delete
        binding.listViewTodos.setOnItemLongClickListener((parent, view, position, id) -> {
            if(isUpdate){
                Toast.makeText(this, "please complete your edit task", Toast.LENGTH_SHORT).show();
                return true;
            }
            AlertDialog.Builder alertBuilder = new AlertDialog.Builder(this);
            alertBuilder.setTitle("Delete Alert")
                    .setMessage("are you sure, you want to delete this item?")
                    .setPositiveButton(getString(R.string.yes_delete), (dialog, which) -> {
                        todos.remove(position);
                        adapter.notifyDataSetChanged();
                    }) .setNegativeButton(getString(R.string.cancel), (dialog, which) -> dialog.dismiss()).show();
            alertBuilder.create();
            return true;
        });
    }

    // helper
    private void showToast(String msg){
        if(toast != null)
            toast.cancel();
        toast = Toast.makeText(TodoListDemoActivity.this, msg, Toast.LENGTH_SHORT);
        toast.show();
    }

    // set Back button
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId() == android.R.id.home){
            finish();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

}