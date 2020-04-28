package com.cts.auth.common.response;

import java.io.Serializable;
import java.util.Date;

import com.cts.auth.constant.ResponseStatus;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "code")
public class BasicResponse implements Serializable {
    private Integer code;
    private String description;
    private Date createdAt;

    public BasicResponse(ResponseStatus responseStatus) {
        this.code = responseStatus.getCode();
        this.description = responseStatus.getDescription();
        this.createdAt = new Date();
    }
}
