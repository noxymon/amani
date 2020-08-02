package id.akademi.amani.commons;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public enum MemberType {
    REGULER("REGULER", "Reguler Type Member"), COMPANY("COMPANY", "Company Type Member");

    private final String memberTypeId;
    private final String description;
    
    public static MemberType from(String string)
    {
        for (MemberType memberType : values()) {
            if(memberType.getMemberTypeId().equals(string)) {
                return memberType;
            }
        }
        throw new RuntimeException("No Definition Found for " + string);
    }
}