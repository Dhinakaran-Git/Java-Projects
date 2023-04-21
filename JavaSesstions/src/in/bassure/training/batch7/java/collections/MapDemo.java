package in.bassure.training.batch7.java.collections;

import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class MapDemo {

    public static void main2(String[] args) {
        List<Integer> list = new LinkedList<>();
        
        list.add(20);
        list.add(40);
        list.add(3);
        list.add(4);
        
        System.out.println(list);
        list.remove(Integer.valueOf(3));
        System.out.println(list);
    }
    
    public static void main(String[] args) {
        Map<String, String> values = new HashMap<>();
        
        values.put("Dennis", "Sea");
        values.put("James", "Java");
        values.put("Stroustrup", "Sea++");
        
        System.out.println(values);
        Set<String> keys = values.keySet();
        System.out.println(keys);
        Collection<String> mapValues = values.values();
        System.out.println(mapValues);
        
        Map.Entry<String, String> anEntry = Map.entry("Google", "Go");
        System.out.println(anEntry);
        values.put(anEntry.getKey(), anEntry.getValue());
        System.out.println(values);
        
        Set<Map.Entry<String, String>> entries = values.entrySet();
        
        for(Map.Entry<String, String> v: entries){
            System.out.println(v);
        }
        
        String lang = values.get("james");
        System.out.println(lang);
        
        String rLang = values.getOrDefault("Mozilla", "Rust");
        System.out.println(rLang);
    }

}









