package vn.elca.training.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.elca.training.dao.IProjectRepository;
import vn.elca.training.dom.Project;

import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Service
public class ProjectService implements IProjectService {

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
    public void insertDummyData() {
        List<Project> dummyData = Arrays.asList(
                new Project("Plan to go tin stages", new Date(120, Calendar.JANUARY, 15)),
                new Project("Pack for the trip", new Date(120, Calendar.FEBRUARY, 15)),
                new Project("Determine the launch window", new Date(120, Calendar.MARCH, 15)),
                new Project("Lift off", new Date(120, Calendar.APRIL, 5)),
                new Project("Achieve low Earth orbit", new Date(120, Calendar.APRIL, 10)),
                new Project("Transition to a trans-lunar trajectory", new Date(120, Calendar.APRIL, 15)),
                new Project("Achieve lunar orbit", new Date(120, Calendar.APRIL, 20)),
                new Project("Transfer to the lunar lander", new Date(120, Calendar.MAY, 5)),
                new Project("Descend to the moon’s surface", new Date(120, Calendar.MAY, 10)),
                new Project("Explore", new Date(120, Calendar.MAY, 15)),
                new Project("Pack up and go home", new Date(120, Calendar.JUNE, 15)),
                new Project("Dock with the orbiting vessel", new Date(120, Calendar.JULY, 5)),
                new Project("Head back to Earth", new Date(120, Calendar.JULY, 10)),
                new Project("Go for a landing", new Date(120, Calendar.JULY, 15)));
        projectRepository.save(dummyData);
    }
}
