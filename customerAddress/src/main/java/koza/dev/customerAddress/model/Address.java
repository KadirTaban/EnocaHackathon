package koza.dev.customerAddress.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "Address")
@NoArgsConstructor
@Builder
@AllArgsConstructor
@Data
public class Address extends BaseEntity {
    private String addressName;
    private String city;
    private String district;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name="customer_id")
    @JsonBackReference
    private Customer customer;




}
