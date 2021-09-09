import java.util.Arrays;
import java.util.Scanner;

public class BinarySearch {
    public static void main(String[] args) {
        int[] array;
        int item;
        int first;
        int last;
        int position;
        Scanner input = new Scanner(System.in);
        array = new int[]{27, 99, 7, 1, 9, 47, 5, 8, 73, 2, 26, 3, 6, 68, 31};
        Arrays.sort(array);
        System.out.print("Введите элемент массива для поиска: ");
        item = input.nextInt();
        first = 0;
        last = array.length - 1;
        position = (first + last) / 2;

        while ((array[position] != item) && (first <= last)) {
            if (array[position] > item) {
                last = position - 1;
            } else {
                first = position + 1;
            }
            position = (first + last) / 2;
        }
        if (first <= last) {
            System.out.println(item + " является " + ++position + " элементом в массиве");
        } else {
            System.out.println("Элемент не найден в массиве.");
        }
    }
}
