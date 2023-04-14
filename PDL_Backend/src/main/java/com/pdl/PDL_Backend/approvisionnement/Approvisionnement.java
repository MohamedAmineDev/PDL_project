package com.pdl.PDL_Backend.approvisionnement;

import com.pdl.PDL_Backend.details_du_approvisionnement.DetailsDuApprovisionnement;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Approvisionnement implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private LocalDate dateIntervention;
    private String details;
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "approvisionnement")
    private List<DetailsDuApprovisionnement> detailsDuApprovisionnements;
}
