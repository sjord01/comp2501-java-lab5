/**
 * Represents a person with attributes such as first name, last name, birth year, marital status,
 * weight, and education level. Provides constructors to initialize a person object with different
 * combinations of attributes and methods to retrieve and print the details of the person.
 *
 * @author Sam Ordonez, Joshua Lee, Yeongsuk Oh
 * @version 1.0
 */
public class Person
{
    private final String    firstName;
    private final String    lastName;
    private final int       birthYear;

    private String married;
    private double weightLbs;
    private String educationLevel;

    //public static final int CURRENT_YEAR = Calendar.getInstance().get(Calendar.YEAR);
    public static final int CURRENT_YEAR = 2024;

    /**
     * Constructor to initialize a Person object with all attributes provided.
     * @param firstName      The first name of the person.
     * @param lastName       The last name of the person.
     * @param birthYear      The birth year of the person.
     * @param married        The marital status of the person.
     * @param weightLbs      The weight of the person in pounds.
     * @param educationLevel The highest education level attained by the person.
     * @throws IllegalArgumentException if the education level or marital status is invalid.
     */
    public Person(final String  firstName,
                  final String  lastName,
                  final int     birthYear,
                  final String  married,
                  final double  weightLbs,
                  final String educationLevel)
    {
        if(!isValidEducationLevel(educationLevel))
        {
            throw new IllegalArgumentException("Invalid education level");
        }
        if(!isValidMarriageStatus(married))
        {
            throw new IllegalArgumentException("Invalid marriage status");
        }

        this.firstName          = firstName;
        this.lastName           = lastName;
        this.birthYear          = birthYear;
        this.married            = married;
        this.weightLbs          = weightLbs;
        this.educationLevel     = educationLevel;
    }


    /**
     * Constructor to initialize a Person object with five attributes provided,
     * setting the birth year automatically to the current year.
     * @param firstName      The first name of the person.
     * @param lastName       The last name of the person.
     * @param married        The marital status of the person.
     * @param weightLbs      The weight of the person in pounds.
     * @param educationLevel The highest education level attained by the person.
     * @throws IllegalArgumentException if the education level or marital status is invalid.
     */
    public Person(final String firstName,
                  final String lastName,
                  final String married,
                  final double weightLbs,
                  final String educationLevel)
    {
        if(!isValidEducationLevel(educationLevel))
        {
            throw new IllegalArgumentException("Invalid education level");
        }
        if(!isValidMarriageStatus(married))
        {
            throw new IllegalArgumentException("Invalid marriage status");
        }

        this.firstName          = firstName;
        this.lastName           = lastName;
        this.birthYear          = CURRENT_YEAR;
        this.married            = married;
        this.weightLbs          = weightLbs;
        this.educationLevel     = educationLevel;
    }

    /**
     * Constructor to initialize a Person object with three attributes provided,
     * setting the birth year automatically to the current year, marital status to "no",
     * and education level to "high school".
     * @param firstName The first name of the person.
     * @param lastName  The last name of the person.
     * @param weight    The weight of the person in pounds.
     */
    public Person(final String firstName,
                  final String lastName,
                  final double weight)
    {
        if(!isValidEducationLevel(educationLevel))
        {
            throw new IllegalArgumentException("Invalid education level");
        }
        if(!isValidMarriageStatus(married))
        {
            throw new IllegalArgumentException("Invalid marriage status");
        }

        this.firstName          = firstName;
        this.lastName           = lastName;
        this.birthYear          = CURRENT_YEAR;
        this.married            = "no";
        this.weightLbs          = weight;
        this.educationLevel     = "highschool";

    }

    /**
     * Validates if a user-input for education level is acceptable or not
     * it can only be "high school", "undergraduate", or "graduate"; case-insensitive
     * @param educationLevelToVerify    the education level status of a person; in this program
     *                                  it can only be "high school", "undergraduate", or "graduate"
     * @return                          True or False; true if status is == "high school", "undergraduate", or "graduate",
     *                                  else false
     */
    private boolean isValidEducationLevel(String educationLevelToVerify)
    {
        return  educationLevelToVerify.equalsIgnoreCase("high school") ||
                educationLevelToVerify.equalsIgnoreCase("undergraduate") ||
                educationLevelToVerify.equalsIgnoreCase("graduate");
    }

    /**
     * Validates the marriage status of a person;
     * it can only be "yes" (meaning "married"), "no"(meaning "single"), or "divorced"; case-insensitive
     * @param marriageStatusToVerify    the marriage status of a person; in this program
     *                                  it can only be "yes", "no", or "divorced"
     * @return                          True or False; true if status is "yes", "no", or "divorced",
     *                                  else false
     */
    private boolean isValidMarriageStatus(String marriageStatusToVerify)
    {
        return  marriageStatusToVerify.equals("yes") ||
                marriageStatusToVerify.equals("no") ||
                marriageStatusToVerify.equals("divorced");
    }

    /**
     * Returns the first name of the person
     * @return the first name of the person
     */
    public String getFirstName()
    {
        return firstName;
    }

    /**
     * Returns the last name of a person
     * @return the last name of the person
     */
    public String getLastName()
    {
        return lastName;
    }

    /**
     * Returns the birth year of a person
     * @return the birth year of a person
     */
    public int getBirthYear()
    {
        return birthYear;
    }

    /**
     * Returns the marriage status of a person
     * @return the marriage status of a person
     */
    public String getMarried()
    {
        return married;
    }

