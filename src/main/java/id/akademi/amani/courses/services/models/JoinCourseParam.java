package id.akademi.amani.courses.services.models;

import id.akademi.amani.courses.controllers.models.JoinCourseRequest;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class JoinCourseParam {
    private String courseId;
    private String memberId;
}