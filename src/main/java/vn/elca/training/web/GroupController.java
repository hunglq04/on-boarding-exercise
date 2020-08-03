package vn.elca.training.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import vn.elca.training.dom.Group;
import vn.elca.training.service.IGroupService;

import java.util.List;

@Controller
@RequestMapping("/group")
public class GroupController {

    @Autowired
    private IGroupService groupService;

    @RequestMapping("")
    @ResponseBody
    List<Group> getGroups() {
        groupService.insertDummyData();
        return groupService.getAll();
    }
}
