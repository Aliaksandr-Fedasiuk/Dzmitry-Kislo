package com.kd.pack.rest;

import com.kd.pack.model.Address;
import com.kd.pack.model.Employee;
import com.kd.pack.model.PersonalInfo;

import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import java.net.URI;

/**
 * Created by dima on 7.12.14.
 */
@Path("choice")
@Produces("application/json")
public class ChoiceResource extends SpringAwareResource {
    @GET @Path("1")
    public Response oneChoice(@Context UriInfo uriInfo) {
        return Response.seeOther(uriInfo.getBaseUriBuilder().path("../register_employee.html").build()).build();
    }

    @GET @Path("2")
    public Response twoChoice(@Context UriInfo uriInfo) {
        return Response.seeOther(uriInfo.getBaseUriBuilder().path("../show_employees.html").build()).build();
    }
}
