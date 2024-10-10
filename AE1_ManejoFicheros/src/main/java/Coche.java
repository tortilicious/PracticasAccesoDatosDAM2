import java.util.Objects;

public class Coche {

    private String marca;
    private String modelo;
    private String color;
    private int id;
    private String matricula;

    public Coche() {
    }

    public Coche(String marca, String modelo, String color, int id, String matricula) {
        this.marca = marca;
        this.modelo = modelo;
        this.color = color;
        this.id = id;
        this.matricula = matricula;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

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

    @Override
    public String toString() {
        return String.format("""
                Coche:
                    Marca: $s
                    Modelo: $s
                    Color: $s
                    Id: $d
                    Matricula: $s
                """, marca, modelo, color, id, matricula);
    }
}
