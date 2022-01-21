package com.example.springdocdemo.controllers;

import com.example.springdocdemo.controllers.api.ValidationExampleController;
import com.example.springdocdemo.model.ValidationExampleEntity;
import com.example.springdocdemo.services.ValidationExampleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ValidationExampleControllerImpl implements ValidationExampleController {

    @Autowired
    private ValidationExampleService validationService;

    @Override
    public ResponseEntity<ValidationExampleEntity> findById(String id) {
        ValidationExampleEntity entity = validationService.findById(id);
        HttpStatus status = entity != null ? HttpStatus.OK : HttpStatus.NOT_FOUND;
        return new ResponseEntity<>(entity, status);
    }

    @Override
    public List<ValidationExampleEntity> find(String searchExpression, Integer page, Integer count) {
        return validationService.find(searchExpression, page, count);
    }

    @Override
    public ResponseEntity<ValidationExampleEntity> insert(
            @Validated(ValidationExampleEntity.ValidationContext.Insert.class) @RequestBody ValidationExampleEntity entity) {
        ValidationExampleEntity result = validationService.insert(entity);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<ValidationExampleEntity> update(
            @Validated(ValidationExampleEntity.ValidationContext.Default.class) @RequestBody ValidationExampleEntity entity) {
        ValidationExampleEntity result = validationService.update(entity);
        return result != null ? new ResponseEntity<>(result, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @Override
    public ResponseEntity<ValidationExampleEntity> remove(String id) {
        ValidationExampleEntity result = validationService.remove(id);
        return result != null ? new ResponseEntity<>(result, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
