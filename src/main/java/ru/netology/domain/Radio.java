package ru.netology.domain;

public class Radio {
    private String name;
    private int currentRadioStation;
    private int minRadioStation = 0;
    private int quantityRadioStation;
    private int currentVolume;
    private int maxVolume = 100;
    private int minVolume = 0;
    private boolean on;

    // Конструктора с одним параметром;
    public Radio(int quantityRadioStation) {
        this.quantityRadioStation = quantityRadioStation;
    }

    public Radio() {
        this.quantityRadioStation = 10;
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

    public int getQuantityRadioStation() {
        return quantityRadioStation;
    }

//    public void setQuantityRadioStation(int quantityRadioStation) {
//        this.quantityRadioStation = quantityRadioStation;
//    }

    public int getCurrentRadioStation() {
        return currentRadioStation;
    }

    //  Выбор текущей радиостанции.
    public void setCurrentRadioStation(int currentRadioStation) {
        this.currentRadioStation = currentRadioStation;
    }

    //  Кнопка "Next";
    public void nextButton() {
        if (currentRadioStation < quantityRadioStation) {
            this.currentRadioStation++;
        } else {
            currentRadioStation = minRadioStation;
        }
    }

    //  Кнопка "Prev";
    public void prevButton() {
        if (currentRadioStation > minRadioStation) {
            this.currentRadioStation--;
        } else {
            this.currentRadioStation = quantityRadioStation;
        }
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
        if (currentVolume < maxVolume) {
            currentVolume++;
        }
    }

    //    Кнопка "Минус" (Уровень громкости);
    public void minusButton() {
        if (currentVolume > minVolume) {
            currentVolume--;
        }
    }

    public boolean isOn() {
        return on;
    }

//    public void setOn(boolean on) {
//        this.on = on;
//    }
}