package practice03;

public class Student extends Person {
    private int klass;
    public Student(String name, int age,int klass) {
        super(name, age);
        this.klass = klass;
        return ;
    }


    public String introduce() {
        return "I am a Student. I am at Class "+getKlass()+".";
    }
    public int getKlass() {
        return klass;
    }
}
