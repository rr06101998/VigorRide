package com.vigorride.framework.data;

import java.io.Serializable;
import java.time.LocalDate;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class DocumentData implements Serializable {
    private static final long serialVersionUID = 7729777089992359996L;
private final Long id;
private final String parentEntityType;
private final Long parentEntityId;
private final String name;
private final String fileName;
private final Long size;
private final String type;
private final String description;
private final String location;
private final Integer storageType;
private final Long reportIdentifier;
private final Long tagIdentifier;
private final String tagValue;
//private final EnumOptionData status;
private final String geoTag;
private String storage;
private LocalDate createdDate;
private boolean hasPassword;
private String password;
private Boolean isLocked;

    
}
