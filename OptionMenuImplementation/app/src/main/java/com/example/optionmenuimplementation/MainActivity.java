package com.example.optionmenuimplementation;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.option, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId())
        {
            case R.id.share:
                Intent sendIntent = new Intent();
                sendIntent.setAction(Intent.ACTION_SEND);
                sendIntent.putExtra(Intent.EXTRA_TEXT, "Hello! How are you?");
                sendIntent.setType("text/plain");

                Intent shareIntent = Intent.createChooser(sendIntent, "My Share");
                startActivity(shareIntent);
                return true;
            case R.id.dial:
                Uri uri = Uri.parse("tel:1234567890");
                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(uri);
                startActivity(intent);
                return true;
            case R.id.gallery:
                Intent intent1 = new Intent();
                intent1.setAction(Intent.ACTION_GET_CONTENT);
                intent1.setType("image/*");
                intent1.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent1);
                return true;
            case R.id.browser:
                Uri uri1 = Uri.parse("https://google.com");
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(uri1);
                startActivity(i);
                return true;
            default:
                return false;
        }
    }
}