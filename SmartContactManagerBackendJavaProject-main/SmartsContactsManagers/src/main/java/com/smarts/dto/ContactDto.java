package com.smarts.dto;
import java.sql.Date;
import java.util.List;
import com.smarts.entity.Mobile;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ContactDto {

	private Integer contactId;
	private String firstName;
	private String lastName;
	private String emailAddress;
	private String createdBy;
	private Date createdOn;
	private String updatedBy;
	private Date updatedOn;
	private String isActive;
	private List<Mobile> mobile;

}
