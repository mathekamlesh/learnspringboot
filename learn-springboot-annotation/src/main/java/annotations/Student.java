package annotations;

public class Student {
    private String name;

    public String getName() {
        return name;
    }
    public Student(){

    }

    public void setName(String name) {
        this.name = name;
    }

    public Student(String name) {
        this.name = name;
    }

    public void greet(){
        System.out.println("Hi Good Morning");
    }
}
