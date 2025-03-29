package com.example.vk11;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ContactListAdapter extends RecyclerView.Adapter<ContactViewHolder> {

    private ArrayList<Contact> contacts;
    public ContactListAdapter(ArrayList<Contact> contacts) {this.contacts = contacts;}


    @NonNull
    @Override
    public ContactViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.contact_view, parent, false);
        return new ContactViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ContactViewHolder holder, int position) {
        Contact contact = contacts.get(position);
        holder.ContactNameText.setText(contact.getFullName());
        holder.ContactNumberText.setText(contact.getNumber());
        holder.ContactGroupText.setText(contact.getContactGroup());

        holder.removeContact.setOnClickListener(v -> {
            int pos = holder.getAdapterPosition();
            ContactStorage.getInstance().removeContact(pos);
            notifyItemRemoved(pos);
        });

        holder.contactDetailsImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int pos = holder.getAdapterPosition();


                if(holder.ContactGroupText.getVisibility() == View.VISIBLE) {
                    holder.ContactGroupText.setVisibility(View.GONE);
                    holder.ContactNumberText.setVisibility(View.GONE);
                    notifyDataSetChanged();
                }
                else {
                    holder.ContactGroupText.setVisibility(View.VISIBLE);
                    holder.ContactNumberText.setVisibility(View.VISIBLE);
                    notifyDataSetChanged();
                }
            }
        });

    }

    @Override
    public int getItemCount() {
        return contacts.size();
    }
}
