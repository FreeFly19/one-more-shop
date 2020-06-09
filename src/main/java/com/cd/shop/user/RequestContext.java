package com.cd.shop.user;

import com.cd.shop.localization.Language;
import lombok.Setter;

import java.time.Instant;
import java.util.Optional;

@Setter
public class RequestContext {
    private Language lang;
    private Instant requestedAt;
    private String sessionId;
    private Long userId;

    public Language getLang() {
        return lang;
    }

    public Instant getRequestedAt() {
        return requestedAt;
    }

    public String getSessionId() {
        return sessionId;
    }

    public Optional<Long> getUserId() {
        return Optional.ofNullable(userId);
    }
}
