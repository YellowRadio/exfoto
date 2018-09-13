package com.example.desenvolvedor.exfoto;

import android.content.Intent;
import android.graphics.Bitmap;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    private ImageView jimagem;
    private Button jbtnTirarFoto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        retiraFoto();
    }

    private void retiraFoto(){
        jimagem=findViewById(R.id.imagem);
        jbtnTirarFoto=findViewById(R.id.btnTiraFoto);
        jbtnTirarFoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(intent,0);
            }
        });

    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data){
        super.onActivityResult(requestCode,resultCode,data);
        Bundle bundle=data.getExtras();

        if(data!=null){
            Bitmap bitmap = (Bitmap)bundle.get("data");
            jimagem.setImageBitmap(bitmap);
        }
    }
}
