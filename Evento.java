public class Evento {
    int id;
    int idOrganizador;
    int idLocal;
    Date data;
    String descricao;
    ArrayList<Participante> participantes;
    int vagas;
 
    public Evento(int id, int idOrganizador, int idLocal, Date data, String descricao, int vagas) {
        this.id = id;
        this.idOrganizador = idOrganizador;
        this.idLocal = idLocal;
        this.data = data;
        this.descricao = descricao;
        this.vagas = vagas;
        this.participantes = new ArrayList<>();
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
 
    public Date getData() {
        return data;
    }
 
    public void setData(Date data) {
        this.data = data;
    }
 
    public String getDescricao() {
        return descricao;
    }
 
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
 
    public ArrayList<Participante> getParticipantes() {
        return participantes;
    }
 
    public int getVagas() {
        return vagas;
    }
 
    public void setVagas(int vagas) {
        this.vagas = vagas;
    }
 
    // Métodos para adicionar e remover participantes
    public boolean addParticipante(Participante p) {
        if (participantes.size() < vagas) {
            participantes.add(p);
            return true;
        }
        return false; // Evento cheio
    }
 
    public boolean removeParticipante(Participante p) {
        return participantes.remove(p);
    }
}
    
