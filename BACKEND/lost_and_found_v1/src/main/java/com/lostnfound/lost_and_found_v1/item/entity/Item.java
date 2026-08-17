package com.lostnfound.lost_and_found_v1.item.entity;

import java.time.LocalDate;

import com.lostnfound.lost_and_found_v1.common.enums.ItemStatus;
import com.lostnfound.lost_and_found_v1.common.enums.ItemType;
import com.lostnfound.lost_and_found_v1.common.enums.ReportStatus;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String description;
    private String location;
    private LocalDate date;
    //gccuehcue
    @Enumerated(EnumType.STRING)
    private ItemType itemType;

    @Enumerated(EnumType.STRING)
    private ItemStatus itemStatus;

    @Enumerated(EnumType.STRING)
    private ReportStatus reportStatus;

    private String imageUrl;

    private String reportedBy;
}
