package tina.doma.Model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "intern")
public class Intern {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public long id;
    public String name;
    public int age;
    public String description;

    @Override
    public String toString(){
        return "Intern" + name + " (" + age + ")" + description;
    }
}