    /**
     * Returns the weight of a person in pounds(lbs)
     * @return the weight of a person in pounds(lbs)
     */
    public double getWeight()
    {
        return weightLbs;
    }

    /**
     * Returns the education level of a person
     * @return the education level of a person
     */
    public String getEducationLevel()
    {
        return educationLevel;
    }

    /**
     * Verifies if a person is married or not
     * @return True or False; verifies if a person is married or not
     */
    public boolean isMarried()
    {
        return married.equalsIgnoreCase("yes");
    }

    /**
     * Sets the weight of the person.
     * @param weightLbs The weight of the person in pounds.
     */
    public void setWeight(final double weightLbs)
    {
        this.weightLbs = weightLbs;
    }

    /**
     * Sets the marital status of the person.
     * @param married                   The marital status of the person.
     *                                  It can be "yes", "no", or "divorced"; case-insensitive.
     * @throws IllegalArgumentException if the provided marital status is invalid.
     */
    public void setMarried(final String married)
    {
        isValidMarriageStatus(married);
        this.married = married;
    }

    /**
     * Sets the education level of the person.
     * @param educationLevel            The highest education level attained by the person.
     *                                  It can be "high school", "undergraduate", or "graduate"; case-insensitive.
     * @throws IllegalArgumentException if the provided education level is invalid.
     */
    public void setEducationLevel(final String educationLevel)
    {
        isValidEducationLevel(educationLevel);
        this.educationLevel = educationLevel;
    }



    /**
     * Method to print the details of a person with default formatting options.
     */
    public void printDetails()
    {
        System.out.println(formatDetails(false, false));
    }

    /**
     * Method to print the details of a person with specified weight unit.
     * @param kilograms Indicates whether the weight should be displayed in kilograms.
     */
    public void printDetails(final boolean kilograms)
    {
        System.out.println(formatDetails(kilograms, false));
    }

    /**
     * Method to print the details of a person with specified formatting options.
     * @param kilograms Indicates whether the weight should be displayed in kilograms.
     * @param uppercase Indicates whether the output should be in uppercase.
     */
    public void printDetails(final boolean kilograms,
                             final boolean uppercase)
    {
        System.out.println(formatDetails(kilograms, uppercase));
    }

    /**
     * Formats the details of a person including their name, marital status, birth year,
     * weight, weight unit, and education level.
     * @param kilograms Indicates whether the weight should be displayed in kilograms.
     * @param uppercase Indicates whether the output should be in uppercase.
     * @return A formatted string containing the person's details.
     */
    private String formatDetails(final boolean kilograms,
                                 final boolean uppercase)
    {
        final String name;
        final String maritalStatus;
        final String formattedMaritalStatus;
        final double weight;
        final String weightUnit;

        if(uppercase)
        {
            name            = (firstName + " " + lastName).toUpperCase();
            maritalStatus   = married.toUpperCase();
        }
        else
        {
            name            = (firstName + " " + lastName).toLowerCase();
            maritalStatus   = married.toLowerCase();
        }

        if(maritalStatus.equalsIgnoreCase("yes"))
        {
            if(uppercase)
            {
                formattedMaritalStatus = "MARRIED";
            }
            else
            {
                formattedMaritalStatus = "married";
            }
        }
        else
        {
            if(uppercase)
            {
                formattedMaritalStatus = "SINGLE";
            }
            else
            {
                formattedMaritalStatus = "single";
            }
        }

        if(kilograms)
        {
            weight = convertToKilograms();
        }
        else
        {
            weight = weightLbs;
        }

        if(kilograms)
        {
            weightUnit = "kilograms";
        }
        else
        {
            weightUnit = "pounds";
        }

        if(educationLevel.equalsIgnoreCase("undergraduate"))
        {
            return String.format(   "%s (%s) was born in %d, weighs %.1f %s, and has an %s degree!",
                                    name, maritalStatus, birthYear, weight, weightUnit, educationLevel);
        }

        if(educationLevel.equalsIgnoreCase("graduate"))
        {
            return String.format(   "%s (%s) was born in %d, weighs %.1f %s, and has a %s degree!",
                                    name, formattedMaritalStatus, birthYear, weight, weightUnit, educationLevel);
        }
        return String.format(   "%s (%s) was born in %d, weighs %.1f %s, and has a %s diploma!",
                                name, formattedMaritalStatus, birthYear, weight, weightUnit, educationLevel);
    }

    /**
     * Converts a person's weight from kilograms(kgs) to pounds(lbs)
     * @return weight of person in lbs
     */
    private double convertToKilograms()
    {
        return weightLbs / 2.2;
    }

    public static void main(final String[] args)
    {
        Person p1;
        Person p2;
        Person p3;
        p1 = new Person("Tiger", "Woods", 1975, "divorced", 200, "undergraduate");
        p1.printDetails();

        p1.printDetails(true);
        p1.printDetails(true, true);
        p1.printDetails(true, false);
        p1.printDetails(false, true);
        p1.printDetails(false, false);
        p2 = new Person("Jason", "Wilder", 2000, "no", 180, "graduate");
        p2.printDetails();
        p2.printDetails(true);
        p2.printDetails(true, true);
        p2.printDetails(true, false);
        p2.printDetails(false, true);
        p2.printDetails(false, false);
        p3 = new Person("Santa", "Claus", 1000, "yes", 280, "high school");
        p3.printDetails();
        p3.printDetails(true);
        p3.printDetails(true, true);
        p3.printDetails(true, false);
        p3.printDetails(false, true);
        p3.printDetails(false, false);
    }
}