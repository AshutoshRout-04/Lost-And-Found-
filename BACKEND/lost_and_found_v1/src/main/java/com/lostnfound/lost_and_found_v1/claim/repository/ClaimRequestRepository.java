package com.lostnfound.lost_and_found_v1.claim.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lostnfound.lost_and_found_v1.claim.entity.ClaimRequest;
import com.lostnfound.lost_and_found_v1.common.enums.ClaimStatus;

public interface ClaimRequestRepository extends JpaRepository<ClaimRequest,Long> {

    List<ClaimRequest> findAllByItemPostId(Long itemPostId);

    List<ClaimRequest> findAllByClaimantId(Long claimantId);
    
    List<ClaimRequest> findAllByItemPostIdAndStatus(Long itemPostId , ClaimStatus status);

    Optional<ClaimRequest> findByIdAndItemPostId(
        Long claimId,
        Long itemPostId
    );

}
