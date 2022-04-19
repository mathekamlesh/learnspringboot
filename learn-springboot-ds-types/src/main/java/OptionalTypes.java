import java.util.Locale;
import java.util.Optional;

public class OptionalTypes {
    public static void main(String[] args) {
        Optional<String> hello = Optional.ofNullable("Hello");
        System.out.println(hello.isPresent());
//        Object var = hello
//                .map(String::toUpperCase)
//                .orElseGet(()-> {
//                    return "mathe";
//                });
//        System.out.println(var);

//        hello.ifPresent(word -> {
//            System.out.println(word);
//        });

        Person person = new Person("kamlesh",null);
        System.out.println(person.getEmail().map(String::toLowerCase).orElse("Email not provided"));
    }
}

class Person {

    private final String name;
    private final String email;

    public Person(String name, String email) {
        this.name = name;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public Optional<String> getEmail() {
        return Optional.ofNullable(email);
    }
}