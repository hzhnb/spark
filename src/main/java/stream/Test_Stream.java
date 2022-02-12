package stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class Test_Stream {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("1", "2", "3 ");
        Stream<String> stream = list.stream();
        stream.map(x->{
            System.out.println("map" + x);
            return x;
        }).filter(x->{
            System.out.println("filter" + x);
            return true;
        }).count();
    }
}
