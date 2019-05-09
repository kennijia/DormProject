package edu.wbu.dorm.common.vo;

import edu.wbu.dorm.common.enums.ExceptionEnum;
import lombok.Data;

import java.util.Date;

@Data
public class ExceptionResult {
    private Integer status;
    private String message;
    private String timestamp;

    public ExceptionResult(ExceptionEnum em){
        this.status = em.getCode();
        this.message = em.getMessage();
        this.timestamp = new Date().toString();
    }
}
