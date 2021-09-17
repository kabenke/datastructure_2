public class Student implements Comparable<Student>
{
    private String name;
    private String subject;
    private int registrationNo;

    public Student( String n, String sub, int no ) {
        name = n;
        subject = sub;
        registrationNo = no;
    }

    public String toString() {
        return "student: " + name + 
        ", registration number: " + registrationNo + 
        "(" + subject + ")";
    }

    public String getName() 
    {
        return name;
    }

    public String getSubject() 
    {
        return subject;
    }

    public int getRegistrationNo() 
    {
        return registrationNo;
    }

    public int compareTo( Student s )
    {
        return getRegistrationNo() - s.getRegistrationNo();
    }
}