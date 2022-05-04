package com.smarts.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.LastModifiedBy;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name="CONTACT")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Contact {

	@Id
	@GeneratedValue(strategy =GenerationType.IDENTITY)
	private Integer contactId;

	@NotBlank(message = "Firstname should not be empty")
	@Size(min = 3, max = 20)
	private String firstName;

	@NotBlank(message = "Lastname should not be empty")
	@Size(min = 3, max = 20)
	private String lastName;

	@Email
	@NotBlank(message = "Email can not be null")
	private String emailAddress;

	@CreatedBy
	@NotNull(message = "This field cannot be Empty")
	private String createdBy;

	@CreationTimestamp
	private Date createdOn;

	@LastModifiedBy
	private String updatedBy;

	@UpdateTimestamp
	private Date updatedOn;
	
	private String isActive;
	
	@OneToMany(targetEntity = Mobile.class, cascade = CascadeType.ALL)
	@JoinColumn(name = "contactId", referencedColumnName = "contactId")
	private List<Mobile> mobile = new ArrayList<>();

}
