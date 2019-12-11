package com.saltyfirm.saltyfirm.Repositories;

import com.saltyfirm.saltyfirm.Models.Firm;

import java.util.List;

public interface FirmRepository {

    List<Firm> searchFirms(String word);
    Firm findFirmById(int firmId);
    int deleteFirm(int firmId);
    int editFirm(Firm firm);
    double getFirmTotalScore(int firmId);
}
