public class MainMap<T> extends CountMapImpl<T> {

    public static void main(String[] args) {
        CountMap<Integer> map = new CountMapImpl<>();

        map.add(10);
        map.add(10);
        map.add(5);
        map.add(6);
        map.add(5);
        map.add(10);
        map.add(6);
        map.add(6);
        map.remove(12);
        System.out.println(map.getCount(11));
        System.out.println(map.size());


        for (Object e : map.toMap().entrySet()) {
            System.out.println(e);
        }
    }
}