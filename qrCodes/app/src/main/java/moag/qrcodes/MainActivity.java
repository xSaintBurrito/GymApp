package moag.qrcodes;

import android.content.*;
import android.os.*;
import android.support.v7.app.AppCompatActivity;

// Tmp class for checking if QRCode functionalities are working
public class MainActivity extends AppCompatActivity
{
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Intent i = new Intent(this, GenerateQRCodeActivity.class);
        Intent i = new Intent(this, ScanQRCodeActivity.class);
        startActivity(i);
    }
}
