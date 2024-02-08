import java.util.Calendar;

public class Person
{
    private final String    firstName;
    private final String    lastName;
    private final int       birthYear;
    private final String    married;
    private final double    weightLbs;

    private final String    educationLevel;

    //public static final int CURRENT_YEAR = Calendar.getInstance().get(Calendar.YEAR);
    public static final int CURRENT_YEAR = 2024;

    public Person(final String  firstName,
                  final String  lastName,
                  final int     birthYear,
                  final String  married,
                  final double  weightLbs,
                  final String educationLevel)
    {
        this.firstName          = firstName;
        this.lastName           = lastName;
        this.birthYear          = birthYear;
        this.married            = married;
        this.weightLbs          = weightLbs;
        this.educationLevel     = educationLevel;
        validateEducationLevel();
        validateMarriageStatus();
    }

    public Person(final String firstName,
                  final String lastName,
                  final String married,
                  final double weightLbs,
                  final String educationLevel)
    {

        this.firstName = firstName;
        this.lastName = lastName;
        this.birthYear = CURRENT_YEAR;
        this.married = married;
        this.weightLbs = weightLbs;
        this.educationLevel = educationLevel;
        validateEducationLevel();
        validateMarriageStatus();
    }

    public Person(final String firstName,
                  final String lastName,
                  final double weight)
    {
        this(firstName, lastName, CURRENT_YEAR, "no", weight, "high school");
    }

    private void validateEducationLevel() {
        if (!isValidEducationLevel(educationLevel)) {
            throw new IllegalArgumentException("Invalid education level");
        }
    }

    private void validateMarriageStatus() {
        if (!isValidMarriageStatus(married)) {
            throw new IllegalArgumentException("Invalid marriage status");
        }
    }

    private boolean isValidEducationLevel(String educationLevelToVerify)
    {
        return  educationLevelToVerify.equals("high school") ||
                educationLevelToVerify.equals("undergraduate") ||
                educationLevelToVerify.equals("graduate");
    }

    private boolean isValidMarriageStatus(String marriageStatusToVerify)
    {
        return  marriageStatusToVerify.equals("yes") ||
                marriageStatusToVerify.equals("no") ||
                marriageStatusToVerify.equals("divorced");
    }

    public String getFirstName()
    {
        return firstName;
    }

    public String getLastName()
    {
        return lastName;
    }

    public int getBirthYear()
    {
        return birthYear;
    }

    public String getMarried()
    {
        return married;
    }

    public double getWeight()
    {
        return weightLbs;
    }

    public String getEducationLevel()
    {
        return educationLevel;
    }

    public boolean isMarried()
    {
        return married.equals("yes");
    }

    public void printDetails()
    {
        System.out.println(formatDetails(false, false));
    }

    public void printDetails(final boolean kilograms)
    {
        System.out.println(formatDetails(kilograms, false));
    }

    public void printDetails(final boolean kilograms,
                             final boolean uppercase)
    {
        System.out.println(formatDetails(kilograms, uppercase));
    }

    private String formatDetails(final boolean kilograms,
                                 final boolean uppercase)
    {
        final String name;
        final String maritalStatus;
        final double weight;
        final String weightUnit;

        name = uppercase ? (firstName + " " + lastName).toUpperCase() : (firstName + " " + lastName).toLowerCase();
        maritalStatus = uppercase ? married.toUpperCase() : married.toLowerCase();
        weight = kilograms ? convertToKilograms() : weightLbs;
        weightUnit = kilograms ? "kilograms" : "pounds";

        return String.format("%s (%s) was born in %d, weighs %.1f %s, and has an %s degree!",
                name, maritalStatus, birthYear, weight, weightUnit, educationLevel);
    }

    private double convertToKilograms() {
        return weightLbs * 0.453592;
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