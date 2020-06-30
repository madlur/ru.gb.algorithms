package lesson02;

public class Array {
    private int arr[];
    private int size;
    private boolean isSorted;

    private Array() {
        this.isSorted = false;
    }

    public Array(int capacity) {
        this();
        arr = new int[capacity];
        this.size = 0;
    }

    public Array(int... args) {
        this();
        this.size = args.length;
        this.arr = args;
    }

    public int get(int index) {
        if (index >= size || index < 0)
            throw new ArrayIndexOutOfBoundsException(index);
        return arr[index];
    }

    public void set(int index, int value) {
        if (index >= size || index < 0)
            throw new ArrayIndexOutOfBoundsException(index);
        arr[index] = value;
    }

    public int length() {
        return size;
    }

    private void increaseCapacity() {
        int[] temp = arr;
        arr = new int[size * 2];
        System.arraycopy(temp, 0, arr, 0, size);
    }

    public void append(int value) {
        if (size >= arr.length) {
            increaseCapacity();
        }
        arr[size++] = value;
        isSorted = false;
    }

    public int deleteLast() {
        if (size == 0)
            throw new ArrayIndexOutOfBoundsException(-1);

        return arr[--size];
    }

    // homework
    public void insert(int index, int value) {
        if (index < 0 || index > size) throw new ArrayIndexOutOfBoundsException(index);
        int[] temp = arr;
        index -= 1;
        size += 1;
        arr = new int[size];
        for (int i = 0; i < index; i++) {
            arr[i] = temp[i];
        }
        arr[index] = value;
        for (int i = index + 1; i < arr.length; i++) {
            arr[i] = temp[i - 1];
        }
    }

    public void delete(int val) {
        int index = find(val);
        if (index < 0) System.out.println("There is no value : " + val + " in array");
        else if (index == 0) {
            int[] temp = arr;
            size = size - 1;
            arr = new int[size];
            System.arraycopy(temp, index + 1, arr, 0, size);
        } else {
            int[] temp = arr;
            size = size - 1;
            arr = new int[size];
            for (int i = 0, j = 0; i < size; i++, j++) {
                if (j == index) {
                    j++;
                }
                arr[i] = temp[j];
            }
        }
    }

    public void deleteByIndex(int index) {
        if (index < 0 || index >= size) throw new ArrayIndexOutOfBoundsException(index);
        int[] temp = arr;
        size = size - 1;
        arr = new int[size];
        for (int i = 0, j = 0; i < size; i++, j++) {
            if (j == index) {
                j++;
            }
            arr[i] = temp[j];
        }
    }

    public void deleteAll() {
        size = 0;
        arr = new int[size];
    }

    @Override
    public String toString() {
        if (arr == null) return "null";
        int iMax = size - 1;
        if (iMax == -1) return "[]";

        StringBuilder b = new StringBuilder();
        b.append('[');
        int i = 0;
        while (true) {
            b.append(arr[i]);
            if (i == iMax)
                return b.append(']').toString();
            b.append(", ");
            i++;
        }
    }

    public int find(int value) {
        for (int i = 0; i < size; i++) {
            if (arr[i] == value)
                return i;
        }
        return -1;
    }

    public boolean hasValue(int value) {
        if (!isSorted)
            throw new RuntimeException("try the 'find' method");

        int l = 0;
        int r = size;
        int m;
        while (l < r) {
            m = (l + r) >> 1; // (l + r) / 2
            if (value == arr[m])
                return true;
            else if (value < arr[m])
                r = m;
            else
                l = m + 1;
        }
        return false;
    }

    private void swap(int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    public void sortBubble() {
        int steps = 0;
        for (int i = 0; i < size; i++) {
            steps++;
            for (int j = 0; j < size - 1; j++) {
                steps++;
                if (arr[j] > arr[j + 1])
                    swap(j, j + 1);
                steps++;
            }
        }
        isSorted = true;
        System.out.println("Steps in algorithm bubleSort: " + steps);
    }

    public void sortBubbleUpgrade() { //O (n*n)
        int steps = 0;
        for (int i = 0; i < size; i++) { // O(n)
            steps++;
            for (int j = 0; j < size - i - 1; j++) { // O(n/2)
                steps++;
                if (arr[j] > arr[j + 1])
                    swap(j, j + 1);
                steps++;

            }
        }
        isSorted = true;
        System.out.println("Steps in algorithm bubleSortUpgrade: " + steps);
    }

    public void countingSort() { //если код не полный - значит не успел вовремя дописать :(

    }

    public void sortSelect() {
        for (int flag = 0; flag < size; flag++) {
            int cMin = flag;
            for (int rem = flag + 1; rem < size; rem++)
                if (arr[rem] < arr[cMin])
                    cMin = rem;
            swap(flag, cMin);
        }
        isSorted = true;
    }

    public void sortInsert() {
        for (int out = 0; out < size; out++) {
            int temp = arr[out];
            int in = out;
            while (in > 0 && arr[in - 1] >= temp) {
                arr[in] = arr[in - 1];
                in--;
            }
            arr[in] = temp;
        }
        isSorted = true;
    }
}
