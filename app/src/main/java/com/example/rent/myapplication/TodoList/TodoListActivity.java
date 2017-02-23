package com.example.rent.myapplication.TodoList;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.rent.myapplication.R;

/**
 * Created by RENT on 2017-02-22.
 */

public class TodoListActivity extends AppCompatActivity {


    TodoListAdapter todoListAdapter = new TodoListAdapter();

    @Override
    public void onItemCheckStateChanged(int checkedItemsCount) {
        if (checkedItemsCount > 0) {
            getSupportActionBar().setTitle("checked items");

        } else {
            getSupportActionBar().setTitle(activityTitle);
        }
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.todo_activity);

        activityTitle = getSupportActionBar().getTitle().toString();
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        todoListAdapter = new TodoListAdapter();


        recyclerView.setAdapter(todoListAdapter);

        todoListAdapter.setCheckListener((OnItemCheckStateChenged) this);

        final EditText editText = (EditText) findViewById(R.id.todo_edit_text);

        Button addButton = (Button) findViewById(R.id.add_button);

        addButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                todoListAdapter.addItem(editText.getText().toString());
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.todo_list_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.delete_item) {
            TodoListAdapter.deleteAllCheckedItems();
        }
        return super.onOptionsItemSelected(item);
    }
}


