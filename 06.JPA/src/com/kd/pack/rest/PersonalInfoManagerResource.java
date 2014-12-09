package com.kd.pack.rest;

import com.kd.pack.model.PersonalInfo;
import com.kd.pack.repository.PersonalInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import java.util.List;

/**
 * Created by dzmitry on 9.12.14.
 */
@Path("info")
@Produces("application/json")
public class PersonalInfoManagerResource extends SpringAwareResource {
    @Autowired PersonalInfoRepository repo;

    @GET
    public List<PersonalInfo> getAllInfos() {
        return repo.getAllPersonalInfo();
    }
}
