import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.Objects;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class Coche implements Serializable {

    // Atributo para definir la serialización del objeto
    private static final long serialVersionUID = 1L;
    private String marca, modelo, color, matricula;
    private int id;


    // Aseguramos la identidad de los objetos coche tanto por la "matricula" como por el "id"
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Coche coche)) return false;
        return id == coche.id && Objects.equals(matricula, coche.matricula);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, matricula);
    }

    // Modificamos el formato del método toString
    @Override
    public String toString() {
        return String.format("""
                Coche:
                    Marca: %s
                    Modelo: %s
                    Color: %s
                    Id: %d
                    Matrícula: %s
                """, marca, modelo, color, id, matricula);
    }
}
