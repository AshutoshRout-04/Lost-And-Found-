package com.lostnfound.lost_and_found_v1.claim.entity;

import java.time.LocalDateTime;

import com.lostnfound.lost_and_found_v1.common.enums.ClaimStatus;
import com.lostnfound.lost_and_found_v1.item.entity.ItemPost;
import com.lostnfound.lost_and_found_v1.user.entity.User;

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
public class ClaimRequest {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name="item_post_id")
    private ItemPost itemPost;

    @ManyToOne
    @JoinColumn(name = "claimant_user_id")
    private User claimant;


    private String verificationAnswer;

    @Enumerated(EnumType.STRING)
    private ClaimStatus status=ClaimStatus.PENDING;
    private LocalDateTime decidedAt;
    private LocalDateTime createdAt;
}
