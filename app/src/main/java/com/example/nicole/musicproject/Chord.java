package com.example.nicole.musicproject;

public class Chord {
    private String chord;
    private String type;

    public Chord(String chord, String type) {
        this.chord = chord;
        this.type = type;
    }

    public String getChord() {
        return chord;
    }

    public String getType() {
        return type;
    }
}
