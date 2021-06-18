package ru.netology.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class RadioTest {

    Radio radio = new Radio(10);

    @Test
    public void shouldGetAndSetNameRadio() {
        Radio radio = new Radio();
        String expected = "Радио - Мир";

        assertNull(radio.getName());
        radio.setName(expected);
        assertEquals(expected, radio.getName());
    }

    @Test
    public void shouldGetAndSet() {
        assertEquals(0, radio.getMinRadioStation());
        assertEquals(10, radio.getMaxRadioStation());
        assertEquals(0, radio.getMinVolume());
        assertEquals(100, radio.getMaxVolume());
    }

    //  Текущая радиостанция в допустимом диапазоне;
    @Test
    public void currentRadioStation() {

        radio.setCurrentRadioStation(8);

        int expected = 8;
        int actual = radio.getCurrentRadioStation();
        assertEquals(expected, actual);
    }

    //  Текущая радиостанция выше граничного значения;
    @Test
    public void currentRadioStationAbovelimitValue() {

        radio.setCurrentRadioStation(11);

        int expected = 0;
        int actual = radio.getCurrentRadioStation();
        assertEquals(expected, actual);
    }

    //  Текущая радиостанция ниже граничного значения;
    @Test
    public void currentRadioStationBelowlimitValue() {

        radio.setCurrentRadioStation(-1);

        int expected = 0;
        int actual = radio.getCurrentRadioStation();
        assertEquals(expected, actual);
    }

    @Test
    //  Кнопка "Next".
    public void nextStationButton() {

        radio.nextButton();

        int expected = 1;
        int actual = radio.getCurrentRadioStation();
        assertEquals(expected, actual);
    }

    @Test
    //  Кнопка "Prev".
    public void prevStationButton() {

        radio.setCurrentRadioStation(8);
        radio.prevButton();

        int expected = 7;
        int actual = radio.getCurrentRadioStation();
        assertEquals(expected, actual);
    }

    @Test
    //  Следующая радиостанция выше максимальной;
    public void nextStationButtonAboveMaxRadioStation() {

        radio.setCurrentRadioStation(10);
        radio.nextButton();

        int expected = 0;
        int actual = radio.getCurrentRadioStation();
        assertEquals(expected, actual);
    }

    @Test
    //  Предыдущая радиостанция ниже минимальной;
    public void prevStationButtonBelowMinRadioStation() {

        radio.setCurrentRadioStation(-1);
        radio.prevButton();

        int expected = 10;
        int actual = radio.getCurrentRadioStation();
        assertEquals(expected, actual);
    }

    //  Текущий уровень громкости выше граничного значения;
    @Test
    void currentVolumeAbovelimitValue() {

        radio.setCurrentVolume(100);
        radio.plusButton();

        int expected = 100;
        int actual = radio.getCurrentVolume();
        assertEquals(expected, actual);
    }

    //  Текущий уровень громкости ниже граничного значения;
    @Test
    void setCurrentVolumeBelowlimitValue() {

        radio.minusButton();

        int expected = 0;
        int actual = radio.getCurrentVolume();
        assertEquals(expected, actual);
    }

    //    Переключение громкости звука вперед +1.
    @Test
    public void shouldSwitchVolumeForward() {

        radio.setCurrentVolume(4);
        radio.plusButton();

        int expected = 5;
        int actual = radio.getCurrentVolume();
        assertEquals(expected, actual);
    }

    //    Переключение громкости звука назад -1.
    @Test
    public void shouldSwitchVolumeBack() {

        radio.setCurrentVolume(4);
        radio.minusButton();

        int expected = 3;
        int actual = radio.getCurrentVolume();
        assertEquals(expected, actual);
    }

    @Test
    public void shouldRadioIsOn() {

        radio.isOn();

        assertFalse(radio.isOn());

    }
}