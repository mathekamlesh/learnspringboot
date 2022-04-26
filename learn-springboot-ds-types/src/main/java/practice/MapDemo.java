package practice;

import java.util.HashMap;

public class MapDemo {
    public static void main(String[] args) {
        HashMap<String,Integer> empIds = new HashMap();
        empIds.put("Kamlesh",123456);
        empIds.put("Kapil",78901);
        System.out.println(empIds);
        System.out.println(empIds.containsValue(123456));
    }
}
