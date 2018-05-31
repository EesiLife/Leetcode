package com.eesilife.lib;

/**
 * Created by siy on 18-5-31.
 */
public class L626_ExchangeSeats {
    /**
     select
        id, student
     from
     (
        select
            id-1 as id, student from seat where mod(id, 2)=0
        union
        select
            id+1 as id, student from seat where mod(id,2)!=0 and id!=(select count(*) from seat)
        union
        select
            id, student from seat where mod(id,2)!=0 and id=(select count(*) from seat)
     )
     seat order by id
     */
}
