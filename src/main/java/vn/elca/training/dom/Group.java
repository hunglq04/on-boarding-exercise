package vn.elca.training.dom;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "\"GROUP\"")
public class Group implements Serializable {
    @Id@GeneratedValue
    private Long id;
    @Column
    private String name;
    @ManyToOne(fetch = FetchType.LAZY)
    private Employee employee;
    @OneToMany(mappedBy = "group")
    private List<Project> projects;
}
