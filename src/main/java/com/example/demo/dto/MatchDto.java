package com.example.demo.dto;

public class MatchDto {

    private Long offerId;
    private Long requestId;

    public MatchDto() {}

    public MatchDto(Long offerId, Long requestId) {
        this.offerId = offerId;
        this.requestId = requestId;
    }

    public Long getOfferId() {
        return offerId;
    }

    public void setOfferId(Long offerId) {
        this.offerId = offerId;
    }

    public Long getRequestId() {
        return requestId;
    }

    public void setRequestId(Long requestId) {
        this.requestId = requestId;
    }
}
