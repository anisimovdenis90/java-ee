package com.anisimovdenis.rest;

import com.anisimovdenis.service.UserDto;

import javax.ejb.Local;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Local
@Path("/v1/user")
public interface UserServiceRest {

    @GET
    @Path("/count")
    @Produces(MediaType.APPLICATION_JSON)
    Long countAll();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    List<UserDto> findAll();

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    UserDto findById(@PathParam("id") Long id);

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    void insert(UserDto userDto);

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    void update(UserDto userDto);

    @DELETE
    @Path("/{id}")
    void deleteById(@PathParam("id") Long id);
}
