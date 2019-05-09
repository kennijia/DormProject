package edu.wbu.dorm.common.enums;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public enum ExceptionEnum {
    PERMISSION_DENIAL(403,"权限不足，拒绝访问！"),
    AUTHORIZATION_EXPIRED(403,"授权已过期！"),
    ;
    private int code;
    private String message;
}
