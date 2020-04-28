package com.cts.auth.response;

import com.cts.auth.common.response.BasicResponse;
import com.cts.auth.constant.ResponseStatus;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@Getter
@Setter
@ToString(callSuper = true)
@NoArgsConstructor
@EqualsAndHashCode(of = "token", callSuper = false)
public class AuthResponse extends BasicResponse {
    private String token;

    public AuthResponse(ResponseStatus responseStatus, String token) {
        super(responseStatus);
        this.token = token;
    }
}