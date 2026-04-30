package com.example.flightapp.entity;

import jakarta.persistence.*;
import java.time.OffsetDateTime;

@Entity
@Table(name = "city")
public class City {

    @Id
    @Column(name = "city_id")
    private String cityId;

    @Column(name = "display_name", nullable = false)
    private String displayName;

    @Column(name = "created_at")
    private OffsetDateTime createdAt;

    public String getCityId() { return cityId; }
    public void setCityId(String cityId) { this.cityId = cityId; }
    public String getDisplayName() { return displayName; }
    public void setDisplayName(String displayName) { this.displayName = displayName; }
    public OffsetDateTime getCreatedAt() { return createdAt; }
    public void setCreatedAt(OffsetDateTime createdAt) { this.createdAt = createdAt; }
}
