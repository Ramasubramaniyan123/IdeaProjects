package Streams;

import java.util.ArrayList;
import java.util.List;

public class StreamsDemo {
    static void main() {
        List<Integer> list = new ArrayList<>();
        List<Integer> output=new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        for(int i:list){
            if(i%2==0){
                output.add(i*100);
            }
        }
        System.out.println(output);
        list.stream().filter(x->x%2==0).
    }
}
