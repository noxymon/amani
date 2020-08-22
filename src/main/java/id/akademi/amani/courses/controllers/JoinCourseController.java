package id.akademi.amani.courses.controllers;

import javax.websocket.server.PathParam;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import id.akademi.amani.courses.controllers.models.JoinCourseRequest;
import id.akademi.amani.courses.controllers.models.JoinCourseResponse;
import id.akademi.amani.courses.services.JoinCourse;
import id.akademi.amani.courses.services.models.JoinCourseOutput;
import id.akademi.amani.courses.services.models.JoinCourseParam;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/course")
public class JoinCourseController
{

    private final JoinCourse joinCourse;

    @PostMapping("/{id}/join")
    public ResponseEntity<?> doJoinCourse(@PathVariable("id") String id, @RequestBody JoinCourseRequest joinCourseRequest)
    {
        JoinCourseParam joinCourseParam = buildJoinCourse(id, joinCourseRequest);
        JoinCourseOutput joinCourseOutput = joinCourse.join(joinCourseParam);
        return new ResponseEntity<>(
            buildJoinCourseResponseFrom(joinCourseOutput), 
            HttpStatus.OK
        );
    }

    private JoinCourseResponse buildJoinCourseResponseFrom(JoinCourseOutput joinCourseOutput)
    {
        return JoinCourseResponse.builder()
                                 .amount(joinCourseOutput.getAmount())
                                 .amountFinal(joinCourseOutput.getAmountFinal())
                                 .transcationId(joinCourseOutput.getTranscationId())
                                 .transactionStatus(joinCourseOutput.getTransactionStatus())
                                 .build();
    }

    private JoinCourseParam buildJoinCourse(String id, JoinCourseRequest joinCourseRequest)
    {
        return JoinCourseParam.builder()
                              .courseId(id)
                              .memberId(joinCourseRequest.getMemberId())
                              .build();
    };
}
