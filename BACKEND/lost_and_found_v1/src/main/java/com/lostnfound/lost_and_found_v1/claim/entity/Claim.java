package com.lostnfound.lost_and_found_v1.claim.entity;

import java.time.LocalDateTime;

import com.lostnfound.lost_and_found_v1.common.enums.ClaimStatus;
import com.lostnfound.lost_and_found_v1.item.entity.Item;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Claim {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne
    @JoinColumn(name = "item_id")
    private Item item;
    private String claimedBy;
    @Enumerated(EnumType.STRING)
    private ClaimStatus claimStatus;

    private String proofOfOwnership;
    private LocalDateTime createdAt;
}
