import javax.swing.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Scanner;



    public class PersonReader {
        public static void main(String[] args) {


            JFileChooser chooser = new JFileChooser();
            Scanner inFile;
            String line;
            //added ArrayList to store people
            ArrayList<Person> people = new ArrayList<>();


            Path target = new File(System.getProperty("user.dir")).toPath();
            target = target.resolve("src");
            // set the chooser to the project src directory
            chooser.setCurrentDirectory(target.toFile());

            try
            {

                if (chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
                    target = chooser.getSelectedFile().toPath();  // this is a File object not a String filename

                    inFile = new Scanner(target);

                    while (inFile.hasNextLine()) {
                        line = inFile.nextLine();
                        System.out.println(line);
                        String[] fields = line.split(",");

                        String ID = fields[0].trim();
                        String firstName = fields[1].trim();
                        String lastName = fields[2].trim();
                        String title = fields[3].trim();
                        int YOB = Integer.parseInt(fields[4].trim());

                        Person person = new Person(firstName, lastName, ID, title, YOB);
                        people.add(person);  // Add the Person to the list
                    }
                //moved print header here
                    // Print the header
                    System.out.println(String.format("%-10s %-15s %-15s %-10s %-5s", "ID", "FirstName", "LastName", "Title", "YOB"));
                    System.out.println("-----------------------------------------------------------");
                    for (Person Person : people) {
                        System.out.println(String.format("%-10s %-15s %-15s %-10s %-5d",
                                Person.getID(), Person.getFirstName(), Person.getLastName(), Person.getTitle(), Person.getYOB()));
                    }

                } else   // User did not pick a file, closed the chooser
                {
                    System.out.println("Sorry, you must select a file! Termininating!");
                    System.exit(0);
                }
            } catch (FileNotFoundException e) {
                System.out.println("File Not Found Error");
                e.printStackTrace();
            } catch (IOException e) // code to handle this exception
            {
                System.out.println("IOException Error");
                e.printStackTrace();
            }
            catch (Exception e) {
                System.out.println("An error occurred while processing the file.");
                e.printStackTrace();
            }
        }
    }
