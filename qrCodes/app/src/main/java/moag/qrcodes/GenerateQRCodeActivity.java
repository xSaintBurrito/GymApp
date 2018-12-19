package moag.qrcodes;

import android.*;
import android.content.pm.*;
import android.graphics.*;
import android.media.*;
import android.os.*;
import android.support.annotation.*;
import android.support.v4.app.*;
import android.support.v7.app.AppCompatActivity;
import android.util.*;

import com.google.zxing.*;
import com.google.zxing.common.*;
import com.google.zxing.qrcode.*;
import com.google.zxing.qrcode.decoder.*;

import java.io.*;
import java.util.*;

import static android.os.Build.VERSION.SDK_INT;

public class GenerateQRCodeActivity extends AppCompatActivity
{
    private static final int SAVE_REQUEST_CODE = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        
        if(checkPermission()) generateQRCode();
        else
        {
            String[] permissionRequested = {Manifest.permission.WRITE_EXTERNAL_STORAGE};

            if(SDK_INT >= 23) requestPermissions(permissionRequested, SAVE_REQUEST_CODE);
            else ActivityCompat.requestPermissions(this, permissionRequested, SAVE_REQUEST_CODE);
        }
    }

    private void generateQRCode()
    {
        String text = "Test";
        int size = 125;
        try
        {
            Bitmap bitmap = createQRImage(text, size);
            saveImageToExternalStorage(bitmap);
        }
        catch(WriterException e)
        {
            e.printStackTrace();
        }
    }

    private void saveImageToExternalStorage(Bitmap finalBitmap)
    {
        String root = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES).toString();

        File myDir = new File(root + "/saved_images");
        myDir.mkdirs();
        Random random = new Random();
        int n = random.nextInt(1000);
        String fname = "Image-" + n + ".jpg";
        File file = new File(myDir, fname);
        if(file.exists()) file.delete();
        try
        {
            FileOutputStream out = new FileOutputStream(file);
            finalBitmap.compress(Bitmap.CompressFormat.PNG, 100, out);
            out.flush();
            out.close();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }

        MediaScannerConnection.scanFile(this, new String[] { file.toString() }, null,
                (path, uri) -> {
                    Log.i("ExternalStorage", "Scanned " + path + ":");
                    Log.i("ExternalStorage", "-> uri=" + uri);
                });
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults)
    {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        if(requestCode == SAVE_REQUEST_CODE)
        {
            if(grantResults[0] == PackageManager.PERMISSION_GRANTED) generateQRCode();
            //else
            // ADD POPUP TEXT
            // Toast.makeText(this, getString(R.string.cannot_use_camera_without_permission), Toast.LENGTH_LONG).show();
        }
    }

    private boolean checkPermission()
    {
        Log.d("QRCodesComponent", "checking save permission");
        int res = getApplicationContext().checkCallingOrSelfPermission(Manifest.permission.WRITE_EXTERNAL_STORAGE);
        return (res == PackageManager.PERMISSION_GRANTED);
    }

    public static Bitmap createQRImage(String text, int size) throws WriterException
    {
        Hashtable<EncodeHintType, ErrorCorrectionLevel> hintMap = new Hashtable<>();
        hintMap.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.L);
        QRCodeWriter qrCodeWriter = new QRCodeWriter();
        BitMatrix bitMatrix = qrCodeWriter.encode(text, BarcodeFormat.QR_CODE, size, size, hintMap);

        int width = bitMatrix.getWidth();
        int height = bitMatrix.getHeight();
        Bitmap bmp = Bitmap.createBitmap(width, height, Bitmap.Config.RGB_565);
        for(int x = 0; x < width; x++)
        {
            for(int y = 0; y < height; y++)
            {
                bmp.setPixel(x, y, bitMatrix.get(x, y) ? Color.BLACK : Color.WHITE);
            }
        }

        return bmp;
    }
}
