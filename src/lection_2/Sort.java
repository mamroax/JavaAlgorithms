package lection_2;

public class Sort {
    public static void main(String[] args) {
        int[] array = new int[]{4, 2, 5, 8, 1, 9, 0, 3, 6, 7};

        bubbleSort(array);
    }
    public static void bubbleSort(int[] array){
        boolean finish = true;
        do {
            for (int i = 0; i < array.length - 1; i++) {
                if (array[i] > array[i + 1]) {
                    int temp = array[i];
                    array[i] = array[i + 1];
                    array[i + 1] = temp;
                    finish = false;
                }
            }
        } while(!finish);
    }
}
