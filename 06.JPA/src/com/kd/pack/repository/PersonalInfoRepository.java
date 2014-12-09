package com.kd.pack.repository;

import com.kd.pack.model.PersonalInfo;
import com.kd.pack.model.Unit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateOperations;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by dima on 7.12.14.
 */
@Repository
public class PersonalInfoRepository {
    @Autowired HibernateOperations hibernate;

    public List<PersonalInfo> getAllPersonalInfo() {
        return hibernate.loadAll(PersonalInfo.class);
    }
}
