package tina.doma.Model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "project")
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private String description;
    private enum status{
        IN_PROGRESS,
        DONE
    }
    @ManyToOne
    @JoinColumn(name = "intern_id", nullable = false)
    @JsonBackReference
    Intern intern;

}
