package com.saltyfirm.saltyfirm.Services;

public interface FirmService {

    String searchFirms(String word);

    int findFirmById(int firmId);

    int deleteFirm(int firmId);

    int editFirm(int firmId, String firmName, String firmType, double overallScore, String description, String logoURL);
}
