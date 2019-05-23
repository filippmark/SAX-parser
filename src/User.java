import java.util.ArrayList;

public class User {
    private ArrayList<String> skills;
    private String UID, name, email;
    private String city, address, gender, phone;

    public User(String UID, String name, String email, String city, String addres, String gender, String phone, ArrayList<String> skills){
        this.UID = UID;
        this.name = name;
        this.email = email;
        this.city = city;
        this.address = address;
        this.gender = gender;
        this.phone = phone;
        this.skills = skills;
    }

    public String getCity() {
        return city;
    }

    public String getEmail() {
        return email;
    }

    public String getGender() {
        return gender;
    }

    public String getPhone() {
        return phone;
    }

    public String getName() {
        return name;
    }

    public String getUID() {
        return UID;
    }


    public String getAddres() {
        return address;
    }

    public ArrayList<String> getSkills() {
        return skills;
    }
}
