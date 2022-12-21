package com.vuhien.application.service;

import com.vuhien.application.entity.Certification;
import com.vuhien.application.model.request.CreateCertificationRequest;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CertificationService {
    Page<Certification> adminGetListCertifications(String id, String name, String status, Integer page);

    List<Certification> getListCertification();

    Certification createCertification(CreateCertificationRequest createCertificationRequest);

    void updateCertification(CreateCertificationRequest createCertificationRequest, Long id);

    void deleteCertification(long id);

    Certification getCertificationById(long id);

    long getCountBrands();
}
