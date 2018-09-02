package com.sicredi.hackathon.social.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EstimatedConclusionDateResponse implements Serializable {

    private static final long serialVersionUID = -4640314253046289796L;

    private BigDecimal average;
    private LocalDate date;
}
