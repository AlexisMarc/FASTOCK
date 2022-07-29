package yeilux.com.proyecto.Model.Class.empresa;

import java.util.List;

import jakarta.persistence.*;

@Entity
@Table(name="especialidad")
public class especialidad {
// -----------------------ID-----------------------//
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

// ************************************************//
// -------------Relacion con empresa---------------//
// ************************************************//
    @OneToMany(mappedBy = "especialidad", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<empresa> empresa;
}
