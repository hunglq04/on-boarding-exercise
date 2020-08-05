package vn.elca.training.service;

import com.mysema.query.jpa.JPASubQuery;
import com.mysema.query.jpa.impl.JPAQuery;
import com.mysema.query.types.ConstructorExpression;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import vn.elca.training.constant.Status;
import vn.elca.training.dao.IProjectRepository;
import vn.elca.training.dom.*;
import vn.elca.training.dto.EmployeeDto;
import vn.elca.training.dto.ProjectDto;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.time.Year;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Service
public class ProjectService implements IProjectService {

    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    private IProjectRepository projectRepository;

    @Override
    public List<Project> findAll() {
        return projectRepository.findAll();
    }

    @Override
    public List<Project> findByNameContain(String prjName) {
        return projectRepository.findByNameContainingIgnoreCase(prjName);
    }

    @Override
    public Project findById(long id) {
        return projectRepository.findOne(id);
    }

    @Override
    public void save(Project project) {
        Project oldProject = projectRepository.findOne(project.getId());
        oldProject.setName(project.getName());
        oldProject.setFinishingDate(project.getFinishingDate());
        projectRepository.save(project);
    }

    @Override
    public List<EmployeeDto> getMembersOfProject(String name) {
        QEmployee employee = new QEmployee("employee");
        QEmployeeProject employeeProject = new QEmployeeProject("employeeProject");
        QEmployeeRole employeeRole = new QEmployeeRole("employeeRole");
        QRole role = new QRole("role");
        QProject project = new QProject("project");
        return new JPAQuery(entityManager)
                .from(employeeRole)
                .innerJoin(employeeRole.employee, employee)
                .innerJoin(employeeRole.role, role)
                .where(employee.in(
                    new JPASubQuery()
                        .from(employeeProject)
                        .innerJoin(employeeProject.employee, employee)
                        .innerJoin(employeeProject.project, project)
                        .where(project.name.eq(name).and(role.name.notIn("Group Leader", "Project Leader")))
                        .list(employee)
                ))
                .list(ConstructorExpression.create(EmployeeDto.class, employee.visa, role.name));
    }

    @Override
    public List<ProjectDto> getProjectByGroupId(String name) {
        List<ProjectDto> projects = new JPAQuery(entityManager)
                .from(QProject.project)
                .innerJoin(QProject.project.leader, QEmployee.employee)
                .innerJoin(QProject.project.group, QGroup.group)
                .where(QGroup.group.name.eq(name))
                .list(ConstructorExpression.create(ProjectDto.class, QProject.project.name, QEmployee.employee.visa));
        projects.forEach(p -> {
            String prjName = p.getProjectName();
            p.setMember(getMembersOfProject(prjName));
        });
        return projects;
    }

    @Override
    @Transactional
    public void maintainProjects() throws Exception {
        List<Project> oldProjects = projectRepository.findProjectsByFinishingDateGreaterThanEqual(new Date());
        List<Project> maintenanceProjects = new ArrayList<>();
        oldProjects.forEach(p -> {
            p.setStatus(Status.FINISHED);
            maintenanceProjects.add(Project.builder()
                            .name(p.getName() + " Maintenance " + Year.now().toString())
                            .finishingDate(addYear(p.getFinishingDate(), 1))
                            .leader(p.getLeader())
                            .group(p.getGroup())
                            .status(Status.IN_PROGRESS)
                            .build());
        });
        projectRepository.save(oldProjects);
        projectRepository.save(maintenanceProjects);
        throw new RuntimeException("Check Rollback");
    }

    public static Date addYear(Date year, int plus) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(year);
        cal.add(Calendar.YEAR, plus);
        return cal.getTime();
    }

}
