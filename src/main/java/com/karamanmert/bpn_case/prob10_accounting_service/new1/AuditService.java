package com.karamanmert.bpn_case.prob10_accounting_service.new1;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
// depend on abst. NOT concrete class. it's an ex.
@Slf4j
public class AuditService {
    // LogLedgerEntryService olmalı. içerisinde repo olmalı. ki kayıtları buraya loglayalım.

    public void logEntry(GeneralLedgerEntry entry) {
        // 1- convert dto to entity
            // we can use mapstruct or manuel op.
        // 2- LogLedgerEntryService. save() çağrılıp log db ye kaydedilmeli.
        // 3- log.info ile de ayrıca bastırabiliriz.
        log.info(entry.toString());
    }
}