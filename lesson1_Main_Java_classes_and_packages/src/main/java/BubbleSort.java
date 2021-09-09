
public class BubbleSort {
    public static void main(String[] args) {
        int[] bubble = {27, 99, 7, 1, 9, 47, 5, 8, 73, 2, 26, 3, 6, 68, 31};
        for (int i = bubble.length - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (bubble[j] > bubble[j + 1]) {
                    int tmp = bubble[j];
                    bubble[j] = bubble[j + 1];
                    bubble[j + 1] = tmp;
                }
            }
        }
        System.out.print("Sort array: ");
        for (int i = 0; i < bubble.length; i++) {
            System.out.print(bubble[i] + " ");
        }
    }
}
