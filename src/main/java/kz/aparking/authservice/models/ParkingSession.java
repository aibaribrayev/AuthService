package kz.aparking.authservice.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import kz.aparking.authservice.models.User;

import java.time.LocalDateTime;

@Entity(name="user_parking_record")
public class ParkingSession {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonIgnore
    @JoinColumn(name = "user_id", nullable=false)
    @ManyToOne(fetch = FetchType.LAZY)
    private User user;
    @Column(name = "parkspot_number")
    private String parkingSpotNumber;
    @Column(name = "start_time", nullable = false)
    private LocalDateTime startTime;
    @Column(name = "end_time")
    private LocalDateTime endTime;
    @Column(name = "price")
    private String price;
    @Column(name = "ispaid")
    private boolean isPaid;
    @Column(name = "car_number")
    private String carNumber;

    public ParkingSession(String parkingSpotNumber, LocalDateTime startTime, LocalDateTime endTime, String price, boolean isPaid, String carNumber) {
        this.parkingSpotNumber = parkingSpotNumber;
        this.startTime = startTime;
        this.endTime = endTime;
        this.price = price;
        this.isPaid = isPaid;
        this.carNumber = carNumber;
    }

    protected ParkingSession() {
    }
    public String getCarNumber() {
        return carNumber;
    }

    public void setCarNumber(String carNumber) {
        this.carNumber = carNumber;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public boolean isPaid() {
        return isPaid;
    }

    public void setPaid(boolean paid) {
        isPaid = paid;
    }


    public LocalDateTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalDateTime endTime) {
        this.endTime = endTime;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getParkingSpotNumber() {
        return parkingSpotNumber;
    }

    public void setParkingSpotNumber(String parkingSpot) {
        this.parkingSpotNumber = parkingSpot;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalDateTime startTime) {
        this.startTime = startTime;
    }
}

