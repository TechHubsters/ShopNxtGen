package com.example.shopnxtgen;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Toast;

import com.example.shopnxtgen.databinding.ActivityAddProductBinding;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import java.util.UUID;

public class addProductActivity extends AppCompatActivity {
    ActivityAddProductBinding binding;
    private String Pro_description, Pro_price, Pro_name, id;
    private Uri uri;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityAddProductBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        // this activity is for adding product from the seller shop

        binding.btinAddProduct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Pro_name = binding.productName.getText().toString();
                Pro_description = binding.ProductDescription.getText().toString();
                Pro_price = binding.ProductPrise.getText().toString();
                //addProduct();
            }
        });
        binding.productImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
                intent.setType("image/*");
                startActivityForResult(intent ,100);
            }
        });

      binding.btinUploadImg.setOnClickListener(new View.OnClickListener() {
            @Override
          public void onClick(View view) {
                uploadImg();
           }


        });

    }
    // functions

    private void uploadImg() {
        StorageReference storageReference = FirebaseStorage.getInstance().getReference("Products/"+id+".png");
        storageReference.putFile(uri)
                .addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                    @Override
                    public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                        storageReference.getDownloadUrl()
                                .addOnSuccessListener(new OnSuccessListener<Uri>() {
                                    @Override
                                    public void onSuccess(Uri uri) {
                                        FirebaseFirestore.getInstance()
                                                .collection("Products")
                                                .document(id)
                                                .update("image",uri.toString());

                                        Toast.makeText(addProductActivity.this, "Done img updateS", Toast.LENGTH_SHORT).show();
                                    }
                                });
                    }
                });

    }
    private void addProduct() {
        // to add product

        id = UUID.randomUUID().toString();
        ProductModel productModel = new ProductModel(id, Pro_name, Pro_description, null, true);
        FirebaseFirestore.getInstance()
                .collection("Products")
                .document(id)
                .set(productModel);


        Toast.makeText(this, "product added", Toast.LENGTH_SHORT).show();

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == 100){
            uri = data.getData();
            binding.productImg.setImageURI(uri);
        }
    }
    }
}