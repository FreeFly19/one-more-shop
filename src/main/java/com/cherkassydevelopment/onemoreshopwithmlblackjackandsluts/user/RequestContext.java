package com.cherkassydevelopment.onemoreshopwithmlblackjackandsluts.user;

import com.cherkassydevelopment.onemoreshopwithmlblackjackandsluts.localization.Language;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;

@Setter
@Getter
public class RequestContext {
    private Language lang;
    private Instant requestedAt;
    private String sessionId;
    private User user;
}
