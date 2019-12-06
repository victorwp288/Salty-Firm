package com.saltyfirm.saltyfirm.Services;

import org.springframework.stereotype.Service;

@Service
public class FirmServiceImpl implements FirmService {
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
