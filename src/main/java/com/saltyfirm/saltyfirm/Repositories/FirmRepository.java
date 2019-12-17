package com.saltyfirm.saltyfirm.Repositories;

import com.saltyfirm.saltyfirm.Models.Firm;
import com.saltyfirm.saltyfirm.Models.SearchOverview;

import java.util.List;

public interface FirmRepository {

    List<Firm> searchFirms(String word);
    Firm findFirmById(int firmId);
    int deleteFirm(int firmId);
    int editFirm(Firm firm);
    double getFirmTotalScore(int firmId);
    List<Firm> getAllFirms();

}
