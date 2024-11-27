import java.util.ArrayList;
import java.util.Date;

public class Evento {
    int id;
    int idOrganizador;
    int idLocal;
    Date data; // Alterado para Date
    String descricao;
    ArrayList<Participante> participante;
    int vagas;

    public Evento(int id, int idOrganizador, int idLocal, Date data, String descricao, int vagas) {
        this.id = id;
        this.idOrganizador = idOrganizador;
        this.idLocal = idLocal;
        this.data = data;
        this.descricao = descricao;
        this.vagas = vagas;
        this.participante = new ArrayList<>();
    }

    // Getters e Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdOrganizador() {
        return idOrganizador;
    }

    public void setIdOrganizador(int idOrganizador) {
        this.idOrganizador = idOrganizador;
    }

    public int getIdLocal() {
        return idLocal;
    }

    public void setIdLocal(int idLocal) {
        this.idLocal = idLocal;
    }

    public Date getData() { // Tipo corrigido para Date
        return data;
    }

    public void setData(Date data) { // Tipo corrigido para Date
        this.data = data;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public ArrayList<Participante> getParticipante() {
        return participante;
    }

    public int getVagas() {
        return vagas;
    }

    public void setVagas(int vagas) {
        this.vagas = vagas;
    }

    // Métodos para adicionar e remover participantes
    public boolean addParticipante(Participante p) {
        if (participante.size() < vagas) {
            participante.add(p);
            return true;
        }
        return false; // Evento cheio
    }

    public boolean removeParticipante(Participante p) {
        return participante.remove(p);
    }
}
