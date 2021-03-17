package com.anisimovdenis.rest;

import com.anisimovdenis.service.CategoryDto;

import javax.ejb.Local;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Local
@Path("/v1/category")
public interface CategoryServiceRest {

    @GET
    @Path("/count")
    @Produces(MediaType.APPLICATION_JSON)
    Long countAll();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    List<CategoryDto> findAll();

    @GET
    @Path("/full")
    @Produces(MediaType.APPLICATION_JSON)
    List<CategoryDto> findAllWithProducts();

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    CategoryDto findById(@PathParam("id") Long id);

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    void insert(CategoryDto categoryDto);

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    void update(CategoryDto categoryDto);

    @DELETE
    @Path("/{id}")
    void deleteById(@PathParam("id") Long id);
}
