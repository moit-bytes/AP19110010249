package com.example.contextmenu;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.ActionMode;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView tv1, tv2, tv3, tv4;
    Button b1;
    private ActionMode mActionMode;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv1 = findViewById(R.id.sch_1);
        tv2 = findViewById(R.id.sch_2);
        tv3 = findViewById(R.id.sch_3);
        tv4 = findViewById(R.id.sch_4);
        b1 = findViewById(R.id.button);

        b1.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                if (mActionMode != null)
                    return false;
                mActionMode = MainActivity.this.startActionMode(mActionModeCallback);
                b1.setSelected(true);
                return true;

            }
        });

        registerForContextMenu(tv1);
        registerForContextMenu(tv2);
        registerForContextMenu(tv3);
        registerForContextMenu(tv4);



    }

    public ActionMode.Callback mActionModeCallback = new ActionMode.Callback() {
        @Override
        public boolean onCreateActionMode(ActionMode mode, Menu menu) {
            MenuInflater inflater = mode.getMenuInflater();
            inflater.inflate(R.menu.menu_action_bar, menu);
            return true;

        }

        @Override
        public boolean onPrepareActionMode(ActionMode mode, Menu menu) {
            return false;
        }

        @Override
        public boolean onActionItemClicked(ActionMode mode, MenuItem item) {
            switch (item.getItemId()) {
                case R.id.copy:
                    Toast.makeText(MainActivity.this, "Text Copied", Toast.LENGTH_SHORT).show();
                    return true;
                case R.id.share:
                    Toast.makeText(MainActivity.this, "Item can be shared", Toast.LENGTH_SHORT).show();
                    return true;
                case R.id.edit:
                    Toast.makeText(MainActivity.this, "You can edit the text", Toast.LENGTH_SHORT).show();
                    return true;
                default:
                    return false;
            }

        }

        @Override
        public void onDestroyActionMode(ActionMode mode) {
            mActionMode = null;
        }
    };

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId())
        {
            case R.id.option1:
                Toast.makeText(this, "Getting Admission", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.option2:
                Toast.makeText(this, "Getting News", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.option3:
                Toast.makeText(this, "Getting details of the school", Toast.LENGTH_SHORT).show();
                return true;
            default:
                return false;
        }
    }
}