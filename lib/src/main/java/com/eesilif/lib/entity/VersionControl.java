package com.eesilif.lib.entity;

/**
 * Created by siy on 18-7-10.
 */
public class VersionControl {
    private int badVersion = 0;
    public void setFirstBadVersion(int version){
        this.badVersion = version;
    }
    public boolean isBadVersion(int version){
        if(version >= badVersion)return true;
        if(version < badVersion)return false;
        return false;
    }
}
