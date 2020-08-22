package id.akademi.amani.courses.controllers.models;

import id.akademi.amani.commons.TransactionStatus;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class JoinCourseResponse
{
    private Double            amount;
    private Double            amountFinal;
    private String            transcationId;
    private TransactionStatus transactionStatus;
}
