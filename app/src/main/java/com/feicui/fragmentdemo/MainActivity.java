package com.feicui.fragmentdemo;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.feicui.fragmentdemo.fragment.Fragment_One;
import com.feicui.fragmentdemo.fragment.Fragment_Three;
import com.feicui.fragmentdemo.fragment.Fragment_Two;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button btn_1,btn_2,btn_3;
    private Fragment_One fragment_one=new Fragment_One();
    private Fragment_Two fragment_two=new Fragment_Two();
    private Fragment_Three fragment_three=new Fragment_Three();
    private FragmentManager manager;
    private FragmentTransaction transaction;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn_1= (Button) findViewById(R.id.btn_1);
        btn_2= (Button) findViewById(R.id.btn_2);
        btn_3= (Button) findViewById(R.id.btn_3);
        //获取到Fragment管理器
        manager=getSupportFragmentManager();
        transaction=manager.beginTransaction();
        //定义一个默认的Fragment显示
        transaction.replace(R.id.frameLayout,fragment_one);
        transaction.commit();//务必记得提交
        btn_1.setEnabled(false);
        btn_1.setOnClickListener(this);
        btn_2.setOnClickListener(this);
        btn_3.setOnClickListener(this);
//        if (fragment_one.isAdded()){
//            btn_1.setEnabled(false);
//        }
//        if (fragment_two.isAdded()){
//            btn_2.setEnabled(false);
//        }
//        if (fragment_three.isAdded()){
//            btn_3.setEnabled(false);
//        }
    }

    @Override
    public void onClick(View view) {
        manager=getSupportFragmentManager();
        transaction=manager.beginTransaction();
        switch (view.getId()){
            case R.id.btn_1:
                transaction.replace(R.id.frameLayout,fragment_one);
                btn_1.setEnabled(false);
                btn_2.setEnabled(true);
                btn_3.setEnabled(true);
                break;
            case R.id.btn_2:
                transaction.replace(R.id.frameLayout,fragment_two);
                btn_2.setEnabled(false);
                btn_1.setEnabled(true);
                btn_3.setEnabled(true);
                break;
            case  R.id.btn_3:
                transaction.replace(R.id.frameLayout,fragment_three);
                btn_3.setEnabled(false);
                btn_1.setEnabled(true);
                btn_2.setEnabled(true);
                break;
        }
        transaction.commit();
    }
}
