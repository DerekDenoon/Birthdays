import java.util.Arrays;
import java.util.stream.IntStream;

public class Birthday {
    private int birthday;

    public Birthday(int birthday) {
        this.birthday = birthday;
    }

    public Birthday() {
    }

    public int getBirthday() {
        return birthday;
    }

    public void setBirthday(int birthday) {
        this.birthday = birthday;
    }


    public static boolean threeSame(Birthday[] in){
        Birthday[] birthdays = in.clone();
        int[] birthdayCount = new int[366];
        // set birthday count to 0 for each index
        IntStream.range(0,366).forEach(i -> birthdayCount[i] = 0);

        Arrays
                // Stream of birthdays
                .stream(birthdays)
                // convert to ints based on birthday
                .mapToInt(Birthday::getBirthday)
                // for each birthday add one to the counting array
                .forEach(i -> birthdayCount[i]++);


        int threeSame = (int) Arrays
                // stream of the counting array
                .stream(birthdayCount)
                // filter the array to values greater than two (aka at least 3)
                .filter(i -> i > 2)
                // returns the count of the remaining values
                .count();

        // returns true if count is > 0 false if count == 0
        return threeSame > 0;

    }

    public static Birthday[] generateBirthdays(int numToGenerate){
        Birthday[] birthdays = new Birthday[numToGenerate];
        for (int i = 0; i < numToGenerate; i++) {
            // 0 to 365
            birthdays[i] = new Birthday((int) (Math.random() * (365)));
            if(birthdays[i].getBirthday() == 365){
                if(Math.random() < 0.75){
                    birthdays[i].setBirthday((int) (Math.random() * (364)));
                }
            }
        }
        return  birthdays;
    }
}
