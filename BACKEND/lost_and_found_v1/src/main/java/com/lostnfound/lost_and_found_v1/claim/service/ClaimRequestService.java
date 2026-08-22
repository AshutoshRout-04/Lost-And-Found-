package com.lostnfound.lost_and_found_v1.claim.service;

import java.util.List;

import com.lostnfound.lost_and_found_v1.claim.entity.ClaimRequest;

public interface ClaimRequestService {
    
    public ClaimRequest createClaim(ClaimRequest claimRequest);
    public List<ClaimRequest> getClaimsByItemPost(Long itemPostId);
    public List<ClaimRequest> getMyClaims(Long claimantId);
    public ClaimRequest approveClaim(Long itemPostId , Long claimId);
    public ClaimRequest rejectClaim(Long itemPostId , Long claimId);


}
