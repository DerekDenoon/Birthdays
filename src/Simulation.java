import java.util.stream.IntStream;

public class Simulation {
    public static void main(String[] args) {
        Birthday[] birthdays = new Birthday[100];
        //MAKE GENERATOR FUNCTION
        for (int i = 0; i < 100; i++) {

            birthdays[i] = new Birthday((int) (Math.random() * 10 ));


        }

        System.out.println(Birthday.threeSame(birthdays));
    }
}
