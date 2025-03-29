package com.example.vk11;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class AddContactActivity extends AppCompatActivity {

    private EditText FirstNameEdit;
    private EditText LastNameEdit;
    private EditText PhoneNumberEdit;
    private RadioGroup ContactTypeRadioGroup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_add_contact);

        FirstNameEdit = findViewById(R.id.FirstNameEdit);
        LastNameEdit = findViewById(R.id.LastNameEdit);
        PhoneNumberEdit = findViewById(R.id.PhoneNumberEdit);
        ContactTypeRadioGroup = findViewById(R.id.ContactTypeRadioGroup);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    public void switchToMainActivity(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    public void addContactButton(View view) {
        String firstName = FirstNameEdit.getText().toString().trim();
        String lastName = LastNameEdit.getText().toString().trim();
        String phoneNumber = PhoneNumberEdit.getText().toString().trim();
        int selectedId = ContactTypeRadioGroup.getCheckedRadioButtonId();
        if (selectedId == -1) {
            Toast.makeText(this, "Valitse yhteystyyppi", Toast.LENGTH_SHORT).show();
            return;
        }

        RadioButton selectedRadioButton = findViewById(selectedId);
        String contactGroup = selectedRadioButton.getText().toString();
        Contact newContact = new Contact(firstName, lastName, phoneNumber, contactGroup);
        ContactStorage.getInstance().addContact(newContact);

    }

}