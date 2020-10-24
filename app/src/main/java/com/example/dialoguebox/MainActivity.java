package com.example.dialoguebox;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.app.Dialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class MainActivity extends AppCompatActivity{
     Button button;
     FloatingActionButton fabMain;
     Boolean isClicked = true;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fabMain = (FloatingActionButton)findViewById(R.id.floatingActionButton2);

        fabMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(isClicked){
                    isClicked=false;
                    fabMain.setImageDrawable(ContextCompat.getDrawable(MainActivity.this, R.drawable.ic_baseline_close_24));
                    PopupMenu popupMenu = new PopupMenu(MainActivity.this,fabMain);
                    popupMenu.getMenuInflater().inflate(R.menu.pop_up, popupMenu.getMenu());
                    popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                        @Override
                        public boolean onMenuItemClick(MenuItem item) {

                            Toast.makeText(MainActivity.this, ""+item.getTitle(), Toast.LENGTH_SHORT).show();
                            return true;

                        }
                    });
                    popupMenu.show();

                      }
                else{
                    fabMain.setImageDrawable(ContextCompat.getDrawable(MainActivity.this, R.drawable.ic_baseline_add_24));
                    isClicked=true;

                }

            }
        });



        button= (Button)findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Dialog dialog = new Dialog(MainActivity.this);
                dialog.setContentView(R.layout.dialog_view);
                Button cancel = dialog.findViewById(R.id.btnCancel);
//                Button orderHold = dialog.findViewById(R.id.btnOrderHold);
//                Button orderDelivered = dialog.findViewById(R.id.btnOD);
//                Button orderTrash = dialog.findViewById(R.id.btnOT);

                cancel.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialog.dismiss();
                    }
                });
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                dialog.show();
            }
        });

    }

}