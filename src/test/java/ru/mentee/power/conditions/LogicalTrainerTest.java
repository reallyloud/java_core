package ru.mentee.power.conditions;

import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.assertj.core.api.Java6Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class LogicalTrainerTest {
    LogicalTrainer logicalTrainer = new LogicalTrainer();
        @Test
    public void testLikesAll() {
            Map results = logicalTrainer.logicValues(true,true,true);
            assertThat(results.get(0)).isEqualTo(true);
            assertThat(results.get(1)).isEqualTo(true);
            assertThat(results.get(2)).isEqualTo(false);
            assertThat(results.get(3)).isEqualTo(false);
            assertThat(results.get(4)).isEqualTo(true);
            assertThat(results.get(5)).isEqualTo(false);
            assertThat(results.get(6)).isEqualTo(false);
            assertThat(results.get(7)).isEqualTo(true);
        }

        @Test
    public void testProgAndRead () {
            Map results = logicalTrainer.logicValues(true,false,true);
            assertThat(results.get(0)).isEqualTo(false);
            assertThat(results.get(1)).isEqualTo(false);
            assertThat(results.get(2)).isEqualTo(true);
            assertThat(results.get(3)).isEqualTo(false);
            assertThat(results.get(4)).isEqualTo(false);
            assertThat(results.get(5)).isEqualTo(false);
            assertThat(results.get(6)).isEqualTo(false);
            assertThat(results.get(7)).isEqualTo(true);
        }
    @Test
    public void testNotLikes() {
            Map results = logicalTrainer.logicValues(false,false,false);
        assertThat(results.get(0)).isEqualTo(false);
        assertThat(results.get(1)).isEqualTo(false);
        assertThat(results.get(2)).isEqualTo(false);
        assertThat(results.get(3)).isEqualTo(false);
        assertThat(results.get(4)).isEqualTo(false);
        assertThat(results.get(5)).isEqualTo(true);
        assertThat(results.get(6)).isEqualTo(false);
        assertThat(results.get(7)).isEqualTo(false);
    }
}