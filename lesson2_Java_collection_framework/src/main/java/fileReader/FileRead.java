package fileReader;


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class FileRead {
    public static String PATH = "lesson2\\src\\main\\resources\\text.txt";


    public static void main(String[] args) throws IOException
    {
//        Задание.

        List<FileData> dataList = Files.lines(Paths.get(PATH))
                .filter(s -> s.contains(" "))
                .map(s -> s.split(" "))
                .map(FileData::new)
                .collect(Collectors.toList());
        dataList.forEach(System.out::println);
        System.out.println("-----------------------------------------");

//        Задание 1: Подсчитайте количество различных слов в файле.

        System.out.println("-----------------------------------------");
        Stream<String> wordsCount =
                Files.lines(Paths.get(PATH));
        long countWord = wordsCount
                .flatMap(s -> Stream.of(s.split("\\s")))
                .count();
        System.out.println("Number of words: " + countWord);
        System.out.println("-----------------------------------------");

//        Задание 2: Выведите на экран список различных слов файла,
//                отсортированный по возрастанию их длины (компаратор сначала по длине слова, потом по тексту).

        List<String> words = Files.lines(Paths.get(PATH))
                .map(line -> line.split("\\s+")).flatMap(Arrays::stream)
                .map(String::valueOf)
                .collect(Collectors.toList());
        List<String> sortedList = words.stream()
                .sorted(Comparator.comparing(String::length))
                .collect(Collectors.toList());
        sortedList.forEach(System.out::println);
        System.out.println("-----------------------------------------");

//        Задание 3: Подсчитайте и выведите на экран сколько раз каждое слово встречается в файле.

        Set<String> printed = new HashSet<>();
        for (String s : sortedList) {
            if (printed.add(s))
                System.out.println("word: " + s
                        + ", count: " + Collections.frequency(sortedList, s));
        }
        System.out.println("-----------------------------------------");

//        Задание 4: Выведите на экран все строки файла в обратном порядке.

        Path file = Paths.get(PATH);
        List<String> lines = Files.readAllLines(file);
        Collections.reverse(lines);
        lines.forEach(System.out::println);
        System.out.println("-----------------------------------------");

//        Задание 5: Реализуйте свой Iterator для обхода списка в обратном порядке.

        int size = lines.size();
        ListIterator<String> it = lines.listIterator(size);
        Stream.iterate(it.previous(), i -> it.previous()).limit(size)
                .forEach(System.out::println);
        System.out.println("-----------------------------------------");

//        Задание 6: Выведите на экран строки, номера которых задаются пользователем в произвольном порядке.
        Map<Integer, String> mapNum = new TreeMap<>();
        List<Integer> numbersInput = new ArrayList<>();
        List<String> result = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите номера строк для вывода на экран через пробел: ");
        numbersInput.add(scanner.nextInt());
        System.in.close();
        while (scanner.hasNextInt())
            numbersInput.add(scanner.nextInt());
        Collections.reverse(lines);
        for (int i = 0; i < lines.size(); i++) {
            mapNum.put(i + 1, lines.get(i));
        }
        for (Integer integer : numbersInput) {
            for (Map.Entry<Integer, String> ee : mapNum.entrySet()) {
                if (integer.equals(ee.getKey())) {
                    result.add(ee.getValue());
                }
            }
        }
        result.forEach(System.out::println);
        System.out.println("-----------------------------------------");
    }
}

