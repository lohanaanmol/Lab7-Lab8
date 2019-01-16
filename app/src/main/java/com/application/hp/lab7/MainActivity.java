package com.application.hp.lab7;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.ScrollView;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Set;

public class MainActivity extends AppCompatActivity {
    private BluetoothAdapter BA;

Button b1,b2,b3,b4;
TextView textView;
ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        b1=findViewById(R.id.tb);
        b2=findViewById(R.id.gvb);
        b3=findViewById(R.id.spdb);
        b4=findViewById(R.id.tob);
        listView=findViewById(R.id.lv);
        textView=findViewById(R.id.textView4);
        BA = BluetoothAdapter.getDefaultAdapter();


    }

    public void turnOn(View view){
        Intent turnOn = new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);
        startActivityForResult(turnOn, 0);
    }

    public void getVisible(View view){
        Intent visible = new Intent(BluetoothAdapter.ACTION_REQUEST_DISCOVERABLE);
        startActivityForResult(visible,0);
    }
    public void list(View view){
        Set<BluetoothDevice> pairedDevices = BA.getBondedDevices();
        ArrayList list = new ArrayList();
        for(BluetoothDevice bt: pairedDevices) list.add(bt.getName());
        Toast.makeText(getApplicationContext(),"Showing Paired Devices",Toast.LENGTH_SHORT).show();
        final ArrayAdapter adapter = new ArrayAdapter(this,android.R.layout.simple_list_item_1,list);
        listView.setAdapter(adapter);
    }
    public void turnOf(View view){
        BA.disable();
        Toast.makeText(getApplicationContext(),"Turned Off",Toast.LENGTH_LONG).show();
    }
}
