package com.smarts.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.LastModifiedBy;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
@Table(name="MOBILE")
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Mobile {

	@Id
	@GeneratedValue(strategy =GenerationType.IDENTITY)
	private Integer mobileId;

	@Size(min=10,max=10)
	@Pattern(regexp="(^$|[0-9]{10})")
	@NotNull(message = "Mobile Number can not be null")
	private String mobileNo;

	private String countryCd;

	private String type;

	@CreatedBy
	private String createdBy;

	@CreationTimestamp
	private Date createdOn;

	@LastModifiedBy
	private String updatedBy;

	@UpdateTimestamp
	private Date updatedOn;

}


	