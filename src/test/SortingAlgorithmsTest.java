import static org.junit.Assert.*;

import org.junit.Test;

public class SortingAlgorithmsTest {

    @Test
    public void testBubbleSort() {
        int[] arr = {5, 4, 3, 2, 1};
        
        SortingAlgorithms.bubbleSort(arr);
        
        assertArrayEquals(new int[]{1, 2, 3, 4, 5}, arr);
    }

    @Test 
    public void testMergeSort() {
        int[] arr = {5, 4, 3, 2, 1};
        
        SortingAlgorithms.mergeSort(arr);
        
        assertArrayEquals(new int[]{1, 2, 3, 4, 5}, arr);
    }
    
    @Test
    public void testQuickSort() {
        int[] arr = {5, 4, 3, 2, 1};
        
        SortingAlgorithms.quickSort(arr);
        
        assertArrayEquals(new int[]{1, 2, 3, 4, 5}, arr);
    }
    
    @Test 
    public void testRadixSort() {
        int[] arr = {5, 4, 3, 2, 1};
        
        SortingAlgorithms.radixSort(arr);
        
        assertArrayEquals(new int[]{1, 2, 3, 4, 5}, arr);        
    }
    
    @Test
    public void testGnomeSort() {
        int[] arr = {5, 4, 3, 2, 1};
        
        SortingAlgorithms.gnomeSort(arr);
        
        assertArrayEquals(new int[]{1, 2, 3, 4, 5}, arr);
    }
}
