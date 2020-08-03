package vn.elca.training.service;

import vn.elca.training.dom.Group;

import java.util.List;

public interface IGroupService {
    void insertDummyData();
    List<Group> getAll();
}
