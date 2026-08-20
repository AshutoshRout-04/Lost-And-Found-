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
    public ClaimRequest approveClaim(Long claimId) {
        ClaimRequest claim = claimRequestRepository.findById(claimId)
                .orElseThrow(() -> new RuntimeException("Claim not found"));

        List<ClaimRequest> pendingClaims = claimRequestRepository.findAllByItemPostIdAndStatus(
                claim.getItemPost().getId(),
                ClaimStatus.PENDING);

        for (ClaimRequest pendingClaim : pendingClaims) {
            if (!pendingClaim.getId().equals(claimId)) {
                pendingClaim.setStatus(ClaimStatus.REJECTED);
                claimRequestRepository.save(pendingClaim);
            }
        }

        claim.setStatus(ClaimStatus.APPROVED);

        return claimRequestRepository.save(claim);

    }

    @Override
    public ClaimRequest rejectClaim(Long claimId) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'rejectClaim'");
    }
}
