package com.codegym.service;

import com.codegym.model.DTO.ProvinceDTO;
import com.codegym.model.Province;

public interface IProvinceService extends IGenerateService<Province> {
    Iterable<ProvinceDTO> getProvince();
}
