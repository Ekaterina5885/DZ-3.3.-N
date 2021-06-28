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
        assertEquals(10, radio.getQuantityRadioStation());
        assertEquals(0, radio.getMinVolume());
        assertEquals(100, radio.getMaxVolume());
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
    public void shouldSwitchCurrentRadioStationAbovelimitValue() {

        radio.setCurrentRadioStation(11);
        radio.nextButton();

        int expected = 0;
        int actual = radio.getCurrentRadioStation();
        assertEquals(expected, actual);
    }

    //  Текущая радиостанция - максимальная;
    @Test
    public void shouldSwitchCurrentRadioStationEqualMaxRadioStation() {

        radio.setCurrentRadioStation(10);

        int expected = 10;
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
    public void shouldSwitchCurrentRadioStationBelowlimitValue() {

        radio.setCurrentRadioStation(-1);
        radio.prevButton();

        int expected = 10;
        int actual = radio.getCurrentRadioStation();
        assertEquals(expected, actual);
    }

    //  Переключение с последней станции на следующую;
    @Test
    public void shouldSwitchNextStationButtonAboveMaxRadioStation() {

        radio.setCurrentRadioStation(11);
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
    public void shouldSwitchCurrentVolumeAbovelimitValue() {

        radio.setCurrentVolume(100);
        radio.plusButton();

        int expected = 100;
        int actual = radio.getCurrentVolume();
        assertEquals(expected, actual);
    }

    //  Текущий уровень громкости ниже граничного значения;
    @Test
    public void shouldSwitchSetCurrentVolumeBelowlimitValue() {

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