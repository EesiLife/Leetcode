package com.eesilife.lib;

/**
 * Created by siy on 18-5-24.
 */
public class L620_NotBoringMovies {
    /**
     select
        id, movie, description, rating
     from
        cinema
     where
        description != 'boring'
     and
        mod(id,2) = 1
     order by
        rating
     desc
     */
}
