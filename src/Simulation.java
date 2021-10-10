import java.util.stream.IntStream;

public class Simulation {
    public static void main(String[] args) {
        System.out.println(simuluate(87,10000));

    }


    public static double simuluate(int numToGenerate, int trials){
        Birthday[] birthdays;
        double threeSame = 0;

        for (int i = 0; i < trials; i++) {
            birthdays = Birthday.generateBirthdays(numToGenerate);
            if (Birthday.threeSame(birthdays)){
                threeSame++;
            }
        }

        threeSame = threeSame / trials;

        return threeSame;
    }
}
