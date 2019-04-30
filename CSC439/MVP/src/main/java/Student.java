public class Student implements Person {
    private String last, suffix, first, middle;
    private int age;

    public Student(String last, String suffix, String first, String middle, int age) {
        this.last = last;
        this.suffix = suffix;
        this.first = first;
        this.middle = middle;
        this.age = age;
    }

    public Student() {

    }

    @Override
    public int compareTo(Person o) {
        return last.compareTo(o.getLast());
    }

    @Override
    public String toStringFormat() {
        return last + " " + suffix + ", " + first + " " + middle + " - Age " + age;
    }

    @Override
    public String getLast() {
        return this.last;
    }

}
