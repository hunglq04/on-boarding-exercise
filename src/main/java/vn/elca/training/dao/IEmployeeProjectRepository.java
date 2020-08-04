package vn.elca.training.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;
import org.springframework.stereotype.Repository;
import vn.elca.training.dom.EmployeeProject;
import vn.elca.training.dom.EmployeeProjectId;

@Repository
public interface IEmployeeProjectRepository extends JpaRepository<EmployeeProject, Long>, QueryDslPredicateExecutor<EmployeeProject> {
}