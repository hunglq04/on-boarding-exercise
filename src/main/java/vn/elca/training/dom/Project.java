package vn.elca.training.dom;

import org.springframework.format.annotation.DateTimeFormat;
import vn.elca.training.constant.StringConst;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Project {
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

	@OneToMany(mappedBy = "project", fetch = FetchType.LAZY)
	private Set<Task> tasks = new HashSet<>();

	@OneToMany(mappedBy = "project")
    private Set<EmployeeProject> employees;

	@ManyToOne
    private Group group;

    public Project() {
    }

    public Project(String name, Date finishingDate) {
        this.name = name;
        this.finishingDate = finishingDate;
    }

    public Project(Long id, String name, Date finishingDate) {
        this.id = id;
        this.name = name;
        this.finishingDate = finishingDate;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Date getFinishingDate() {
        return finishingDate;
    }

	public Set<Task> getTasks() {
		return tasks;
	}

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setFinishingDate(Date finishingDate) {
        this.finishingDate = finishingDate;
    }

    public void setTasks(Set<Task> tasks) {
		this.tasks = tasks;
	}

    public Set<EmployeeProject> getEmployees() {
        return employees;
    }

    public void setEmployees(Set<EmployeeProject> employees) {
        this.employees = employees;
    }
}