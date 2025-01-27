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
/* Code not currently needed anymore
        String personRec = "";
        String ID = "";
        String firstName = "";
        String lastName = "";
        String title = "";
        int YOB = 0;
*/
        do {
            String ID = SafeInput.getNonZeroLenString(in, "Enter the ID [6 digits]: ");
            String firstName = SafeInput.getNonZeroLenString(in, "Enter the first name:");
            String lastName = SafeInput.getNonZeroLenString(in, "Enter the last name: ");
            String title = SafeInput.getNonZeroLenString(in, "Enter the title ");
            int YOB = SafeInput.getRangedInt(in, "Enter the year of birth [1900-2020]: ", 1900, 2020);
/* Code not currently needed anymore
            personRec = ID + "," + firstName + "," + lastName + "," + title + "," + YOB;
            folks.add(personRec);*/
            Person person = new Person(firstName, lastName, ID, title, YOB);
            folks.add(person);
            //changed prompt to be more clear
            done = SafeInput.getYNConfirm(in, "Are you done adding persons? (y/n)? ");


        } while (!done);
        for (Person person : folks) {
            System.out.println(person.toCSV());
        }

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file.toFile())))
        {

                for (Person person : folks) {
                    writer.write(person.toCSV());
                    writer.newLine();
                }
            System.out.println("Data file written!");

            /* replaced the following line with the one above
            for(String rec : folks)
            {
                writer.write(rec, 0, rec.length());
                writer.newLine();

            }
            writer.close();
            System.out.println("Data file written!");

             */
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }
}
