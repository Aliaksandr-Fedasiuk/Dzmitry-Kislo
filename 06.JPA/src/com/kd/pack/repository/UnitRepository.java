package com.kd.pack.repository;

import com.kd.pack.model.Unit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateOperations;
import org.springframework.stereotype.Repository;

/**
 * Created by dima on 7.12.14.
 */
@Repository
public class UnitRepository {
    @Autowired HibernateOperations hibernate;

    public Long saveUnit(Unit unit) {
        hibernate.saveOrUpdate(unit);
        return unit.getId();
    }

    public Unit findUnitById(Long id) {
        if (id != null) {
            try {
                return (Unit) hibernate.findByNamedQueryAndNamedParam("findUnitById", "unitId", id).get(0);
            } catch (IndexOutOfBoundsException e) {
                return null;
            }
        } else {
            return null;
        }
    }
}
