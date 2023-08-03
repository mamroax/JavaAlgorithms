import java.util.Arrays;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        int[] array = new int[7];
        for (int i = 0; i < array.length; i++)
            array[i] = new Random().nextInt(10);
        int[] array2 = Arrays.copyOf(array, array.length);
        int[] array3 = new int[]{9, 2, 1, 5, 7, 8, 6};
        quickSort(array3);
    }

    public static void quickSort(int[] array) {
        quickSort(array, 0, array.length - 1);
    }

    private static void quickSort(int[] array, int leftBorder, int rightBorder) {
        System.out.println("---------------------------");
        int leftMarker = leftBorder;
        int rightMarker = rightBorder;
        int pivot = array[(leftMarker + rightMarker) / 2];
        while (leftMarker <= rightMarker) {
            while (array[leftMarker] < pivot)
                leftMarker++;
            while (array[rightMarker] > pivot)
                rightMarker--;
            System.out.println("lm:" + leftMarker + " rm:" + rightMarker + "  Перед условием");
            if (leftMarker <= rightMarker) {
                print(array);
                System.out.println(pivot + " lm:" + leftMarker + " rm:" + rightMarker + " lb:" + leftBorder + " rb:" + rightBorder);
                if (leftMarker != rightMarker) {
                    int temp = array[leftMarker];
                    array[leftMarker] = array[rightMarker];
                    array[rightMarker] = temp;
                }
                leftMarker++;
                rightMarker--;
                System.out.println("lm:" + leftMarker + " rm:" + rightMarker);
            }
        }
        if (leftBorder < rightMarker) {
            quickSort(array, leftBorder, rightMarker);
            System.out.print("left");
        }
        if (leftMarker < rightBorder) {
            quickSort(array, leftMarker, rightBorder);
            System.out.print("right");
        }
    }

    public static void insertionSort(int[] array) {
        for (int current = 1; current < array.length; current++) {
            int value = array[current];
            int i = current - 1;
            for (; i >= 0; i--) {
                if (value < array[i])
                    array[i + 1] = array[i];
                else
                    break;
            }
            array[i + 1] = value;
        }
    }

    public static void heapSort(int arr[]) {
        int n = arr.length;

        for (int i = n / 2 - 1; i >= 0; i--)
            heapify(arr, n, i);

        for (int i = n - 1; i >= 0; i--) {
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;

            heapify(arr, i, 0);
        }
    }

    public static void heapify(int arr[], int n, int i) {
        int largest = i; // Инициализируем наибольший элемент как корень
        int left = 2 * i + 1; // левый = 2*i + 1
        int right = 2 * i + 2; // правый = 2*i + 2

        if (left < n && arr[left] > arr[largest])
            largest = left;
        if (right < n && arr[right] > arr[largest])
            largest = right;
        if (largest != i) {
            int swap = arr[i];
            arr[i] = arr[largest];
            arr[largest] = swap;

            heapify(arr, n, largest);
        }
    }

    public static void print(int[] array) {
        for (int i = 0; i < array.length; i++)
            System.out.print(array[i] + " ");
        System.out.println();
    }
}