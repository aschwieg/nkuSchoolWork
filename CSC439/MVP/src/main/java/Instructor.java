public class Instructor implements Person {
    private String prefix, last, title, currentClass;

    Instructor() {

    }

    Instructor(String prefix, String last, String title, String currentClass) {
        this.prefix = prefix;
        this.last = last;
        this.title = title;
        this.currentClass = currentClass;
    }

    @Override
    public String getLast() {
        return this.last;
    }

    @Override
    public String toStringFormat() {
        return prefix + " " + last + ", " + title + ", " + currentClass;
    }

    @Override
    public int compareTo(Person o) {
        return last.compareTo(o.getLast());
    }

}
