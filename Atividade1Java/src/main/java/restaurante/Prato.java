package restaurante;

public class Prato {

    public String nome;
    public float preco;
    public String descricao;

    public Prato(String nome, float preco, String descricao) {
        this.nome = nome;
        this.preco = preco;
        this.descricao = descricao;
    }

    public String getNome() { return nome; }

    public float getPreco() { return preco; }

    public String getDescricao() { return descricao; }

}
