package com.kd.pack.repository;

import com.kd.pack.model.Project;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateOperations;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by dima on 7.12.14.
 */
@Repository
public class ProjectRepository {
    @Autowired HibernateOperations hibernate;

    public List<Project> getAllProjects() {
        return hibernate.loadAll(Project.class);
    }

    public Long saveProject(Project project) {
        hibernate.saveOrUpdate(project);
        return project.getId();
    }

    public Project findProjectById(Long id) {
        if (id != null) {
            try {
                return (Project) hibernate.findByNamedQueryAndNamedParam("findProjectById", "projectId", id).get(0);
            } catch (IndexOutOfBoundsException e) {
                return null;
            }
        } else {
            return null;
        }
    }
}
