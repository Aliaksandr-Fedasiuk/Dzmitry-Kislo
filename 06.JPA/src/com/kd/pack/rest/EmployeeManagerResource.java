package com.kd.pack.rest;

import com.kd.pack.model.Address;
import com.kd.pack.model.Employee;
import com.kd.pack.model.PersonalInfo;
import com.kd.pack.model.Project;
import com.kd.pack.repository.EmployeeRepository;
import com.kd.pack.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;

import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import java.net.URI;
import java.util.List;

import static java.util.Arrays.asList;

/**
 * Created by dima on 7.12.14.
 */
@Path("employees")
@Produces("application/json")
public class EmployeeManagerResource extends SpringAwareResource {
    @Autowired EmployeeRepository repo;
    @Autowired ProjectRepository projectRepository;

    @GET
    public List<Employee> getAllEmplyees() {
        return repo.getAllEmployees();
    }

    @POST
    public Response createNewEmployee(@Context UriInfo uriInfo, @FormParam("name") String name, @FormParam("city") String city,
                                      @FormParam("age") int age, @FormParam("project_list") Long projectId, @FormParam("description") String description) {
        Project project = projectRepository.findProjectById(projectId);
        Employee newEmployee = new Employee(name, new Address(city));
        newEmployee.addProject(project);
        Long id = repo.saveEmployee(newEmployee, new PersonalInfo(age, description));
        URI uri = uriInfo.getBaseUriBuilder().path("../index.html").build();
        return Response.seeOther(uri).build();
    }

    @GET @Path("{id}")
    public Response findEmployeeById(@PathParam("id") Long id) {
        Employee employee = repo.findEmployeeById(id);
        if (employee != null) {
            return Response.status(200).entity(employee).build();
        } else {
            return Response.status(404).entity("The employee with the id=" + id + " does not exist").build();
        }
    }

    @DELETE @Path("{id}")
    public Response deleteEmployee(@PathParam("id") Long id) {
        repo.deleteEmployee(id);
        return Response.status(204).build();
    }

}
