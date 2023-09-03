package com.vigorride.framework.command;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class DocumentCommand {
	private String parentEntityType;
	private Long parentEntityId;
	private String fileName;
    private Long size;

}
