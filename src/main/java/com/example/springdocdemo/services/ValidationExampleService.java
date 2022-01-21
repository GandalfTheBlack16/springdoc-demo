package com.example.springdocdemo.services;

import com.example.springdocdemo.model.ValidationExampleEntity;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.UUID;

@Service
public class ValidationExampleService {

	private List<ValidationExampleEntity> mockEntities;

	public ValidationExampleEntity findById(String id) {
		return findById(id, mockEntities);
	}

	public List<ValidationExampleEntity> find(String searchExpression, Integer page, Integer count) {
		return mockEntities;
	}

	public ValidationExampleEntity insert(ValidationExampleEntity entity) {
		entity.setId(UUID.randomUUID().toString());
		entity.setCreated(Calendar.getInstance().getTime());
		mockEntities.add(entity);
		return entity;
	}

	public ValidationExampleEntity update(ValidationExampleEntity entity) {
		ValidationExampleEntity current = findById(entity.getId(), mockEntities);
		if (current == null) {
			return null;
		}
		current.setDescription(entity.getDescription());
		current.setName(entity.getName());
		current.setSomeCode(entity.getSomeCode());
		current.setUpdated(Calendar.getInstance().getTime());
		return current;
	}

	public ValidationExampleEntity remove(String id) {
		ValidationExampleEntity entity = findById(id, mockEntities);
		if (entity != null) {
			mockEntities.remove(entity);
		}
		return entity;
	}

	@PostConstruct
	public void postConstruct() {
		mockEntities = new ArrayList<ValidationExampleEntity>();
		insert(ValidationExampleEntity.builder().name("Alice").description("Alice example").someCode(3).build());
		insert(ValidationExampleEntity.builder().name("Bob").description("Bob example").someCode(6).build());
		insert(ValidationExampleEntity.builder().name("Carol").description("Carol example").someCode(7).build());
	}

	private ValidationExampleEntity findById(String id, List<ValidationExampleEntity> mockEntities) {
		for (ValidationExampleEntity i : mockEntities) {
			if (i.getId().equals(id)) {
				return i;
			}
		}
		return null;
	}
}
