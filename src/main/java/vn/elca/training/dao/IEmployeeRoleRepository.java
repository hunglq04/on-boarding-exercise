package vn.elca.training.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;
import org.springframework.stereotype.Repository;
import vn.elca.training.dom.EmployeeRole;
import vn.elca.training.dom.EmployeeRoleId;

@Repository
public interface IEmployeeRoleRepository extends JpaRepository<EmployeeRole, Long>, QueryDslPredicateExecutor<EmployeeRole> {
}
