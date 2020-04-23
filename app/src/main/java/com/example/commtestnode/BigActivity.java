package com.example.commtestnode;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.commtestnode.ui.big.ActionItem;
import com.example.commtestnode.ui.big.BigTestFrag;

import java.util.ArrayList;

public class BigActivity extends AppCompatActivity {


    static ArrayList < ArrayList<ActionItem> > testDataSets;
    int setNum = 3;
    LinearLayout fragContainerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_big);

        fragContainerLayout = findViewById(R.id.frag_container);

        testDataSets = testDataSets == null ? initTestData() : testDataSets;

        FragmentManager FM  = getSupportFragmentManager();

        for(int i = 0; i<setNum ; i++) {
            FM.beginTransaction().add(R.id.frag_container, BigTestFrag.newInstance( testDataSets.get(i) ), "frag_" + i).commit();
        }


    }
    public ArrayList<ArrayList<ActionItem>> initTestData(){
        ArrayList<ArrayList<ActionItem>> narr = new ArrayList<ArrayList<ActionItem>>();
        for(int i = 0; i<setNum; i++){
            narr.add( generateTestData(i) );
        }
        return narr;
    }
    public ArrayList<ActionItem> generateTestData(int l){
        ArrayList<ActionItem> newActI = new ArrayList<>();
        for (int i = 0 ; i<l ;i++){
            newActI.add( new ActionItem( "T"+l+i , "A"+l+i , "C"+l+i  ) );
        }
        return newActI;
    }

    public void toaster(View v){
        String msg = ""+testDataSets.size();
        for (ArrayList<ActionItem> ai :testDataSets
             ) {
            msg += ai.size()+ " : ";
        }
        Toast.makeText(this, "sizes:"+msg , Toast.LENGTH_SHORT).show();
    }
}
