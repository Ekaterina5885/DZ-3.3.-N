package ru.netology.domain;

public class Radio {
    private String name;
    private int currentRadioStation;
    private int quantityRadioStation = 10;
    private int maxRadioStation = quantityRadioStation;
    private int minRadioStation = 0;
    private int currentVolume;
    private int maxVolume = 100;
    private int minVolume = 0;
    private boolean on;

    // Конструктор без параметров;
    public Radio() {
    }

    // Конструктора с одним параметром;
    public Radio(int quantityRadioStation) {
        this.quantityRadioStation = quantityRadioStation;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMinRadioStation() {
        return minRadioStation;
    }

//    public void setMinRadioStation(int minRadioStation) {
//        this.minRadioStation = minRadioStation;
//    }

    public int getMaxRadioStation() {
        return maxRadioStation;
    }

//    public void setMaxRadioStation(int maxRadioStation) {
//        this.maxRadioStation = maxRadioStation;
//    }

    public int getCurrentRadioStation() {
        return currentRadioStation;
    }

    //  Выбор текущей радиостанции.
    public void setCurrentRadioStation(int currentRadioStation) {
        if (currentRadioStation > maxRadioStation) {
            return;
        }
        if (currentRadioStation < minRadioStation) {
            return;
        }
        this.currentRadioStation = currentRadioStation;
    }

    //  Кнопка "Next";
    public void nextButton() {
        if (currentRadioStation == maxRadioStation) {
            this.currentRadioStation = minRadioStation;
            return;
        }
        this.currentRadioStation++;
    }

    //  Кнопка "Prev";
    public void prevButton() {
        if (currentRadioStation == minRadioStation) {
            this.currentRadioStation = maxRadioStation;
            return;
        }
        this.currentRadioStation--;
    }

    public int getMinVolume() {
        return minVolume;
    }

//    public void setMinVolume(int minVolume) {
//        this.minVolume = minVolume;
//    }

    public int getMaxVolume() {
        return maxVolume;
    }

//    public void setMaxVolume(int maxVolume) {
//        this.maxVolume = maxVolume;
//    }

    public int getCurrentVolume() {
        return currentVolume;
    }

    public void setCurrentVolume(int currentVolume) {
        this.currentVolume = currentVolume;
    }

    //    Кнопка "Плюс" (Уровень громкости);
    public void plusButton() {
        if (currentVolume == maxVolume) {
            return;
        }
        this.currentVolume++;
    }

    //    Кнопка "Минус" (Уровень громкости);
    public void minusButton() {
        if (currentVolume == minVolume) {
            return;
        }
        this.currentVolume--;
    }

    public boolean isOn() {
        return on;
    }

//    public void setOn(boolean on) {
//        this.on = on;
//    }
}