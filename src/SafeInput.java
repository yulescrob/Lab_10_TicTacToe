import java.util.Scanner;
public class SafeInput {
    /**
     *
     * @param pipe Scanner to read from system.in
     * @param prompt prompts the user
     * @return the String response with nonzero length
     */
    public static String getNonZeroLenString(Scanner pipe, String prompt)
    {
        String retString = "";
        do {
            //prompt
            System.out.print("\n" +prompt+ ": ");
            retString = pipe.nextLine();
        }while (retString.length()==0); //loops while the String length is zero
        return retString;
    }

    /**
     *
     * @param pipe Scanner to read System.in
     * @param prompt prompts the user
     * @return an integer
     */
    public static int getInt(Scanner pipe, String prompt)
    {
        int result = 0;
        boolean done = false;
        String trash = "";
        do {
            //prompt
            System.out.print("\n" + prompt + ": ");
            if (pipe.hasNextInt())
            {
                result = pipe.nextInt();
                pipe.nextLine(); //clear buffer
                done=true;
            }
            else //false and input will be in trash variable
            {
                trash = pipe.nextLine();
                System.out.println("You must enter an integer " + trash);
            }
        }while (!done); // not done when it is not an integer
        return result; // return the integer
    }

    /**
     *
     * @param pipe scanner to read System.in
     * @param prompt message to display as the prompt for input
     * @return a double
     */
    public static double getDouble(Scanner pipe, String prompt)
    {
        double result = 0;
        boolean done = false;
        String trash = "";
        do {
            //prompt
            System.out.print("\n" + prompt + ":");
            if (pipe.hasNextDouble())// if double then it take input as result
            {
                result = pipe.nextDouble();
                pipe.nextLine(); //clear buffer
                done = true;
            }
            else //if not double then input goes to trash
            {
                trash = pipe.nextLine();
                System.out.println("You must enter a double " + trash);
            }
        }while (!done);
        return result;
    }

    /**
     *
     * @param pipe Scanner reading form System.in
     * @param prompt message to display for the input range
     * @param lo lower value for input range
     * @param hi higher value for inpput range
     * @return integer in range
     */

    public static int getRangedInt(Scanner pipe, String prompt, int lo, int hi)
    {
        int result = 0;
        boolean done = false;
        String trash="";
        do {
            //prompt
            System.out.print(prompt + " [" + lo + " - " + hi + "]: ");
            if (pipe.hasNextInt()) //checking if integer
            {
                result = pipe.nextInt();
                pipe.nextLine(); //clear buffer
                if (result >= lo && result <= hi) //checking if in range
                {
                    done = true;
                }
                else
                {
                    System.out.println("You must enter a value in range [" + lo + " - " + hi + "]: " + result);
                }

            }
            else
            {
                trash = pipe.nextLine();
                System.out.println("You must enter an integer [" + lo + " - " + hi + "]: " + trash);

            }
        }while (!done);
        return result;
    }

    /**
     *
     * @param pipe Scanner reading from System.in
     * @param prompt message to display for input
     * @param lo low value for the input range
     * @param hi high value for the input range
     * @return double in range
     */

    public static double getRangedDouble(Scanner pipe, String prompt, double lo, double hi)
    {
        double result = 0;
        boolean done = false;
        String trash = "";
        do {
            //prompt
            System.out.print(prompt + " [" +lo+ " - " +hi+ "]: ");
            if (pipe.hasNextDouble()) //checking if double
            {
                result= pipe.nextDouble();
                pipe.nextLine(); //clears scanner
                if (result >= lo && result <= hi) //checking if in range
                {
                    done = true;
                }
                else
                {
                    System.out.println("You must enter a value in range [" +lo+ " - " +hi+ "]: " + result);
                }
            }
            else
            {
                trash = pipe.nextLine();
                System.out.println("You must enter a double [" +lo+ " - " +hi+ "]: " + trash);
            }
        }while (!done);
        return result;
    }

    /**
     *
     * @param pipe Scanner reading in System.in
     * @param prompt message as the prompt for input
     * @return returning true for yes and false for no
     */
    public static boolean getYNConfirm(Scanner pipe, String prompt)
    {
        boolean YNConfirm = false; // return starts as false
        String YNResponse = "";
        boolean done = false;
        do {
            //prompt
            System.out.print("\n" + prompt + "? [Y/N] ");
            YNResponse = pipe.nextLine();
            if (YNResponse.equalsIgnoreCase("N")|| YNResponse.equalsIgnoreCase("Y"))
            {
                done=true;
            }
        }while(!done); //will loop until input is Y or N
        if (YNResponse.equals("Y")) //if input is Y then it will return as true
        {
            YNConfirm = true;
        }
        return YNConfirm;
    }

    /**
     *
     * @param pipe Scanner reading in System.in
     * @param prompt message as the prompt for input
     * @param regEx the regEx pattern in String format to use for matching
     * @return String that matches
     */
    public static String getRegExString(Scanner pipe, String prompt, String regEx)
    {
        String value = "";
        boolean gotAValue = false;

        do {
            //prompt
            System.out.print("\n" + prompt + ": ");
            //input data
            value = pipe.nextLine();
            //test to see if correct
            if (value.matches(regEx))
            {
                //we have a match
                gotAValue = true;
            }
            else
            {
                System.out.println("\nInvalid input: " + value);
            }

        }while (!gotAValue);
        return value;
    }
}