package vn.elca.training.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import org.springframework.stereotype.Service;
import vn.elca.training.dom.Project;

import java.util.Date;
import java.util.List;

@Repository
public interface IProjectRepository extends JpaRepository<Project, Long>, QueryDslPredicateExecutor<Project> {
    List<Project> findByNameContainingIgnoreCase(String prjName);
    List<Project> findProjectsByFinishingDateGreaterThanEqual(Date finishingDate);
}
