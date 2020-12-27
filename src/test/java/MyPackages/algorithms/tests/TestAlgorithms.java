package MyPackages.algorithms.tests;

import org.junit.Assert;
import MyPackages.algorithms.classes.Algorithms;

public class TestAlgorithms {
    @org.junit.Test
    public void TestBubbleSort(){
        Assert.assertArrayEquals(Algorithms.bubbleSort(new int[]{5,1,3,1,2}), new int[]{1,1,2,3,5});
    }
    @org.junit.Test
    public void TestInsertionSort(){
        Assert.assertArrayEquals(Algorithms.bubbleSort(new int[]{5,1,3,1,2}), new int[]{1,1,2,3,5});
    }
    @org.junit.Test
    public void testCountingSort(){
        Assert.assertArrayEquals(Algorithms.bubbleSort(new int[]{5,1,3,1,2,3,3}), new int[]{1,1,2,3,3,3,5});
    }
}
