package vn.elca.training.service;

import java.util.List;

import vn.elca.training.dom.Project;

public interface IProjectService {
    List<Project> findAll();
    List<Project> findByNameContain(String prjName);
    Project findById(long id);
    void save(Project project);
    void insertDummyData();
}
