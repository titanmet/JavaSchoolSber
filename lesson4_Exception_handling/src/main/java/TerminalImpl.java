import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class TerminalImpl<T> implements Terminal<T> {
    public static Scanner sc = new Scanner(System.in);
    public static List<Account> account = new ArrayList<>();
    public static int id = 0;
    public static int index = 0;
    public static int count = 0;

    private static void readContent(String url) throws IOException {
        Object content = new URL(url).getContent();

        if (content instanceof InputStream) {
            InputStream contentStream = (InputStream) content;
            try (Scanner contentScanner = new Scanner(contentStream)) {
                while (contentScanner.hasNext()) {
//                    System.out.println(contentScanner.next());
                    contentScanner.next();
                }
            }
        } else {
            throw new IOException("Unsupported content kind");
        }
    }

    public static void waiting(long waitingTime) {
        System.out.println("До окончания блокировки: " + waitingTime + " секунд.");
    }

    public static void main(String[] args) {
        do {
            System.out.println("Type url");
            String url = sc.next();
            System.out.println("Welcome " + url);

            try {
                readContent(url);
                break;
            } catch (MalformedURLException e) {
                System.out.println("Malformed URL specified!");
            } catch (UnknownHostException e) {
                System.out.println("Unknown host!");
            } catch (IOException e) {
                System.out.println("Unable to get site content. " + e.getMessage());
            }

            System.out.println("Try again");
        } while (true);

        TerminalServer.initAccount(account);
        while (true) {
            System.out.print("Введите pin: ");
            id = sc.nextInt();
            if (account.stream().anyMatch(s -> s.getId() == id)) break;
            else {
                count++;
                System.out.println("Неверный pin код");
                if (count == 3) {
                    long start = System.currentTimeMillis();
                    try {
                        TimeUnit.SECONDS.sleep(10);
                        throw new AccountIsLockedException(start);
                    } catch (AccountIsLockedException e) {
                        e.printStackTrace();
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }

        index = account.indexOf(account.stream().filter(s -> s.getId() == id).findFirst().get());

        while (true) {
            System.out.println("Главное меню");
            System.out.println("1: Баланс");
            System.out.println("2: Снять");
            System.out.println("3: Внести");
            System.out.println("4: История операций");
            System.out.println("5: Выход");
            System.out.print("Выберите операцию: ");
            int choice = sc.nextInt();
            if (choice == 5) break;
            switch (choice) {
                case 1: {
                    System.out.println("Баланс: " + account.get(index).getBalance());
                }
                break;

                case 2: {
                    System.out.print("Введите сумму списания: ");
                    double money = sc.nextInt();
                    if (money % 100 == 0) {
                        if (money > account.get(index).getBalance()) {
                            System.out.println("Недостаточно средст на карте !");
                        } else account.get(index).withDraw(money);
                    } else {
                        System.out.println("Введите сумму кратную 100");
                    }
                }
                break;
                case 3: {
                    System.out.print("Введите сумму внесения: ");
                    double money = sc.nextDouble();
                    if (money % 100 == 0) {
                        account.get(index).deposite(money);
                    } else {
                        System.out.println("Введите сумму кратную 100");
                    }
                }
                break;
                case 4: {
                    System.out.println("Запись транзакции: ");
                    for (int j = 0; j < account.get(index).getTransation().size(); j++) {
                        System.out.println(account.get(index).getTransation().get(j).toString());
                    }
                }
                default:
                    break;
            }
        }
    }
}

