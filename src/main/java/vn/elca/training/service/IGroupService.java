package vn.elca.training.service;

import vn.elca.training.dom.Group;
import vn.elca.training.dto.GroupDto;

import java.util.List;

public interface IGroupService {
    void insertDummyData();
    List<GroupDto> getAllGroup();
}
