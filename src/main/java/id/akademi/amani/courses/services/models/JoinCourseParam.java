package id.akademi.amani.courses.services.models;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class JoinCourseParam {
    private String courseId;
    private String memberId;
}