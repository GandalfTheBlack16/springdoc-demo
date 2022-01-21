package com.example.springdocdemo.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.*;
import java.util.Date;

/**
 * Example entity for GAIA validation showcase.
 * 
 * @author Arquitectura
 * @since 1.2.0
 */
//tag::doc-stripped[]
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ValidationExampleEntity {

	private static final String EMAIL_RFC_2822 = "(?:[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*|\"(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21\\x23-\\x5b\\x5d-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])*\")@(?:(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?|\\[(?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?|[a-z0-9-]*[a-z0-9]:(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21-\\x5a\\x53-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])+)\\])";

	@Null(groups = ValidationContext.Insert.class)
	@NotNull(groups = ValidationContext.Default.class)
	private String id;

	@NotNull(groups = { ValidationContext.Insert.class, ValidationContext.Default.class })
	private String name;

	@Pattern(regexp = EMAIL_RFC_2822, groups = { ValidationContext.Insert.class, ValidationContext.Default.class })
	private String email;

	private String description;

	@NotNull(groups = { ValidationContext.Insert.class, ValidationContext.Default.class })
	@Min(value = 0, groups = { ValidationContext.Insert.class, ValidationContext.Default.class })
	@Max(value = 10, groups = { ValidationContext.Insert.class, ValidationContext.Default.class })
	private Integer someCode;

	private Date created;

	private Date updated;

	/**
	 * Validation scopes for this entity.
	 */
	public static class ValidationContext {

		public static interface Insert {
		}

		public static interface Default {
		}

	}
}
//end::doc-stripped[]
