package ru.mentee.power.conditions;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.*;


class TrafficLightTest {
    public TrafficLight trafficLight = new TrafficLight();

    @Test
    public void testRedSignal() {
        assertThat(trafficLight.getRecommendation("Красный")).isEqualTo("Стойте");
        assertEquals("Стойте", trafficLight.getRecommendation("красный"));
    }

    @Test
    public void testYellowSignal() {
        assertEquals("Приготовьтесь идти", trafficLight.getRecommendation("Желтый"));
        assertEquals("Приготовьтесь идти", trafficLight.getRecommendation("желтый"));
    }

    @Test
    public void testGreenSignal() {
        assertEquals("Переходите дорогу", trafficLight.getRecommendation("Зеленый"));
        assertEquals("Переходите дорогу", trafficLight.getRecommendation("зеленый"));
    }

    @Test
    public void testUnknownSignal() {
        assertEquals("Цвет неверный", trafficLight.getRecommendation("vgdfsg"));
    }
}