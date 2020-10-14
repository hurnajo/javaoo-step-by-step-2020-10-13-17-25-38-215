package practice10;

import java.util.List;
import java.util.stream.Collectors;

public class Teacher extends Person {
    private Klass klass;
    private List<Klass> classes;
    public Teacher(int id, String name, int age) {
        super(id, name, age);
    }

    public Teacher(int id, String name, int age, List<Klass> classes) {
        super(id, name, age);
        this.classes = classes;
    }

    public Klass getKlass() {
        return klass;
    }

    public String introduce() {
        if (classes == null) {
            return super.introduce() + " I am a Teacher. I teach No Class.";
        }

        if (getClasses().size() != 0) {
            String classes = getClasses().stream().map(Klass::getNumber).map(String::valueOf).collect(Collectors.joining(", "));
            return super.introduce() + " I am a Teacher. I teach Class " + classes + ".";
        }

        return super.introduce() + " I am a Teacher. I teach No Class.";
    }

    public String introduceWith(Student student) {
        boolean isClassIncluded = getClasses().stream()
                .map(Klass::getNumber)
                .anyMatch(classNum -> classNum.equals(student.getKlass().getNumber()));

        if (isClassIncluded) {
            return super.introduce() + " I am a Teacher. I teach " + student.getName() + ".";
        }
        return super.introduce() + " I am a Teacher. I don't teach " + student.getName() + ".";
    }

    public boolean isTeaching(Student student) {
        boolean isIncluded = getClasses().stream()
                .map(Klass::getNumber)
                .anyMatch(classNum -> classNum.equals(student.getKlass().getNumber()));
        if (isIncluded) {
            return true;
        }else{
            return false;
        }
    }

    public List<Klass> getClasses() {
        return classes;
    }
}
