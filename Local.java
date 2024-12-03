public class Local {
    private String descricao;
    private int vagas;
    private int eventos;

 
    public Local(String descricao, int vagas, int eventos) {
        this.descricao = descricao;
        this.vagas = vagas;
        this.eventos = eventos;
    }


    public Local(String descricao, int vagas) {
        this.descricao = descricao;
        this.vagas = vagas;
        this.eventos = 0; 
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

    public int getEventos() {
        return eventos;
    }

    public void setEventos(int eventos) {
        this.eventos = eventos;
    }

    public boolean adicionarEvento() {
        if (eventos < vagas) {
            eventos++;
            System.out.println("Evento adicionado. Total de eventos: " + eventos);
            return true;
        } else {
            System.out.println("Não é possível adicionar o evento. Limite de vagas atingido.");
            return false;
        }
    }

  
    public boolean removerEvento() {
        if (eventos > 0) {
            eventos--;
            System.out.println("Evento removido. Total de eventos: " + eventos);
            return true;
        } else {
            System.out.println("Não há eventos para remover.");
            return false;
        }
    }
}
