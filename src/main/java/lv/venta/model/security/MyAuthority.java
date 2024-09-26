package lv.venta.model.security;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@Table(name = "MyAuthority")
@Entity
public class MyAuthority {
    @Column(name = "Id")
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int userId;

    @Column(name = "Title")
    @Pattern(regexp = "[A-Z]{4,7}")
    private String title;

    public MyAuthority(@Pattern(regexp = "[A-Z]{4,7}") String title){
        this.title = title;
    }
}
