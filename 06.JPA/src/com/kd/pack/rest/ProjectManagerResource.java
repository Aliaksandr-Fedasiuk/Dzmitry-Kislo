package com.kd.pack.rest;

import com.kd.pack.model.Project;
import com.kd.pack.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import java.util.List;

/**
 * Created by dima on 7.12.14.
 */
@Path("projects")
@Produces("application/json")
public class ProjectManagerResource extends SpringAwareResource {
    @Autowired ProjectRepository repo;

    @GET
    public List<Project> getAllProjects() {
        return repo.getAllProjects();
    }
}
