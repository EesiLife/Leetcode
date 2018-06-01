package com.eesilife.lib;

/**
 * Created by siy on 18-5-30.
 */
public class L181_EmployeesEarningMoreThanTheirManagers {
    /**
     select
        e.Name
     as
        Employee
     from
        Employee e, Employee f
     where
        e.ManagerId = f.Id
     and
        e.Salary > f.Salary
     */
}
