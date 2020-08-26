package id.akademi.amani.admin.controllers.models;

import lombok.Builder;
import lombok.Getter;

import java.sql.Timestamp;

@Getter
@Builder
public class AdminResponse
{
    private String    id;
    private String    email;
    private boolean   active;
    private String    password;
    private String    userType;
    private String    fullName;
    private Timestamp updateDate;
    private Timestamp createDate;
}
