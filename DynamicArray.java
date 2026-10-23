import java.util.Arrays;

/**
 * Класс для работы с динамическим массивом целочисленных значений.
 * @version 1.0
 * @author ml
 */
public class DynamicArray {
    /** Значение вместительности по умолчанию для пустого массива*/
    private static final int DEFAULT_CAPACITY = 10;
    /** Значение вместительности по умолчанию для пустого массива*/
    final int defaultInitialCapacity;
    /** Значение вместительности по умолчанию для пустого массива*/
    private static final int[] CONST_NULL_ARRAY = {};
    /** Внутреннее хранилище элементов. Длина равна текущей вместимости.*/
    private int[] array;
    /** Текущее значение размера массива.*/
    private int size;

    /**
     * Конструктор для создания динамического массива с заданным изначальным массивом
     * @param arr изначальный массив
     * @since 1.0
     */
    public DynamicArray(int... arr){
        if (arr == null){
            this.array = CONST_NULL_ARRAY;
            this.size = 0;
        }else{
            this.array = Arrays.copyOf(arr,Math.max(arr.length, DEFAULT_CAPACITY));
            this.size = arr.length;
        }
        defaultInitialCapacity = DEFAULT_CAPACITY;
    }
    /**
     * Конструктор для создания пустого динамического массива
     * @since 1.0
     */
    public DynamicArray(int capacity){
        this.array = CONST_NULL_ARRAY;
        this.size = 0;
        defaultInitialCapacity = capacity;
    }

    /**
     * Конструктор для создания пустого динамического массива
     * @since 1.0
     */
    public DynamicArray(){
        this.array = CONST_NULL_ARRAY;
        this.size = 0;
        defaultInitialCapacity = DEFAULT_CAPACITY;

    }

    /**
     * Изменение размера массива.
     * @param newCapacity новая вместительность массива
     * @since 1.0
     */
    private void resize(int newCapacity){
        array = Arrays.copyOf(array,newCapacity);
    }
    /**
     * Расширяет вместимость массива в 1.5 раза
     * @see DynamicArray#resize(int)
     * @since 1.0
     */
    private void expander(){
        int newCapacity = Math.max(defaultInitialCapacity, array.length + array.length/2);
        resize(newCapacity);
    }
    /**
     * Уменьшает вместимость массива в 2 раза
     * @see DynamicArray#resize(int)
     * @since 1.0
     */
    private void constrictor(){
        int newCapacity = Math.max(defaultInitialCapacity, array.length/2);
        resize(newCapacity);
    }

    /**
     * Вычисляет сумму элементов массива
     * @return сумма элементов массива. Возвращает {@code 0}, если массив {@code null} или пуст.
     * @since 1.0
     */
    public int sum(){
        if (isEmpty()) return 0;
        int res = 0;
        for (int i = 0; i < size; i++) {
            res+=array[i];
        }
        return res;
    }

    public int max(){
        if (isEmpty()) return 0;
        int maxValue = array[0];
        for (int i = 1; i < size; i++){
            if (maxValue < array[i]) maxValue = array[i];
        }
        return maxValue;
    }

    public int min(){
        if (isEmpty()) return 0;
        int minValue = array[0];
        for (int i = 1; i < size; i++){
            if (minValue > array[i]) minValue = array[i];
        }
        return minValue;
    }


    /**
     * Добавление элемента в конец массива
     * @param x числовое значение добавляющее в конец
     * @since 1.0
     */
    public void addLast(int x){
        ensureCapacityForAdd();
        array[size++] = x;
    }

    /**
     * Удаление последнего элемента массива
     * @return последний элемент массива
     * @since 1.0
     */
    public int removeLast(){
        if (isEmpty()) return 0;
        ensureCapacityForRemove();
        return array[--size];
    }

    /**
     * Добавление элемента в начала массива
     * @param x числовое значение добавляющее в начала массива
     * @since 1.0
     */
    public void addFirst(int x){
        ensureCapacityForAdd();
        System.arraycopy(array, 0, array, 1, size++);
        array[0] = x;
    }

    /**
     * Удаление первого элемента массива
     * @return первый элемент массива
     * @since 1.0
     */
    public int removeFirst(){
        if (isEmpty()) return 0;
        ensureCapacityForRemove();
        int res = array[0];
        System.arraycopy(array, 1, array, 0, --size);
        return res;
    }

    /**
     * Добавление элемента по индексу
     * @param x числовое значение добавляемое по индексу
     * @param index индекс по которому добавляется элемент
     * @since 1.0
     */
    public void add(int x, int index){
        if (!checkIndexInsert(index)) return; // по хорошему нужно выбрасывать ошибки
        ensureCapacityForAdd();
        System.arraycopy(array, index, array, index+1, (size - index));
        size++;
        array[index] = x;
    }

    /**
     * Удаление элемента массива по индексу
     * @param index индекс по которому удаляется элемент
     * @return удаляемое значение
     * @since 1.0
     */
    public int remove(int index){
        if (!checkIndex(index) || isEmpty()) return 0; // по хорошему нужно выбрасывать ошибки
        ensureCapacityForRemove();
        int res = array[index];
        System.arraycopy(array, index + 1, array, index, (size - index - 1));
        size--;
        return res;
    }
    private void ensureCapacityForAdd(){
        if(isEmpty()){
            expander();
        }else if (4*size>3*array.length) {
            expander();
        }
    }
    private void ensureCapacityForRemove(){
        if (isEmpty()) return;
        if(4*size<array.length){
            constrictor();
        }
    }
    private boolean checkIndexInsert(int index){return 0 <= index && index <= size;}
    private boolean checkIndex(int index){return 0 <= index && index < size;}
    public boolean isEmpty(){return size == 0;}
    /**
     * Получение актуального количества элементов массива
     * @return количество элементов массива
     * @since 1.0
     */
    public int getSize(){
        return size;
    }
    public String toString(){
        if (size == 0) return "[]";
        String res = "[";
        for (int i = 0; i < size - 1; i++) {
            res += (array[i] + ", ");
        }
        res += (array[size-1]);
        return res+"]";
    }
}
