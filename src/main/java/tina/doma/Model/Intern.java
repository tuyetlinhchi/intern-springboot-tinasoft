package tina.doma.Model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "intern")
public class Intern {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private int age;
    private String description;
    @ManyToOne
    @JoinColumn(name = "mentor_id", nullable = false)
    @JsonBackReference
    private Mentor mentor;

    @OneToMany(mappedBy = "intern", orphanRemoval=true)
    @JsonManagedReference
    private Set<Project> projects;
    @Override
    public String toString(){
        return "Intern" + name + " (" + age + ")" + description;
    }
}
