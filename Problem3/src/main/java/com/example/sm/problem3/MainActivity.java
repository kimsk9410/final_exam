package com.example.sm.problem3;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Random;
import java.util.RandomAccess;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ArrayList<CustomerThread> list = new ArrayList<CustomerThread>();
        Manager manager = new Manager();

        for(int i = 0 ; i < 10 ; i++){
            Customer customer = new Customer("Customer" + i);
            CustomerThread ct = new CustomerThread(customer);
            list.add(ct);
            manager.add_customer(customer);
            ct.start();
        }


        for(CustomerThread ct : list){

            try {
                // need something here
                ct.sleep(1000);
            } catch (InterruptedException e) { }
        }

        manager.sort();

        MyBaseAdapter adapter = new MyBaseAdapter(this, manager.list);
        ListView listview = (ListView) findViewById(R.id.listView1) ;
        listview.setAdapter(adapter);
    }
}

class CustomerThread extends Thread{

    Customer customer;

    CustomerThread(Customer customer){
        this.customer = customer;
    }
    // need something here


    @Override
    public synchronized void run() {
        super.run();
        customer.work();
    }
}

abstract class Person{

    static int money = 100000;
    int spent_money = 0;
    abstract void work();

}


class Customer extends Person{

    String name;
    Customer(String name){
        this.name = name;
    }

    // need something here
    void work(){
        Random rd = new Random();
        int sp_money = rd.nextInt(1000);
        spent_money += sp_money;
        money -= sp_money;
    }
}


class Manager extends Person{
    ArrayList <Customer> list = new ArrayList<Customer>();
    Customer temp_customer = new Customer("");

    void add_customer(Customer customer) {
        list.add(customer);
    }

    void sort(){ // 직접 소팅 알고리즘을 이용하여 코딩해야함. 자바 기본 정렬 메소드 이용시 감

        // need something here
        for(int i = 0; i < list.size()-1; i++){
            for(int j = 1; j < list.size()-i; j++){
                if(list.get(j-1).spent_money > list.get(j).spent_money){
                    temp_customer.spent_money = list.get(j).spent_money;
                    temp_customer.name = list.get(j).name;
                    list.get(j).spent_money = list.get(j-1).spent_money;
                    list.get(j).name = list.get(j-1).name;
                    list.get(j-1).spent_money = temp_customer.spent_money;
                    list.get(j-1).name = temp_customer.name;
                }
            }
        }

    }

    @Override
    void work() {
        sort();
    }
}

// need something here

