package id.akademi.amani.commons;

import java.util.Arrays;
import java.util.NoSuchElementException;
import java.util.stream.Stream;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public enum TransactionStatus {
    PENDING(1),
    PAID(2),
    CANCELED(3),
    REFUNDED(4);

    private final Integer status;

    public Integer getStatus()
    {
        return status;
    }

    public static TransactionStatus from(Integer status) {
        for (TransactionStatus statusEnum : values()) {
            if(statusEnum.getStatus().equals(status)){
                return statusEnum;
            }
        }
        throw new NoSuchElementException("No Transaction Status for " + status);
    }
}