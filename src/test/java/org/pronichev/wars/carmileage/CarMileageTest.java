package org.pronichev.wars.carmileage;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class CarMileageTest {

    @Test
    public void testTooSmall() {
        assertEquals(0, CarMileage.isInteresting(3, new int[]{1337, 256}));
    }

    @Test
    public void testAlmostAwesome() {
        assertEquals(1, CarMileage.isInteresting(1336, new int[]{1337, 256}));
    }

    @Test
    public void testAwesome() {
        assertEquals(2, CarMileage.isInteresting(1337, new int[]{1337, 256}));
    }

    @Test
    public void testFarNotInteresting() {
        assertEquals(0, CarMileage.isInteresting(11208, new int[]{1337, 256}));
    }

    @Test
    public void testAlmostInteresting() {
        assertEquals(1, CarMileage.isInteresting(11209, new int[]{1337, 256}));
    }

    @Test
    public void testInteresting() {
        assertEquals(2, CarMileage.isInteresting(11211, new int[]{1337, 256}));
    }

    @Test
    public void maxTest() {
        assertEquals(0, CarMileage.isInteresting(3, new int[]{1337, 256}));
        assertEquals(0, CarMileage.isInteresting(3236, new int[]{1337, 256}));
        assertEquals(0, CarMileage.isInteresting(11207, new int[]{}));
        assertEquals(0, CarMileage.isInteresting(11208, new int[]{}));
        assertEquals(1, CarMileage.isInteresting(11209, new int[]{}));
        assertEquals(1, CarMileage.isInteresting(11210, new int[]{}));
        assertEquals(2, CarMileage.isInteresting(11211, new int[]{}));
        assertEquals(1, CarMileage.isInteresting(1335, new int[]{1337, 256}));
        assertEquals(1, CarMileage.isInteresting(1336, new int[]{1337, 256}));
        assertEquals(2, CarMileage.isInteresting(1337, new int[]{1337, 256}));
        assertEquals(2, CarMileage.isInteresting(12345, new int[]{}));
    }

    @Test
    public void bigNumberTest() {
        assertEquals(1, CarMileage.isInteresting(98, new int[]{}));
        assertEquals(2, CarMileage.isInteresting(100, new int[]{}));
        assertEquals(1, CarMileage.isInteresting(998, new int[]{}));
        assertEquals(2, CarMileage.isInteresting(100000, new int[]{}));
    }

    @Test
    public void orderWithZeroTest() {
        assertEquals(2, CarMileage.isInteresting(67890, new int[]{}));
        assertEquals(1, CarMileage.isInteresting(67888, new int[]{}));
        assertEquals(1, CarMileage.isInteresting(987654320, new int[]{}));
    }

    @Test
    public void decSeqTest() {
        assertEquals(2, CarMileage.isInteresting(3210, new int[]{}));
        assertEquals(1, CarMileage.isInteresting(3208, new int[]{}));
    }

    @Test
    public void palindromTest() {
        assertEquals(2, CarMileage.isInteresting(121, new int[]{}));
        assertEquals(1, CarMileage.isInteresting(120, new int[]{}));
    }
}