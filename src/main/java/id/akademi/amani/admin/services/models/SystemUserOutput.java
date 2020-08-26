package id.akademi.amani.admin.services.models;

import lombok.Data;

import java.sql.Timestamp;

@Data
public class SystemUserOutput
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
