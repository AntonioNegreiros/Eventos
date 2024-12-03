public class Evento {
    int id;
    int idOrganizador;
    int idLocal;
    int data; 
    String descricao;
    int vagas;

    public Evento(int id, int idOrganizador, int idLocal, int data, String descricao, int vagas) {
        this.id = id;
        this.idOrganizador = idOrganizador;
        this.idLocal = idLocal;
        this.data = data;
        this.descricao = descricao;
        this.vagas = vagas;
    }

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

    public int getDataInt() { 
        return data;
    }

    public void setDataInt(int data) {
        this.data = data;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getVagas() {
        return vagas;
    }

    public void setVagas(int vagas) {
        this.vagas = vagas;
    }

}
