package vn.elca.training.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import vn.elca.training.dao.IProjectRepository;
import vn.elca.training.dom.Group;
import vn.elca.training.dom.Project;
import vn.elca.training.dto.EmployeeDto;
import vn.elca.training.dto.GroupDto;
import vn.elca.training.dto.ProjectDto;
import vn.elca.training.service.IGroupService;
import vn.elca.training.service.IProjectService;

import java.util.List;

//@Controller
@RequestMapping("/group")
@RestController
public class GroupController {

    @Autowired
    private IGroupService groupService;

    @Autowired
    private IProjectService projectService;

    @RequestMapping(value = "", method = RequestMethod.GET)
//    @ResponseBody
    public List<GroupDto> getGroupById() {
        return groupService.getAllGroup();
    }


    @RequestMapping(value = "/{name}", method = RequestMethod.GET)
//    @ResponseBody
    public List<ProjectDto> getGroupById(@PathVariable("name") String name) {
        return projectService.getProjectByGroupId(name);
    }

    @RequestMapping(value = "/project", method = RequestMethod.GET)
//    @ResponseBody
    public List<EmployeeDto> getMemberOfProject(@RequestParam("name") String name) {
        return projectService.getMembersOfProject(name);
    }

    @RequestMapping(value = "/project/maintain", method = RequestMethod.GET)
    public void maintainProject() throws Exception {
        projectService.maintainProjects();
    }
}
