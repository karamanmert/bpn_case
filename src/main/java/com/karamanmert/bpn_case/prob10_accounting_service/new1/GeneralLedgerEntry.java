package com.karamanmert.bpn_case.prob10_accounting_service.new1;

import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class GeneralLedgerEntry {
    private BigDecimal debit;
    private BigDecimal credit;
    private String accountType;
    private boolean underIFRS;
}