package com.example.bai2;


import android.app.Activity;
import android.app.Dialog;
import android.bluetooth.BluetoothAdapter;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends Activity {
    Button exit,bttudong,bttuychinh,nhan1;
    BluetoothAdapter myBluetooth ;
   // static final UUID myUUID = UUID.fromString("00001101-0000-1000-8000-00805F9B34FB");
    @Override
    protected void onCreate(final Bundle savedInstanceState)
    {
        bttudong = (Button) findViewById(R.id.bttudong);
        bttuychinh = (Button) findViewById(R.id.bttuychinh);
        myBluetooth = BluetoothAdapter.getDefaultAdapter();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ///////////////////////////////////
        if(myBluetooth == null)
        {}
        if ( !myBluetooth.isEnabled())
        {
            Dialog dialog = new Dialog(this);
            dialog.setContentView(R.layout.dialog);
            dialog.setTitle("Thông Báo!");

            exit = (Button) dialog.findViewById(R.id.exit);
            exit.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    moveTaskToBack(true);
                    android.os.Process.killProcess(android.os.Process.myPid());
                    System.exit(1);
                }
            });
            dialog.show();
        }
        onclickk();
    }


    public void onclickk()
    {
        bttudong.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {

                Dialog mdialog = new Dialog(MainActivity.this);
                mdialog.setTitle("May Tu Pha");
                mdialog.setContentView(R.layout.tudong);
                nhan1 = (Button) mdialog.findViewById(R.id.n1);
                nhan1.setOnClickListener(new View.OnClickListener()
                        {
                    @Override
                    public void onClick(View v)
                    {
                        Toast.makeText(getApplicationContext(),"sddsdsds",Toast.LENGTH_SHORT).show();
                    }
                });
                mdialog.show();
            }
        });
    }
}



