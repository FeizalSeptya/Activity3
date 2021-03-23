package com.example.pertemuan_kedua_event;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.pertemuan_kedua_event.R;

public class MainActivity extends AppCompatActivity {
    //Deklarasi variabel untuk button
    Button btnLogin;

    //Deklarasi variabel untuk EditText
    EditText edEmail, edPassword;

    //Deklarasi variabel untuk menyimpan email dan password
    String nama, password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Menghubungkan variabel btnLogin dengan componen button pada layout
        btnLogin = findViewById(R.id.btSignin);

        //Menghubungkan variabel edemail dengan componen button pada layout
        edEmail = findViewById(R.id.edEmail);

        //Menghubungkan variabel edpassword dengan componen button pada layout
        edPassword = findViewById(R.id.edPassword);

        //membuat fungsi onclick pada button btnLogin
        btnLogin.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                String Email = edEmail.getText().toString();
                String Password = edPassword.getText().toString();
                if (Email.equals("admin@mail.com") && Password.equals("123")) {
                    Toast.makeText(getApplicationContext(), "Login Sukses", Toast.LENGTH_LONG).show();

                    //menyimpan input user di edittext email kedalam variabel nama
                    nama = edEmail.getText().toString();

                    //menyimpan input user di edittext password kedalam variabel password
                    password = edPassword.getText().toString();

                    //mengeset email yang benar
                    String email = "admin@mail.com";

                    //mengeset password yang benar
                    String pass = "123";

                    //membuat variabel toast dan membuat toast dengan menambahkan variabel nama dan password
                    Toast t = Toast.makeText(getApplicationContext(),
                            "email anda: " + nama + " dan Password anda: " + password + "", Toast.LENGTH_LONG);
                    //menampilkan toast
                    t.show();

                    //Membuat objek bundle
                    Bundle b = new Bundle();

                    //memasukkan value dari variabel nama dengan kunci "a"
                    //dan dimasukkan kedalam bundle
                    b.putString("a", nama.trim());

                    //memasukkan value dari variabel password dengan kunci "b"
                    //dan dimasukkan kedalam bundle
                    b.putString("b", password.trim());

                    //membuat objek intent berpindah activity dari mainactivity ke ActivityHasil
                    Intent i = new Intent(getApplicationContext(), ActivityHasil2.class);

                    //memasukkan bundle kedalam intent untuk dikirimkan ke ActivityHasil
                    i.putExtras(b);

                    //berpindah ke ActivityHasil
                    startActivity(i);
                } else if (!Email.equals("admin@mail.com") && Password.equals("123")) {
                    Toast.makeText(getApplicationContext(),
                            "Email Salah", Toast.LENGTH_LONG).show();
                } else if (Email.equals("admin@mail.com") && !Password.equals("123")) {
                    Toast.makeText(getApplicationContext(),
                            "Password Salah", Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(getApplicationContext(),
                            "Email dan Password salah", Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //Method untuk menampilkan menu.
        getMenuInflater().inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        //Membuat kondisi jika yang dipilih adalah id mDaftar
        if (item.getItemId() == R.id.mnDaftar) {
            //Method untuk memanggil activity "DaftarActivity"
            Intent i = new Intent(getApplicationContext(), DaftarActivity.class);
            startActivity(i);
        }
        return super.onOptionsItemSelected(item);
    }
}


