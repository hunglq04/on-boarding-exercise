package vn.elca.training.service;

import com.mysema.query.jpa.impl.JPAQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.elca.training.dao.IGroupRepository;
import vn.elca.training.dom.Group;
import vn.elca.training.dom.QGroup;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
@org.springframework.transaction.annotation.Transactional
public class GroupService implements IGroupService{

    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    private IGroupRepository groupRepository;

    @Override
    public void insertDummyData() {
        Group group = new Group();
        group.setName("group 1");
        groupRepository.save(group);
    }

    @Override
    public List<Group> getAll() {
        return new JPAQuery(entityManager)
                .from(QGroup.group)
                .list(QGroup.group);
    }
}
