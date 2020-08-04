package vn.elca.training.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.elca.training.constant.Status;
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
//        List<Project> dummyData = Arrays.asList(
//                new Project("EFV", new Date(119, Calendar.JANUARY, 15), Status.FINISHED),
//                new Project("CXTRANET", new Date(120, Calendar.FEBRUARY, 15), Status.FINISHED),
//                new Project("Determine the launch window", new Date(120, Calendar.MARCH, 15), Status.FINISHED),
//                new Project("Lift off", new Date(120, Calendar.APRIL, 5), Status.FINISHED),
//                new Project("Achieve low Earth orbit", new Date(120, Calendar.APRIL, 10), Status.FINISHED),
//                new Project("Transition to a trans-lunar trajectory", new Date(120, Calendar.APRIL, 15), Status.IN_PROGRESS),
//                new Project("CRYSTAL BALL", new Date(121, Calendar.APRIL, 20), Status.IN_PROGRESS),
//                new Project("IOC CLIENT EXTRANET", new Date(122, Calendar.MAY, 5), Status.IN_PROGRESS),
//                new Project("Descend to the moon’s surface", new Date(120, Calendar.MAY, 10), Status.IN_PROGRESS),
//                new Project("Explore", new Date(120, Calendar.MAY, 15), Status.IN_PROGRESS),
//                new Project("Pack up and go home", new Date(120, Calendar.JUNE, 15), Status.NEW),
//                new Project("Dock with the orbiting vessel", new Date(120, Calendar.JULY, 5), Status.NEW),
//                new Project("Head back to Earth", new Date(120, Calendar.JULY, 10), Status.NEW),
//                new Project("KSTA MIGRATION", new Date(123, Calendar.JULY, 15), Status.NEW));
//        projectRepository.save(dummyData);
    }
}
