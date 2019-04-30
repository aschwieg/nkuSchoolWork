import java.util.Scanner;

public class MVP {

    public static void main(String[] args) {
        View<Instructor> instructorView = new View<Instructor>(new Presenter<Instructor>(new InstructorRepository()));
        View<Student> studentView = new View<Student>(new Presenter<Student>(new StudentRepository()));
        Scanner input = new Scanner(System.in);
        Boolean exit = false;
        char choice;

        while(!exit) {
            System.out.println("Input 's' for students, 'i' for instructors, or 'x' to exit");
            choice = input.next().charAt(0);
            if (choice == 'x') {
                exit = true;
            }
            else if (choice == 's') {
                studentView.displayData();
            }
            else if (choice == 'i') {
                instructorView.displayData();
            }
            System.out.println();
        }
    }
}
