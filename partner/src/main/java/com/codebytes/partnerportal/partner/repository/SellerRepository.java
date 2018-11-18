package com.codebytes.partnerportal.partner.repository;

import com.codebytes.partnerportal.common.domain.partner.PartnerBrand;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface SellerRepository extends CrudRepository<PartnerBrand, Long> {
    boolean existsByUsername(String username);
    boolean existsByEmail(String email);

    @Query("SELECT pb FROM PartnerBrand pb WHERE pb.username=:username")
    PartnerBrand getInformationOfLoggedInUser(@Param("username") String username);
}
