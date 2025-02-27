package com.codegym.repository;

import com.codegym.model.DTO.ProvinceDTO;
import com.codegym.model.Province;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface IProvinceRepository extends CrudRepository<Province, Long> {

    @Query(nativeQuery = true,
    value = "select p.id as id, p.name as name, COUNT(c.firstName) as count from province p left join customer c on p.id = c.province_id group by p.id;")
    Iterable<ProvinceDTO> getProvince();

    @Query(nativeQuery = true,
    value = "call deleteProvinceById(:id)")
    @Transactional
    @Modifying
    void deleteProvinceById(@Param("id") long id);
}


