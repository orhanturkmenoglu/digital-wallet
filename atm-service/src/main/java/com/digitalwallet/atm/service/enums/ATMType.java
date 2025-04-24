package com.digitalwallet.atm.service.enums;

public enum ATMType {
    CASH_ONLY,          // Sadece nakit çekme
    CASH_AND_DEPOSIT,   // Nakit çekme ve para yatırma
    DEPOSIT_ONLY,       // Sadece para yatırma
    FULL_SERVICE;       // Tam hizmet (nakit çekme ve yatırma)
}
