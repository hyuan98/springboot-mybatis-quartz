package yuanian.service;

import yuanian.pojo.Department;

public interface DepartmentService {
    void insterUsercode(Department department);

    Department findDepartmentByid(Integer dtid);
}
