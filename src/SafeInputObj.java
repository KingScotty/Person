import java.util.Scanner;

public class SafeInputObj {
    private Scanner pipe;

    // Default constructor: Uses System.in
    public SafeInputObj() {
        this.pipe = new Scanner(System.in);
    }

    // Constructor with Scanner parameter
    public SafeInputObj(Scanner scanner) {
        this.pipe = scanner;
    }

    public static String getNonZeroLenString(Scanner in, String s) {
        return null;
    }


    /**
     * Get a String which contains at least one character
     * @param prompt prompt for the user
     * @return a String response that is not zero length
     */
    public String getNonZeroLenString(String prompt) {
        String retString = "";
        do {
            System.out.print("\n" + prompt + ": ");
            retString = pipe.nextLine();
        } while (retString.length() == 0);
        return retString;
    }


    /**
     * Get a String of at least a minimum length
     * @param prompt prompt for the user
     * @param minLen minimum length required
     * @return a valid string
     */
    public String getMinLenString(String prompt, int minLen) {
        String retString = "";
        do {
            System.out.print("\n" + prompt + "[ >= " + minLen + " chars]: ");
            retString = pipe.nextLine();
            if (retString.length() < minLen)
                System.out.println("Too short! Must be at least " + minLen + " chars long!");
        } while (retString.length() < minLen);
        return retString;
    }

    /**
     * Get an int value within a specified numeric range
     * @param prompt input prompt msg should not include range info
     * @param low low end of inclusive range
     * @param high high end of inclusive range
     * @return an int value within the inclusive range
     */
    public int getRangedInt(String prompt, int low, int high) {
        int retVal = 0;
        String trash;
        boolean done = false;
        do {
            System.out.print("\n" + prompt + "[" + low + "-" + high + "]: ");
            if (pipe.hasNextInt()) {
                retVal = pipe.nextInt();
                pipe.nextLine();
                if (retVal >= low && retVal <= high) {
                    done = true;
                } else {
                    System.out.println("\nNumber is out of range [" + low + "-" + high + "]: " + retVal);
                }
            } else {
                trash = pipe.nextLine();
                System.out.println("You must enter an int: " + trash);
            }
        } while (!done);
        return retVal;
    }

    public double getDouble(String prompt) {
        double retVal = 0;
        String trash = "";
        boolean done = false;

        do {
            System.out.print("\n" + prompt + ": ");
            if (pipe.hasNextDouble()) {
                retVal = pipe.nextDouble();
                pipe.nextLine();
                done = true;
            } else {
                trash = pipe.nextLine();
                System.out.println("You must enter a double: " + trash);
            }
        } while (!done);

        return retVal;
    }


    /**
     * Get a double value within an inclusive range
     * @param prompt input prompt msg should not contain range info
     * @param low low value inclusive
     * @param high high value inclusive
     * @return a double value within the specified inclusive range
     */
    public double getRangedDouble(String prompt, int low, int high) {
        double retVal = 0;
        String trash;
        boolean done = false;
        do {
            System.out.print("\n" + prompt + "[" + low + "-" + high + "]: ");
            if (pipe.hasNextDouble()) {
                retVal = pipe.nextDouble();
                pipe.nextLine();
                if (retVal >= low && retVal <= high) {
                    done = true;
                } else {
                    System.out.println("\nNumber is out of range [" + low + "-" + high + "]: " + retVal);
                }
            } else {
                trash = pipe.nextLine();
                System.out.println("You must enter a double: " + trash);
            }
        } while (!done);
        return retVal;
    }

    /**
     * Get a [Y/N] confirmation from the user
     * @param prompt input prompt msg for user does not need [Y/N]
     * @return true for yes, false for no
     */
    public boolean getYNConfirm(String prompt) {
        boolean retVal = true;
        String response;
        boolean gotAVal = false;
        do {
            System.out.print("\n" + prompt + " [Y/N]: ");
            response = pipe.nextLine();
            if (response.equalsIgnoreCase("Y")) {
                gotAVal = true;
                retVal = true;
            } else if (response.equalsIgnoreCase("N")) {
                gotAVal = true;
                retVal = false;
            } else {
                System.out.println("You must answer [Y/N]! " + response);
            }
        } while (!gotAVal);
        return retVal;
    }

    /**
     * Get a string that matches a RegEx pattern
     * @param prompt prompt for user
     * @param regExPattern Java-style RegEx pattern to constrain the input
     * @return a String that matches the RegEx pattern supplied
     */
    public String getRegExString(String prompt, String regExPattern) {
        String response;
        boolean gotAVal = false;
        do {
            System.out.print("\n" + prompt + ": ");
            response = pipe.nextLine();
            if (response.matches(regExPattern)) {
                gotAVal = true;
            } else {
                System.out.println("\n" + response + " must match the pattern " + regExPattern);
                System.out.println("Try again!");
            }
        } while (!gotAVal);
        return response;
    }


    public int getSafeInput() {
        return 0;
    }

    public void setSafeInput(int i) {

    }
}
