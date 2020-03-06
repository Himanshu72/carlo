package com.swich.carlo;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import java.io.Serializable;

public class CarDesc extends AppCompatActivity {
ImageView img;
TextView model,company,desc;
Button book,chat;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_car_desc);
        Intent intent = getIntent();
        MyListData lis= (MyListData) getIntent().getSerializableExtra("cur");
        desc=(TextView)findViewById(R.id.desc);
        img=(ImageView)findViewById(R.id.img);
           model=(TextView) findViewById(R.id.model);
        company=(TextView) findViewById(R.id.company);

        book=(Button)findViewById(R.id.book);


       model.setText(lis.getModel());
        company.setText(lis.getCompany());
        desc.setText(lis.getDescription());

        Picasso.get().load(getString(R.string.host)+"/uploadedFiles/"+lis.getPath()+".JPG").into(img);

        final AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Enter Number Hour");
        final String[] m_Text = new String[1];
// Set up the input
        final EditText input = new EditText(this);
// Specify the type of input expected; this, for example, sets the input as a password, and will mask the text
        input.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
        builder.setView(input);

// Set up the buttons
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

                m_Text[0] = input.getText().toString();
                Intent i=new Intent(CarDesc.this,Dashboard.class);
                startActivity(i);
                finish();
            }
        });
        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });

        book.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                builder.show();
            }
        });

    }
}
