package java8feature;

public class Student {
    String name;
    int rank;
    String state;
    String department;
    String contactNumber;
    int age;
    String gender;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Student(String name, int rank, String state, String department, String contactNumber, int age, String gender) {
        this.name = name;
        this.rank = rank;
        this.state = state;
        this.department = department;
        this.contactNumber = contactNumber;
        this.age = age;
        this.gender = gender;
    }

    public Student() {
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", rank=" + rank +
                ", state='" + state + '\'' +
                ", department='" + department + '\'' +
                ", contactNumber='" + contactNumber + '\'' +
                ", age=" + age +
                ", gender='" + gender + '\'' +
                '}';
    }
}
