package vn.elca.training.service;

import com.mysema.query.jpa.impl.JPAQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.elca.training.constant.Status;
import vn.elca.training.dao.*;
import vn.elca.training.dom.*;
import vn.elca.training.dto.GroupDto;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.*;

@Service
public class GroupService implements IGroupService {

    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    private IGroupRepository groupRepository;

    @Autowired
    private IProjectRepository projectRepository;

    @Autowired
    private IEmployeeRepository employeeRepository;

    @Autowired
    private IRoleRepository roleRepository;

    @Autowired
    private IEmployeeProjectRepository employeeProjectRepository;

    @Autowired
    private IEmployeeRoleRepository employeeRoleRepository;

    @Override
    public void insertDummyData() {
        //Insert employee
        Employee qmv = new Employee("QMV");
        Employee htv = new Employee("HTV");
        Employee qkp = new Employee("QKP");
        Employee mkn = new Employee("MKN");
        Employee tqp = new Employee("TQP");
        Employee hnh = new Employee("HNH");
        Employee nqn = new Employee("NQN");
        Employee plh = new Employee("PLH");
        Employee hnl = new Employee("HNL");
        Employee tbh = new Employee("TBH");
        Employee tdn = new Employee("TDN");
        Employee apl = new Employee("APL");
        Employee xhp = new Employee("XHP");
        Employee hpn = new Employee("HPN");
        Employee hun = new Employee("HUN");
        Employee bnn = new Employee("BNN");
        Employee pnh = new Employee("PNH");
        Employee vvt = new Employee("VVT");
        employeeRepository.save(Arrays.asList(qmv, htv, qkp, mkn, tqp, hnh, nqn, plh, hnl,
                tbh, tdn, apl, xhp, hpn, hun, bnn, pnh, vvt));

        //Insert Role
        Role dev = new Role("Developer");
        Role qa = new Role("Quality Agent");
        Role pl = new Role("Project Leader");
        Role gl = new Role("Group Leader");
        roleRepository.save(Arrays.asList(dev, qa, pl, gl));

        //Insert Employee_Role
        List<EmployeeRole> employeeRoles = Arrays.asList(
                new EmployeeRole(qmv, gl),
                new EmployeeRole(htv, pl),
                new EmployeeRole(qkp, pl),
                new EmployeeRole(mkn, pl),
                new EmployeeRole(tqp, dev),
                new EmployeeRole(hnh, qa),
                new EmployeeRole(nqn, dev),
                new EmployeeRole(plh, qa),
                new EmployeeRole(hnl, dev),
                new EmployeeRole(tbh, qa),
                new EmployeeRole(tdn, dev),
                new EmployeeRole(hnh, gl),
                new EmployeeRole(apl, pl),
                new EmployeeRole(xhp, pl),
                new EmployeeRole(hpn, dev),
                new EmployeeRole(hun, qa),
                new EmployeeRole(bnn, dev),
                new EmployeeRole(pnh, dev),
                new EmployeeRole(qmv, qa),
                new EmployeeRole(vvt, dev));
        employeeRoleRepository.save(employeeRoles);


        //Insert Group
        Group group1 = new Group();
        group1.setName("Group 1");
        group1.setLeader(qmv);
        Group group2 = new Group();
        group2.setName("Group 2");
        group2.setLeader(hnh);
        groupRepository.save(Arrays.asList(group1, group2));

        //Insert Project
        Project efv = new Project("EFV", new Date(119, Calendar.JANUARY, 15), Status.FINISHED, htv, group1);
        Project cxtranet = new Project("CXTRANET", new Date(120, Calendar.FEBRUARY, 15), Status.FINISHED, qkp, group1);
        Project crystalBall = new Project("CRYSTAL BALL", new Date(121, Calendar.APRIL, 20), Status.IN_PROGRESS, mkn, group1);
        Project ioc = new Project("IOC CLIENT EXTRANET", new Date(122, Calendar.MAY, 5), Status.IN_PROGRESS, apl, group2);
        Project ksta = new Project("KSTA MIGRATION", new Date(123, Calendar.JULY, 15), Status.NEW, xhp, group2);
        projectRepository.save(Arrays.asList(efv, cxtranet, crystalBall, ioc, ksta));

        //Insert Employee_Project
        List<EmployeeProject> employeeProjects = Arrays.asList(
                new EmployeeProject(tqp, efv),
                new EmployeeProject(hnh, efv),
                new EmployeeProject(nqn, efv),
                new EmployeeProject(plh, cxtranet),
                new EmployeeProject(hnl, cxtranet),
                new EmployeeProject(tbh, crystalBall),
                new EmployeeProject(tdn, crystalBall),
                new EmployeeProject(hpn, ioc),
                new EmployeeProject(hun, ioc),
                new EmployeeProject(bnn, ioc),
                new EmployeeProject(pnh, ioc),
                new EmployeeProject(qmv, ksta),
                new EmployeeProject(vvt, ksta));
        employeeProjectRepository.save(employeeProjects);

    }

    @Override
    public GroupDto getGroupById() {
        List<Group> groups = new JPAQuery(entityManager)
                .from(QGroup.group)
                .list(QGroup.group);
        return null;
    }
}
