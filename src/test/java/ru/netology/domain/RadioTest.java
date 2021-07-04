package ru.netology.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class RadioTest {

    Radio radio = new Radio();

    @Test
    public void shouldGetAndSetNameRadio() {

        String expected = "Радио - Мир";

        assertNull(radio.getName());
        radio.setName(expected);
        assertEquals(expected, radio.getName());
    }

    @Test
    public void shouldGetAndSet() {

        assertEquals(0, radio.getMinRadioStation());
        assertEquals(9, radio.getQuantityRadioStation());
        assertEquals(0, radio.getMinVolume());
        assertEquals(100, radio.getMaxVolume());
    }

    //  Количество радиостанций 9. Переключение с последней станции на следующую;
    @Test
    public void shouldSwitchNextStation () {

        Radio radio = new Radio(9);
        radio.setCurrentRadioStation(10);
        radio.nextButton();

        int expected = 0;
        int actual = radio.getCurrentRadioStation();
        assertEquals(expected, actual);
    }

    //  Количество радиостанций 8. Кнопка "Next".
    @Test
    public void shouldSwitchNextButton() {

        Radio radio = new Radio(8);
        radio.setCurrentRadioStation(6);
        radio.nextButton();

        int expected = 7;
        int actual = radio.getCurrentRadioStation();
        assertEquals(expected, actual);
    }

    //  Количество радиостанций 15. Текущая радиостанция ниже граничного значения;
    @Test
    public void shouldSwitchRadioStationBelowLimitValue() {

        Radio radio = new Radio(15);
        radio.setCurrentRadioStation(-1);
        radio.prevButton();

        int expected = 15;
        int actual = radio.getCurrentRadioStation();
        assertEquals(expected, actual);
    }

    //  Количество радиостанций 0. Увеличение текущей радиостанции.
    @Test
    public void shouldIncreaseRadioStation() {

        Radio radio = new Radio(0);
        radio.setCurrentRadioStation(6);
        radio.nextButton();

        int expected = 0;
        int actual = radio.getCurrentRadioStation();
        assertEquals(expected, actual);
    }

    //  Количество радиостанций -1. Увеличение текущей радиостанции.
    @Test
    public void shouldSwitchNextRadioStationsNegativeNumber() {

        Radio radio = new Radio(-1);
        radio.setCurrentRadioStation(8);
        radio.nextButton();

        int expected = 0;
        int actual = radio.getCurrentRadioStation();
        assertEquals(expected, actual);
    }

    //  Текущая радиостанция в допустимом диапазоне;
    @Test
    public void shouldSwitchCurrentRadioStationInAcceptableRange() {

        radio.setCurrentRadioStation(8);

        int expected = 8;
        int actual = radio.getCurrentRadioStation();
        assertEquals(expected, actual);
    }

    //  Текущая радиостанция выше граничного значения;
    @Test
    public void shouldSwitchCurrentRadioStationAboveLimitValue() {

        radio.setCurrentRadioStation(10);
        radio.nextButton();

        int expected = 0;
        int actual = radio.getCurrentRadioStation();
        assertEquals(expected, actual);
    }

    //  Увеличение текущей радиостанции, равная 0;
    @Test
    public void shouldSwitchRadioStationEqualZero() {

        radio.setCurrentRadioStation(0);
        radio.nextButton();

        int expected = 1;
        int actual = radio.getCurrentRadioStation();
        assertEquals(expected, actual);
    }

    //  Уменьшение текущей радиостанции, равная 1;
    @Test
    public void shouldSwitchRadioStationEqualOne() {

        radio.setCurrentRadioStation(1);
        radio.prevButton();

        int expected = 0;
        int actual = radio.getCurrentRadioStation();
        assertEquals(expected, actual);
    }

    //  Текущая радиостанция ниже граничного значения;
    @Test
    public void shouldSwitchCurrentRadioStationBelowLimitValue() {

        radio.setCurrentRadioStation(-1);
        radio.prevButton();

        int expected = 9;
        int actual = radio.getCurrentRadioStation();
        assertEquals(expected, actual);
    }

    //  Переключение с последней станции на следующую;
    @Test
    public void shouldSwitchNextStationButtonAboveMaxRadioStation() {

        radio.setCurrentRadioStation(9);
        radio.nextButton();

        int expected = 0;
        int actual = radio.getCurrentRadioStation();
        assertEquals(expected, actual);
    }

    //  Кнопка "Next".
    @Test
    public void nextStationButton() {

        radio.nextButton();

        int expected = 1;
        int actual = radio.getCurrentRadioStation();
        assertEquals(expected, actual);
    }

    //  Кнопка "Prev".
    @Test
    public void prevStationButton() {

        radio.setCurrentRadioStation(8);
        radio.prevButton();

        int expected = 7;
        int actual = radio.getCurrentRadioStation();
        assertEquals(expected, actual);
    }

    //  Текущий уровень громкости выше граничного значения;
    @Test
    public void shouldSwitchCurrentVolumeAboveLimitValue() {

        radio.setCurrentVolume(100);
        radio.plusButton();

        int expected = 100;
        int actual = radio.getCurrentVolume();
        assertEquals(expected, actual);
    }

    //  Текущий уровень громкости ниже граничного значения;
    @Test
    public void shouldSwitchSetCurrentVolumeBelowLimitValue() {

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