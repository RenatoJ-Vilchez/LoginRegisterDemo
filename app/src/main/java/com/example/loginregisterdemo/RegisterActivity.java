package com.example.loginregisterdemo;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity {
    //Public Class RegisterActivity that will correspond with the register XML design file
    private EditText firstNameField,
            lastNameField,
            dobField,
            emailField,
            passwordField;
    //    Declaration of the fields for First Name, Last Name, Date of Birth (DOB), Email and Password
    private Button regButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        firstNameField = (EditText) findViewById(R.id.firstNameField);
        lastNameField = (EditText) findViewById(R.id.lastNameField);
        dobField = (EditText) findViewById(R.id.dobField);
        emailField = (EditText) findViewById(R.id.emailField);
        passwordField = (EditText) findViewById(R.id.passwordField);
        regButton = (Button) findViewById(R.id.regButton);

        regButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String fName = firstNameField.getText().toString().trim();
                String lName = lastNameField.getText().toString().trim();
                String dob = dobField.getText().toString().trim();
                String email = emailField.getText().toString().trim();
                String password = passwordField.getText().toString().trim();

                if(TextUtils.isEmpty(fName) || TextUtils.isEmpty(lName) || TextUtils.isEmpty(dob) || TextUtils.isEmpty(email) || TextUtils.isEmpty(password))
                {
                    Toast.makeText(RegisterActivity.this, "All fields are mandatory!", Toast.LENGTH_SHORT).show();
                    return;
                }
// In the case the user forgets to add information to one of the required boxes, then there will be an indication that tells the user that all boxes
//                are  to be filled out or the register information will not go through




//                As a requirement, there is a limit of the first and last name in characters. This will check if the user is within the limit or not
                if(fName.length() < 3 || fName.length() > 30)
                {
                    Toast.makeText(RegisterActivity.this, "Your first name must be 3-30 characters long!", Toast.LENGTH_SHORT).show();
                    return;
                }
                if(lName.length() < 3 || lName.length() > 30)
                {
                    Toast.makeText(RegisterActivity.this, "Your last name must be 3-30 characters long!", Toast.LENGTH_SHORT).show();
                    return;
                }


                String emailRegex = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";
                if(!email.matches(emailRegex))
                {
                    Toast.makeText(RegisterActivity.this, "Invalid Email Address!", Toast.LENGTH_SHORT).show();
                    return;
                }
//                Validations of email, including an indication that the email address is not valid



                //Once the user has entered all of their information, they will be shown a message that displays their register
//                account and the information that has been gathered, including first name, last name, and password

                String userDetails = "Name: " + fName + " " + lName + "\n" +
                        "Date of birth: " + dob + "\n" +
                        "Email: " + email + "\n" +
                        "Password: " + password;
                AlertDialog alertDialog = new AlertDialog.Builder(RegisterActivity.this).create();
                alertDialog.setTitle("Information of new User");

//                The user information that has been registered
                alertDialog.setMessage(userDetails);
                alertDialog.setButton(AlertDialog.BUTTON_POSITIVE, "OK", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        startActivity(new Intent(RegisterActivity.this, RegisterActivity.class));
                        finish();

//                        Finally, after seeing the information, the user can select the OK button to return to the options demo page
//                        where they can finally go to register to their account
                    }
                });
                alertDialog.show();
            }
        });
    }
}