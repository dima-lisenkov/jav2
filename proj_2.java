
import java.io.IOException;
import java.util.Arrays;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class proj_2 {
    public static void main(String[] args) throws IOException {
        int[] nums = new int[] { 1, 3, 9, 8, 5, 7, 4, 6, 2, 10 };
        System.out.print("Исходные данные: ");
        printArray(nums);
        bubbleSort(nums);
        System.out.print('\n' + "Результат сортировки: ");
        printArray(nums);

    }

    public static int[] bubbleSort(int[] arr) throws IOException {
        Logger loger = Logger.getLogger(Task_2.class.getName());
        FileHandler fileHand = new FileHandler("proj_2_log.txt");
        SimpleFormatter sFormatter = new SimpleFormatter();
        fileHand.setFormatter(sFormatter);
        loger.addHandler(fileHand);

        boolean isSort;
        for (int i = 0; i < arr.length - 1; i++) {
            isSort = true;
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j + 1] < arr[j]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    isSort = false;
                }
            }
            if (isSort)
                return arr;
            loger.info(Arrays.toString(arr));
        }
        return arr;
    }

    public static void printArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}