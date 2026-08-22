package com.lostnfound.lost_and_found_v1.claim.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.lostnfound.lost_and_found_v1.claim.entity.ClaimRequest;
import com.lostnfound.lost_and_found_v1.claim.repository.ClaimRequestRepository;
import com.lostnfound.lost_and_found_v1.common.enums.ClaimStatus;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ClaimRequestServiceImpl implements ClaimRequestService {

    private final ClaimRequestRepository claimRequestRepository;

    @Override
    public ClaimRequest createClaim(ClaimRequest claimRequest) {
        return claimRequestRepository.save(claimRequest);
    }

    @Override
    public List<ClaimRequest> getClaimsByItemPost(Long itemPostId) {
        return claimRequestRepository.findAllByItemPostId(itemPostId);
    }

    @Override
    public List<ClaimRequest> getMyClaims(Long claimantId) {
        return claimRequestRepository.findAllByClaimantId(claimantId);
    }

    @Override
    public ClaimRequest approveClaim(Long itemPostId ,Long claimId) {

        //Find the whether the claim id and itempost id combination exist or not 
        ClaimRequest claim=claimRequestRepository.findByIdAndItemPostId(claimId,itemPostId)
        .orElseThrow(() -> new RuntimeException("Claim not found for this item"));

        //Find all the pending claim requests for that item
        List<ClaimRequest> pendingClaims =claimRequestRepository.findAllByItemPostIdAndStatus(itemPostId,ClaimStatus.PENDING);


        for(ClaimRequest pendingClaim : pendingClaims){
            if(!pendingClaim.getId().equals(claimId)){
                pendingClaim.setStatus(ClaimStatus.REJECTED);
                claimRequestRepository.save(pendingClaim);
            }
        }

        claim.setStatus(ClaimStatus.APPROVED);
        return claimRequestRepository.save(claim);

    }

    @Override
    public ClaimRequest rejectClaim(Long itemPostId, Long claimId) {
        ClaimRequest claim =claimRequestRepository
        .findByIdAndItemPostId(claimId,itemPostId)
        .orElseThrow(() -> new RuntimeException("Claim not found for this item"));

        claim.setStatus(ClaimStatus.REJECTED);

        return claimRequestRepository.save(claim);
    }
}
