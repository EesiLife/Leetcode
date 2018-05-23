package com.eesilife.lib;

/**
 * Created by siy on 18-5-23.
 */
public class L182_DuplicateEmails {
    /**
     * # Write your MySQL query statement below
     select distinct(Email)
     from Person
     where Email in (select Email from Person group by Email having count(Email) >1)
     */
}
