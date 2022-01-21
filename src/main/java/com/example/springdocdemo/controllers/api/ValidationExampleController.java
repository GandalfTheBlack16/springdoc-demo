package com.example.springdocdemo.controllers.api;

import com.example.springdocdemo.model.ValidationExampleEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotNull;
import java.util.List;

@RequestMapping("/validation/example")
public interface ValidationExampleController {

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    ResponseEntity<ValidationExampleEntity> findById(@NotNull @PathVariable("id") String id);

    @RequestMapping(value = "/", method = RequestMethod.GET)
    List<ValidationExampleEntity> find(
            @RequestParam(value = "q", required = false) String searchExpression,
            @RequestParam(value = "p", required = false) Integer page,
            @RequestParam(value = "c", required = false) Integer count);

    @RequestMapping(value = "/", method = RequestMethod.POST)
    ResponseEntity<ValidationExampleEntity> insert(
            @Validated(ValidationExampleEntity.ValidationContext.Insert.class) @RequestBody ValidationExampleEntity entity);

    @RequestMapping(value = "/", method = RequestMethod.PATCH)
    ResponseEntity<ValidationExampleEntity> update(
            @Validated(ValidationExampleEntity.ValidationContext.Default.class) @RequestBody ValidationExampleEntity entity);

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    ResponseEntity<ValidationExampleEntity> remove(@NotNull @PathVariable("id") String id);
}
