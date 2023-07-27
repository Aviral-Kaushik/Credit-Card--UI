package com.aviral.creditcard;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView.Adapter adapterContact;
    private RecyclerView recyclerViewContact;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initRecyclerView();
    }

    private void initRecyclerView() {

        ArrayList<ContactDomain> contactDomainArrayList = new ArrayList<>();

        contactDomainArrayList.add(new ContactDomain("David","user_1"));
        contactDomainArrayList.add(new ContactDomain("Harry","user_2"));
        contactDomainArrayList.add(new ContactDomain("Jack","user_3"));
        contactDomainArrayList.add(new ContactDomain("Sara","user_4"));
        contactDomainArrayList.add(new ContactDomain("Rose","user_5"));

        recyclerViewContact = findViewById(R.id.recycler_view);

        LinearLayoutManager llm = new LinearLayoutManager(
                this,
                LinearLayoutManager.HORIZONTAL,
                false
        );

        recyclerViewContact.setLayoutManager(llm);

        adapterContact = new ContactAdapter(contactDomainArrayList);

        recyclerViewContact.setAdapter(adapterContact);
    }
}