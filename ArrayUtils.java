/**
 Утилитарный класс для работы с массивными.
 Предоставляет возможность суммирования элементов массива, конвертацию массива строк в массив int,
 добавляет новый элемент в конец массива, сортировку двумерного массива по сумме его подмассивов.
 @version 1.1
 */



public class ArrayUtils {
    /**
     * Вычисляет сумму элементов массива
     * @param numbers  массив чисел
     * @return сумма элементов массива. Возвращает {@code 0}, если массив {@code null} или пуст.
     * @since 1.0
     */
    public static int sum(int... numbers){
        if (numbers == null) return 0;
        int res = 0;
        for (int number : numbers) {
            res += number;
        }
        return res;
    }

    /**
     * Преобразует массив строк в массив целых чисел.
     * Каждая строка преобразуется с помощью {@link Integer#parseInt(String)}.
     * @param array  массив строк с числами
     * @return Возвращает массив чисел
     * @since 1.0
     */
    public static int[] convert(String[] array){
        int[] res = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            res[i] = Integer.parseInt(array[i]);
        }
        return res;
    }

    /**
     * Добавляет элемент конец массива
     * @param x  новое число
     * @param array  массив чисел
     * @return массив чисел с добавленным элементом
     * @since 1.0
     */
    public static int[] append(int x, int ... array){
        int[] res = new int[array.length+1];
        for (int i = 0; i < array.length; i++) {
            res[i] = array[i];
        }
        res[array.length] = x;
        return res;
    }

    /**
     * Сортирует двумерный массив по возрастанию суммы элементов в каждом под массиве.
     * Сортировка выполняется **in-place** (на месте), исходный массив модифицируется.
     * Используется алгоритм быстрой сортировки (QuickSort) со схемой разбиения Хоара.
     *
     * @param array  сортируемый массив
     * @since 1.1
     */
    public static void quickSortBySum(int [][] array){
        int [] arraySums =new int [array.length];
        for (int i = 0; i<array.length ;i++){
            arraySums[i] = sum(array[i]);
        }
        quickSort(0, array.length - 1, arraySums, array);
    }
    /**
     * Меняет местами два элемента в одномерном массиве.
     */
    private static void swap(int leftIndex, int rightIndex, int ... array){
        int temp = array[leftIndex];
        array[leftIndex] = array[rightIndex];
        array[rightIndex] = temp;
    }
    /**
     * Меняет местами два под массива в двумерном массиве.
     */
    private static void swap(int leftIndex, int rightIndex, int [][] array){
        int[] temp = array[leftIndex];
        array[leftIndex] = array[rightIndex];
        array[rightIndex] = temp;
    }

    /**
     * Вычисляет медиану среди трех значений
     * @param low одно из чисел
     * @param medium одно из чисел
     * @param high  одно из чисел
     * @return медиана среди значений.
     */
    private static int medianOfThree(int low, int medium, int high) {
        return Math.max(Math.min(low, medium), Math.min(Math.max(low, medium), high));
    }

    /**
     * Разбивает массив на две части относительно опорного элемента (pivot)
     * по схеме Хоара.
     * После выполнения все элементы слева от возвращаемого индекса
     * меньше или равны pivot, а справа — больше или равны.
     *
     * @return индекс границы раздела (j), который должен быть использован
     *         для рекурсивных вызовов как {@code quickSort(low, j)} и {@code quickSort(j + 1, high)}.
     */
    private static int partition(int low, int high, int[] arraySums, int[][] array) {
        int pivot = arraySums[(low + high) / 2];
        int i = low - 1;
        int j = high + 1;
        while (true) {
            do { i++; } while (arraySums[i] < pivot);
            do { j--; } while (arraySums[j] > pivot);
            if (i >= j) return j;
            swap(i, j, array);
            swap(i, j, arraySums);
        }
    }

    /**
     * Рекурсивное ядро алгоритма быстрой сортировки.
     */
    private static void quickSort(int low, int high,int [] arraySums, int [][] array){
        if (low<high){
            int pivot = partition(low, high, arraySums, array);
            quickSort(low,pivot, arraySums, array);
            quickSort(pivot+1, high, arraySums, array);
        }
    }

}