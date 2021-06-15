package com.example.notes;

abstract class theNote {
    private String name;
    private String date;
    private String color;
    private String text;

    public theNote(String name, String date, String color, String text) {
        this.name = name;
        this.date = date;
        this.color = color;
        this.text = text;
    }

}
