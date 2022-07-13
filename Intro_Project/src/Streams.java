import org.testng.Assert;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Streams {
    public static void main(String[] args) {

/*
        ArrayList<String> names = new ArrayList<>();
        names.add("Abhijeet");
        names.add("Amanjeet");
        names.add("Don");
        names.add("Adam");
        names.add("Ram");
*/

/*
        int count = 0;

        for (String a_name: names) {
            if (a_name.startsWith("A")) {
                count++;
            }
        }

        System.out.println(count);
*/

//        long c = names.stream().filter(s->s.startsWith("A")).count();
//        long c = Stream.of("Abhijeet","Aman","Don","Adam","Ram").filter(s -> s.startsWith("A")).count();
//
//        System.out.println(c);

//        names.stream().filter(s -> s.length()>4).forEach(System.out::println);
//        names.stream().filter(s -> s.length()<4).limit(1).forEach(System.out::println);

//        Stream.of("Abhijeet","Aman","Don","Adam","Ram").filter(s -> s.endsWith("m")).map(String::toUpperCase).forEach(System.out::println);

//        List<String> names = Arrays.asList("Abhijeet","Aman","Don","Adam","Ram");
//        names.stream().filter(s -> s.startsWith("A")).sorted().map(String::toUpperCase).forEach(System.out::println);

        ArrayList<String> names1 = new ArrayList<>();
        names1.add("Abhijeet");
        names1.add("Amarjeet");
        names1.add("Don");
        names1.add("Adam");
        names1.add("Ram");

        ArrayList<String> names2 = new ArrayList<>();
        names2.add("Abi");
        names2.add("Aman");
        names2.add("Dog");
        names2.add("Adi");
        names2.add("Raja");

        Stream<String> newStream = Stream.concat(names1.stream(), names2.stream());
//        newStream.sorted().forEach(System.out::println);

        boolean flag = newStream.anyMatch(s -> s.equalsIgnoreCase("Aman"));
        Assert.assertTrue(flag);

        List<String> ls = Stream.of("Abhijeet","Aman","Don","Adam","Ram").filter(s -> s.endsWith("m")).map(String::toUpperCase).collect(Collectors.toList());
        System.out.println(ls.get(1));

        List<Integer> nums = Arrays.asList(3,2,2,7,5,1,9,7);
        nums.stream().distinct().sorted().collect(Collectors.toList());
        System.out.println(nums.get(3));
    }
}
