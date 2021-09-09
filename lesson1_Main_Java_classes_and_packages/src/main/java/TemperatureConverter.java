import java.util.Scanner;

public class TemperatureConverter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите значение температуры по шкале Цельсия: ");
        int celsius = scanner.nextInt();
        System.out.println("Введите номер шкалы для преобразования.");
        while (true) {
            System.out.print("Фаренгейт - 1 | Кельвин - 2 | Реомюр - 3 | Выход - любое число: ");
            int choise = scanner.nextInt();
            switch (choise) {
                case 1:
                    double far = celsius * 1.8 + 32;
                    System.out.println("Градусов Цельсия: " + celsius + " Градусов Фаренгейта: " + far);
                    break;
                case 2:
                    double kel = celsius + 273.15;
                    System.out.println("Градусов Цельсия: " + celsius + " Градусов Кельвина: " + kel);
                    break;
                case 3:
                    double reo = celsius * 0.8;
                    System.out.println("Градусов Цельсия: " + celsius + " Градусов Реомюр: " + reo);
                    break;
                default:
                    return;
            }
        }
    }
}
