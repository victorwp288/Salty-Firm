package com.saltyfirm.saltyfirm.Repositories;

public interface FirmRepository {

    String searchFirms(String word);

    int findFirmById(int firmId);

    int deleteFirm(int firmId);

    int editFirm(int firmId, String firmName, String firmType, double overallScore, String description, String logoURL);
}
