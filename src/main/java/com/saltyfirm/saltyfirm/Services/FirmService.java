package com.saltyfirm.saltyfirm.Services;

import com.saltyfirm.saltyfirm.Models.Firm;

public interface FirmService {

    String searchFirms(String word);

    Firm findFirmById(int firmId);

    int deleteFirm(int firmId);

    void editFirm(String firmName, String firmType, String description, String logourl, int firmId);
}
