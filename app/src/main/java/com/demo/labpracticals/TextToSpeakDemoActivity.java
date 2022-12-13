package com.demo.labpracticals;

import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Locale;

public class TextToSpeakDemoActivity extends AppCompatActivity {

    private TextToSpeech tts;
    private final String[] languages = {
            "English",
            "UK",
            "French",
            "German",
            "Italy",
            "Chinese"};
    private final Locale[] speakLocalTypeList = {Locale.ENGLISH, Locale.UK, Locale.FRENCH, Locale.GERMAN, Locale.ITALY, Locale.SIMPLIFIED_CHINESE};
    private final Float[] speakRateList = {0.25f, 0.50f, 0.75f, 1f, 1.25f, 1.50f, 1.75f, 2f};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_text_to_speak_demo);

        ArrayAdapter<String> languageSelector = new ArrayAdapter<>(this, android.R.layout.simple_list_item_activated_1, languages);
        ArrayAdapter<Float> rateSelector = new ArrayAdapter<>(this, android.R.layout.simple_list_item_activated_1, speakRateList);

        Spinner lSpinner = findViewById(R.id.speakType);
        Spinner rSpinner = findViewById(R.id.speakRate);

        lSpinner.setAdapter(languageSelector);
        rSpinner.setAdapter(rateSelector);
        rSpinner.setSelection(3);


        tts = new TextToSpeech(this, status -> {
            if(status != TextToSpeech.ERROR){
                tts.setLanguage(Locale.UK);
                tts.setPitch(0.01f);
                tts.setSpeechRate(2f);
            }
        });

        findViewById(R.id.speak).setOnClickListener(v -> {
            EditText et = findViewById(R.id.sample);
            if(et.getText().toString().isEmpty()){
                Toast.makeText(TextToSpeakDemoActivity.this, "please enter some text", Toast.LENGTH_SHORT).show();
            }

            float currentRate = Float.parseFloat(rSpinner.getSelectedItem().toString());

            tts.setLanguage(speakLocalTypeList[(int) lSpinner.getSelectedItemId()]);
            tts.setSpeechRate(currentRate);

            tts.speak(et.getText().toString(), TextToSpeech.QUEUE_FLUSH, savedInstanceState, null);
        });
    }

    @Override
    public void onPause(){
        if(tts !=null){
            tts.stop();
            tts.shutdown();
        }
        super.onPause();
    }
}