package ru.netology.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class Radio {
    private String name;
    private int currentRadioStation;
    private int maxRadioStation = 10;
    private int minRadioStation = 0;
    private int currentVolume;
    private int maxVolume = 100;
    private int minVolume = 0;
    private boolean on;


    //  Кнопка "Next";
    public void nextButton() {
        if (currentRadioStation < maxRadioStation) {
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
            this.currentRadioStation = maxRadioStation;
        }
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

}