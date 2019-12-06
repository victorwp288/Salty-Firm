package com.saltyfirm.saltyfirm.Services;

import com.saltyfirm.saltyfirm.Repositories.FirmRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class FirmServiceImpl implements FirmService {

    @Autowired
    FirmRepository firmRepository;

    @Override
    public String searchFirms(String word) {
        return null;
    }

    @Override
    public int findFirmById(int firmId) {
        return 0;
    }

    @Override
    public int deleteFirm(int firmId) {
        return 0;
    }

    @Override
    public int editFirm(int firmId, String firmName, String firmType, double overallScore, String description, String logoURL) {
        return 0;
    }
}
