package co.lincolnstuart.Models

import co.lincolnstuart.Enums.EstadoAtualLivro

class ColecaoDeLivros(val codigo: String,
                      val nome: String,
                      val livros: Collection<Livro>,
                      precoVenda: Double,
                      precoAluguel: Double,
                      estadoAtual: EstadoAtualLivro = EstadoAtualLivro.DISPONIVEL
) : Item(precoVenda, precoAluguel, estadoAtual) {

    override fun equals(other: Any?): Boolean {
        return (other as? ColecaoDeLivros)?.let{
            codigo == it.codigo
        }?: false
    }

    override fun hashCode(): Int {
        return codigo.hashCode()
    }

    override fun toString(): String {
        return "COLEÇÃO : $codigo - $nome ($livros). Aluguel R$$precoAluguel. Venda R$$precoVenda. ($estadoAtual)"
    }
}