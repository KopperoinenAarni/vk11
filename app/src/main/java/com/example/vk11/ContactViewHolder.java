package com.example.vk11;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ContactViewHolder extends RecyclerView.ViewHolder {
    TextView ContactNameText, ContactNumberText, ContactGroupText;
    ImageView contactImage, removeContact, contactDetailsImage;


    public ContactViewHolder(@NonNull View itemView) {
        super(itemView);
        ContactNameText = itemView.findViewById(R.id.ContactNameText);
        ContactNumberText = itemView.findViewById(R.id.ContactNumberText);
        ContactGroupText = itemView.findViewById(R.id.ContactGroupText);
        contactDetailsImage = itemView.findViewById((R.id.ContactDetailsButton));
        removeContact = itemView.findViewById((R.id.ContactDeleteButton));
        contactImage = itemView.findViewById((R.id.ContactImage));
    }
}
