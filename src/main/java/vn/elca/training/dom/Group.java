package vn.elca.training.dom;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@Table(name = "\"GROUP\"")
public class Group implements Serializable {
    @Id@GeneratedValue
    private Long id;
    @Column
    private String name;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn
    private Employee leader;
//    @OneToMany(mappedBy = "group", fetch = FetchType.LAZY)
//    @JsonIgnore
//    private List<Project> projects;

    public Group() {
        this.leader = new Employee();
    }
}
