package vn.elca.training.service;

import java.util.List;

import vn.elca.training.dom.Project;
import vn.elca.training.dto.EmployeeDto;
import vn.elca.training.dto.ProjectDto;

public interface IProjectService {
    List<Project> findAll();
    List<Project> findByNameContain(String prjName);
    Project findById(long id);
    void save(Project project);
    List<EmployeeDto> getMembersOfProject(String name);
    List<ProjectDto> getProjectByGroupId(String name);
    void maintainProjects() throws Exception;
}
