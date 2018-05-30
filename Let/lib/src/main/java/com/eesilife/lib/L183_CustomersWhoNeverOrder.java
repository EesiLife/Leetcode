package com.eesilife.lib;

public class L183_CustomersWhoNeverOrder {
    /**
     select
        c.Name
     as
        Customers
     from
        Customers c
     where
        c.Id
     not in
        (select CustomerId from Orders)
     */
}
