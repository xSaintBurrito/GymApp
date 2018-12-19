package moag.qrcodes;

import android.content.*;
import android.os.*;
import android.support.v7.app.*;
import android.util.*;

import com.google.zxing.integration.android.*;

public class ScanQRCodeActivity extends AppCompatActivity
{
    public static final String RESPONSE = "Response";

    private String qrCodeData;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        scanQRCode();

        prepareResponse();
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent intent)
    {
        IntentResult scanResult = IntentIntegrator.parseActivityResult(requestCode, resultCode, intent);
        if (scanResult != null)
        {
            qrCodeData = scanResult.getContents();
            Log.d("QRCodesComponent", "QRCode content: " + qrCodeData);
        }
    }

    private void scanQRCode()
    {
        IntentIntegrator integrator = new IntentIntegrator(this);
        integrator.initiateScan(IntentIntegrator.QR_CODE_TYPES);
    }

    private void prepareResponse()
    {
        Intent resultIntent = new Intent();
        resultIntent.putExtra(RESPONSE, qrCodeData);
        setResult(RESULT_OK, resultIntent);
    }
}
