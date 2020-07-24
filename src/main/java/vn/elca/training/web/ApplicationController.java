package vn.elca.training.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import vn.elca.training.dom.Project;
import vn.elca.training.form.SearchForm;
import vn.elca.training.service.IProjectService;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.List;

import static vn.elca.training.constant.StringConst.PROJECT_NAME_KEY;

@Controller
public class ApplicationController {

    @Autowired
    private IProjectService projectService;

    @Value("${total.number.of.projects}")
    private String message;

    @RequestMapping("/")
    public String main(Model model, HttpSession session) {
        String name = "";
        List<Project> projects = projectService.findAll();
        int totalProjects = projects.size();
        if(session.getAttribute(PROJECT_NAME_KEY) != null) {
            name = (String) session.getAttribute(PROJECT_NAME_KEY);
            projects = projectService.findByNameContain(name);
        }
        model.addAttribute("title", "Project Management Tool");
        model.addAttribute("message", String.format(message, totalProjects));
        model.addAttribute("prjName", name);
        model.addAttribute("projects", projects);
        return "search";
    }

    @RequestMapping(value = "/query", method = RequestMethod.POST)
    public String query(SearchForm searchForm, HttpSession session) {
        String prjName = searchForm.getPrjName();
        session.setAttribute(PROJECT_NAME_KEY, prjName);
        return "redirect:/";
    }

    @RequestMapping("/detail/{id}")
    public String detail(Model model, @PathVariable("id") Long id) {
        model.addAttribute("project", projectService.findById(id));
        return "detail";
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String save(@Valid Project project, BindingResult bindingResult) {
        if(bindingResult.hasErrors()) {
            return "detail";
        }
        projectService.save(project);
        return "redirect:/";
    }

//    @InitBinder
//    private void initBinder(WebDataBinder binder) {
//        SimpleDateFormat dateFormat = new SimpleDateFormat(DATE_PATTERN);
//        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
//    }
}
