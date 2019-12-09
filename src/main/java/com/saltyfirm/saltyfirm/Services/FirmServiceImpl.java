package com.saltyfirm.saltyfirm.Services;

import com.saltyfirm.saltyfirm.Models.Firm;
import com.saltyfirm.saltyfirm.Repositories.FirmRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class FirmServiceImpl implements FirmService {

    @Autowired
    FirmRepository firmRepository;

    @Override
    public List<Firm> searchFirms(String word) {
        return firmRepository.searchFirms(word);
    }

    @Override
    public Firm findFirmById(int firmId) {
        return firmRepository.findFirmById(firmId);
    }

    @Override
    public int deleteFirm(int firmId) {
        return firmRepository.deleteFirm(firmId);
    }

    @Override
    public void editFirm(String firmName, String firmType, String description, String logourl, int firmId) {
        firmRepository.editFirm(firmName, firmType, description, logourl, firmId);
    }
}
