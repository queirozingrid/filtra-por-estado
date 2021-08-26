import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "pessoas")
public class Pessoa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nome;

    public Pessoa(String nome, Estado estado, int idade) {
        this.nome = nome;
        this.estado = estado;
        this.idade = idade;
    }

    @ManyToOne
    @JoinColumn(name = "estado_id")
    private Estado estado;
    private int idade;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }
    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public void cadastro(String nome, Estado estado, int idade){

    }
}
