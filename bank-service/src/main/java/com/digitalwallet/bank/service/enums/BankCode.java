package com.digitalwallet.bank.service.enums;

public enum BankCode {
    ZIRAAT("001", "T.C. Ziraat Bankası"),
    ISBANK("002", "Türkiye İş Bankası"),
    GARANTI("003", "Garanti BBVA"),
    YAPI_KREDI("004", "Yapı Kredi"),
    HALKBANK("005", "Halkbank"),
    AKBANK("006", "Akbank"),
    VAKIFBANK("007", "VakıfBank");

    private final String code;
    private final String name;

    BankCode(String code, String name) {
        this.code = code;
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

}
