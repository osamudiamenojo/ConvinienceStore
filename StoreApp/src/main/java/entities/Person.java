package entities;
import enums.Gender;
import lombok.Data;

@Data

public abstract class  Person {
    private String name;
    private Gender gender;

    public Person(String name, Gender gender) {

    }
}
