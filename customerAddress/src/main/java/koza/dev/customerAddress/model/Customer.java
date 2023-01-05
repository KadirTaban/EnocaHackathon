package koza.dev.customerAddress.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Set;
@Entity
@NoArgsConstructor
@Builder
@AllArgsConstructor
@Table(name = "customer")
@Data
public class Customer extends BaseEntity {

    @Column(unique = true)
    private String email;
    private String password;
    @OneToMany(mappedBy = "customer", fetch = FetchType.LAZY,orphanRemoval = true, cascade = CascadeType.ALL)
    @JsonManagedReference
    private Set<Address> addresses;


}
