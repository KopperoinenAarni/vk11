package com.example.vk11;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.ListIterator;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private ContactListAdapter adapter;
    private ArrayList<Contact> contacts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        recyclerView = findViewById(R.id.ListContactsRV);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        contacts = ContactStorage.getInstance().getContacts();
        adapter = new ContactListAdapter(contacts);
        recyclerView.setAdapter(adapter);
    }

    public void switchToAddContactActivity(View view) {
        Intent intent = new Intent(this, AddContactActivity.class);
        startActivity(intent);
    }



    @Override
    protected void onResume() {
        super.onResume();
        contacts = ContactStorage.getInstance().getContacts();
        if (adapter != null) {
            adapter.notifyDataSetChanged();
        }
    }

    public void sortAlphabetically(View view) {
        ArrayList<Contact> contacts = ContactStorage.getInstance().getContacts();
        Collections.sort(contacts, new Comparator<Contact>() {
            @Override
            public int compare(Contact c1, Contact c2) {
                return c1.getFullName().compareToIgnoreCase(c2.getFullName());
            }
        });
        adapter.notifyDataSetChanged();
    }

    public void sortByGroup(View view) {
        ArrayList<Contact> contacts = ContactStorage.getInstance().getContacts();

        ArrayList<Contact> workContacts = new ArrayList<>();
        ArrayList<Contact> personalContacts = new ArrayList<>();

        Iterator<Contact> iterator = contacts.iterator();
        while (iterator.hasNext()) {
            Contact contact = iterator.next();
            if (contact.getContactGroup().equalsIgnoreCase("Työ")) {
                workContacts.add(contact);
            } else if (contact.getContactGroup().equalsIgnoreCase("Henkilökohtainen")) {
                personalContacts.add(contact);
            }
        }
        contacts.clear();
        contacts.addAll(workContacts);
        contacts.addAll(personalContacts);


        adapter.notifyDataSetChanged();
    }

}


