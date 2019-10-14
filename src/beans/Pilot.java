package beans;

public class Pilot {
    private String name;
    private String surname;
    private String middleName;
    private float experience;

    Pilot(String name, String surname, String middleName, float experience){
        this.name = name;
        this.surname = surname;
        this.middleName = middleName;
        this.experience = experience;
    }

    public String getInitials(){
        return String.format("%s %c.%c.", surname, name.charAt(0), middleName.charAt(0));
    }

    public float getExperience(){
        return this.experience;
    }

    public void incExperience(){
        this.experience += 0.5;
    }

}
