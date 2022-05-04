package com.smarts.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import java.sql.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class MobileDto {
	
	private Integer mobileId;
	private String mobileNo;
	private String countryCd;
	private String type;
	private String createdBy;
	private Date createdOn;
	private String updatedBy;
	private Date updatedOn;
}
