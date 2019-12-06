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
        return firmRepository.searchFirms(word);
    }

    @Override
    public int findFirmById(int firmId) {
        return firmRepository.findFirmById(firmId);
    }

    @Override
    public int deleteFirm(int firmId) {
        return firmRepository.deleteFirm(firmId);
    }

    @Override
    public int editFirm(int firmId, String firmName, String firmType, double overallScore, String description, String logoURL) {
        return firmRepository.editFirm(firmId, firmName, firmType, overallScore, description, logoURL);
    }
}
