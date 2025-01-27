import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;
public class PersonGenerator {
    public static void main(String[] args) {
        ArrayList<Person> folks = new ArrayList<>();
        Scanner in = new Scanner(System.in);

        File workingDirectory = new File(System.getProperty("user.dir"));
        Path file = Paths.get(workingDirectory.getPath() + "\\src\\personData.txt");

        Boolean done = false;

        String personRec = "";
        String ID = "";
        String firstName = "";
        String lastName = "";
        String title = "";
        int YOB = 0;

        do {
            ID = SafeInput.getNonZeroLenString(in, "Enter the ID [6 digits]: ");
            firstName = SafeInput.getNonZeroLenString(in, "Enter the first name:");
            lastName = SafeInput.getNonZeroLenString(in, "Enter the last name: ");
            title = SafeInput.getNonZeroLenString(in, "Enter the title ");
            YOB = SafeInput.getRangedInt(in, "Enter the year of birth [1900-2020]: ", 1900, 2020);

            personRec = ID + "," + firstName + "," + lastName + "," + title + "," + YOB;
            folks.add(personRec);

            done = SafeInput.getYNConfirm(in, "Another person (y/n)? ");


        } while (!done);
        for (String person : folks) {
            System.out.println(person);
        }

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file.toFile())))
        {
            for(String rec : folks)
            {
                writer.write(rec, 0, rec.length());
                writer.newLine();

            }
            writer.close();
            System.out.println("Data file written!");
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }
}
