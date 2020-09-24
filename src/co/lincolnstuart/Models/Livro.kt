package co.lincolnstuart.Models

import co.lincolnstuart.Enums.EstadoAtualLivro

class Livro(val codigo: String,
            val titulo: String,
            val autor: String,
            val anoLancamento: Int,
            precoVenda: Double,
            precoAluguel: Double,
            estadoAtual: EstadoAtualLivro = EstadoAtualLivro.DISPONIVEL) : Item (precoVenda, precoAluguel, estadoAtual) {

    override fun toString(): String {
        return "  LIVRO : $codigo - $titulo/$autor ($anoLancamento). Aluguel R$$precoAluguel. Venda R$$precoVenda. ($estadoAtual)"
    }

}

