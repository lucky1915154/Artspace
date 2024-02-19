package com.example.artspace;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;
import android.view.View;

import com.example.artspace.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;
    private int[] artworks = {R.drawable.house, R.drawable.tiger, R.drawable.boat};
    private String[] title={"hand drawn ecological and futuristic building concepts generative ai","Ferocious tiger with leaves","Cubist illustration of malaga"};
    private int currentArtworkIndex = 0;
    private int currentTitleIndex = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main);

        binding.artworkImageView.setImageResource(artworks[currentArtworkIndex]);
        binding.title.setText(title[currentTitleIndex]);
        binding.previousButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showPreviousArtwork();
            }
        });

        binding.nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showNextArtwork();
            }
        });
    }

    private void showNextArtwork() {
        currentArtworkIndex = (currentArtworkIndex + 1) % artworks.length;
        currentTitleIndex=(currentTitleIndex+1)%title.length;
        binding.artworkImageView.setImageResource(artworks[currentArtworkIndex]);
        binding.title.setText(title[currentTitleIndex]);
    }

    private void showPreviousArtwork() {
        currentArtworkIndex = (currentArtworkIndex - 1 + artworks.length) % artworks.length;
        currentTitleIndex=(currentTitleIndex-1+ title.length)%title.length;
        binding.artworkImageView.setImageResource(artworks[currentArtworkIndex]);
        binding.title.setText(title[currentTitleIndex]);
    }
}