package com.wipro.test;

import static org.junit.Assert.assertArrayEquals;
import org.junit.Test;
import com.wipro.task.DailyTasks;

public class TestSort {

    @Test
    public void testSortValues() {
        DailyTasks dt = new DailyTasks();
        int[] input = {5, 3, 8, 1};
        int[] expected = {1, 3, 5, 8};
        int[] result = dt.sortValues(input);

        assertArrayEquals(expected, result);
    }
}
