package com.example.antuan.todolist;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends ActionBarActivity {

    private ArrayList<String> doneList;
    private ArrayList<String> toDoList;
    private ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        doneList = new ArrayList<>();
        toDoList = new ArrayList<>();
        // you might need to read from a file to show the old activities
    }


    public void addElement(View view) {
        EditText newActivity = (EditText) findViewById(R.id.newActivity);
        toDoList.add(newActivity.getText().toString());
        if (adapter == null) {
            adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, toDoList);
        } else {
            adapter.notifyDataSetChanged();
        }
        ListView listView = (ListView) findViewById(R.id.the_list);
        listView.setAdapter(adapter);
        newActivity.setText("");
    }


    public void clearSpace(View view) {
        EditText newActivity = (EditText) findViewById(R.id.newActivity);
        newActivity.setText("");
    }

    public void removeElement(View view) {
        EditText newActivity = (EditText) findViewById(R.id.newActivity);
        toDoList.remove(newActivity.getText().toString());
        if (adapter == null) {
            adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, toDoList);
        } else {
            adapter.notifyDataSetChanged();
        }
        ListView listView = (ListView) findViewById(R.id.the_list);
        listView.setAdapter(adapter);
        newActivity.setText("");
    }
}





