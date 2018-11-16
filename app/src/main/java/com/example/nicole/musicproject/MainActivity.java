package com.example.nicole.musicproject;

import android.app.AlertDialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Layout;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.NumberPicker;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    List<Chord> chords = new ArrayList<>();
    List<Integer> button_ids = Arrays.asList(R.id.chord_one, R.id.chord_two, R.id.chord_three, R.id.chord_four);
    int curr_chord;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void showChords(View view){
        curr_chord = button_ids.indexOf(view.getId());
        showChordDialogue((Button) view);
    }


    private void showChordDialogue(final Button button){
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        View view = getLayoutInflater().inflate(R.layout.view_chords, null);

        builder.setView(view);
        final AlertDialog dialog = builder.create();
//        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));

        dialog.show();

        final String[] array_chords = new String[]{"C", "D", "E", "F", "G", "A", "B"};
        final String[] array_types = new String[]{"maj", "min"};

        final NumberPicker picker_chords = dialog.findViewById(R.id.numpick_chords);
        picker_chords.setMinValue(0);
        picker_chords.setMaxValue(6);
        picker_chords.setDisplayedValues(array_chords);

        final NumberPicker picker_type = dialog.findViewById(R.id.numpick_types);
        picker_type.setMinValue(0);
        picker_type.setMaxValue(1);
        picker_type.setDisplayedValues(array_types);

        Button enterChord = dialog.findViewById(R.id.button_chords);

        enterChord.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Chord chord = new Chord(array_chords[picker_chords.getValue()], array_types[picker_type.getValue()]);
                chords.add(chord);
//                Log.d("current chord", "chord " + chords.get(curr_chord).getChord() + curr_chord);
                button.setText(chord.getChord() + chord.getType());
                dialog.dismiss();
            }
        });


    }
}
