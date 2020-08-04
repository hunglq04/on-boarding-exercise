package vn.elca.training.dom;

import lombok.AccessLevel;
import lombok.Data;
import lombok.Getter;
import org.springframework.format.annotation.DateTimeFormat;
import vn.elca.training.constant.Status;
import vn.elca.training.constant.StringConst;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data
public class Project implements Serializable {
    @Id
    @GeneratedValue
    private Long id;
    @Column(nullable = false)
    @Size(min = 3, max = 100, message = "Enter name with length from 3-100")
    private String name;
    @Column
    @NotNull(message = "Finishing date is required")
    @DateTimeFormat(pattern = StringConst.DATE_PATTERN)
    private Date finishingDate;
    @Column
    @Enumerated(value = EnumType.STRING)
    private Status status;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn
    private Employee leader;

	@OneToMany(mappedBy = "project", fetch = FetchType.LAZY)
	private Set<Task> tasks = new HashSet<>();

	@OneToMany(mappedBy = "project")
    private Set<EmployeeProject> employees;

	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn
    private Group group;

    public Project() {
    }

    public Project(String name, Date finishingDate, Status status, Employee leader, Group group) {
        this.name = name;
        this.finishingDate = finishingDate;
        this.status = status;
        this.leader = leader;
        this.group = group;
    }

    public Project(String name, Date finishingDate) {
        this.name = name;
        this.finishingDate = finishingDate;
        this.status = Status.NEW;
    }

    public Project(Long id, String name, Date finishingDate, Status status) {
        this.id = id;
        this.name = name;
        this.finishingDate = finishingDate;
        this.status = status;
    }
}