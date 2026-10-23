package Java;

public class Sorting {
    public static void quickSortBySum(int [][] array){
        int [] arraySums =new int [array.length];
        for (int i = 0; i<=array.length - 1;i++){
            arraySums[i] = ArrayUtils.sum(array[i]);
        }
        quickSort(0, array.length - 1,arraySums, array);
    }
    private static void swap(int leftIndex, int rightIndex, int ... array){
        int temp = array[leftIndex];
        array[leftIndex] = array[rightIndex];
        array[rightIndex] = temp;
    }
    private static void swap(int leftIndex, int rightIndex, int [][] array){
        int[] temp = array[leftIndex];
        array[leftIndex] = array[rightIndex];
        array[rightIndex] = temp;
    }
    private static int medianOfThree(int a, int b, int c) {
        return Math.max(Math.min(a, b), Math.min(Math.max(a, b), c));
    }
    private static int partition(int low, int high,int[] arraySums, int[][] array){
        int pivot = medianOfThree(arraySums[low],arraySums[(low+high)/2],arraySums[high]);
        int left = low, right = high;
        while (true) {
            while (left <= right && arraySums[left] <= pivot) {
                left++;
            }
            while (left <= right && arraySums[right] >= pivot) {
                right--;
            }
            if (left > right){
                break;
            }
            swap(left,right,array);
            swap(left,right,arraySums);
        }
        return right;
    }
    private static void quickSort(int low, int high,int [] arraySums, int [][] array){
        if (low<high){
            int pivot = partition(low, high,arraySums, array);
            quickSort(low,pivot-1,arraySums, array);
            quickSort(pivot+1, high,arraySums, array);
        }
    }
}
