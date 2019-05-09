package edu.wbu.dorm.common.exception;

import edu.wbu.dorm.common.enums.ExceptionEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class CommonException extends RuntimeException {
    private ExceptionEnum exceptionEnum;
}
