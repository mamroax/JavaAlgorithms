package homework_1;

public class HeapSort {
    /** Сортировка пирамидкой */
    public static void main(String args[]) {
        int myArray[] = {3, 32, 23, 56, 34, 7, 3, 7, 75, 4, 28};

        System.out.println("Исходный массив");
        printArray(myArray);

        HeapSort heapSort = new HeapSort();
        heapSort.sort(myArray);

        System.out.println("Отсортированный массив: ");
        printArray(myArray);
    }

    static void printArray(int someArray[]) {
        int arrayLen = someArray.length;
        for (int i = 0; i < arrayLen; ++i) {
            System.out.print(someArray[i] + " ");
        }
        System.out.println();
    }

    public void sort(int someArray[]) {
        int arraySize = someArray.length;

        for (int i = arraySize / 2 - 1; i >= 0; i--) {
            makeHeap(someArray, arraySize, i);
        }
        for (int i = arraySize - 1; i >= 0; i--) {
            int temp = someArray[0];
            someArray[0] = someArray[i];
            someArray[i] = temp;
            makeHeap(someArray, i, 0);
        }
    }

    void makeHeap(int array[], int arrSize, int i) {
        int largestElementIndex = i;
        int leftElementIndex = 2 * i + 1;
        int rightElementIndex = 2 * i + 2;

        if (leftElementIndex < arrSize && array[leftElementIndex] > array[largestElementIndex]) {
            largestElementIndex = leftElementIndex;
        }

        if (rightElementIndex < arrSize && array[rightElementIndex] > array[largestElementIndex]) {
            largestElementIndex = rightElementIndex;
        }

        if (largestElementIndex != i) {
            int swapedElement = array[i];
            array[i] = array[largestElementIndex];
            array[largestElementIndex] = swapedElement;

            makeHeap(array, arrSize, largestElementIndex);
        }
    }
}
