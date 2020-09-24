package co.lincolnstuart.Models

import co.lincolnstuart.Enums.EstadoAtualLivro
import co.lincolnstuart.Exceptions.LivroAlugadoAnteriormenteException
import co.lincolnstuart.Exceptions.LivroNaoEncontradoException
import co.lincolnstuart.Exceptions.LivroVendidoAnteriormenteException

class Livroteca(val nome: String, val dataCriacao: String){

    private val codigo: Int = controladorCodigo++
    private val acervo = mutableListOf<Item>()
    private var receitaAlugueis = 0.0
    private var receitaVendidos = 0.0

    //simulando um identity com um singleton
    companion object {
        var controladorCodigo = 1
    }

    fun cadastra(item: Item){
        acervo.add(item)
    }

    fun consulta(palavraChave: String) : Item {
        acervo.forEach {
            (it as? Livro)?.let{livro ->
                if(livro.codigo == palavraChave || livro.titulo.contains(palavraChave)){
                    return livro
                }
            }
            (it as? ColecaoDeLivros)?.let{colecao ->
                if(colecao.codigo == palavraChave || colecao.nome.contains(palavraChave)){
                    return colecao
                }
                colecao.livros.forEach{livroDaColecao ->
                    if(livroDaColecao.codigo == palavraChave || livroDaColecao.titulo.contains(palavraChave)){
                        return colecao
                    }
                }
            }
        }
        throw LivroNaoEncontradoException()
    }

    fun aluga(item: Item, dias: Int, cliente: Cliente, funcionario: Funcionario){
        when (item.estadoAtual) {
            EstadoAtualLivro.ALUGADO -> throw LivroAlugadoAnteriormenteException()
            EstadoAtualLivro.VENDIDO -> throw LivroVendidoAnteriormenteException()
            else -> item.estadoAtual = EstadoAtualLivro.ALUGADO
        }
        receitaAlugueis += item.precoAluguel * dias
        cliente.historicoAlugueis.add(item)
        funcionario.historicoAlugueis.add(item)
        println("--------------------------------------")
        println("Item $item \nalugado para $cliente por $dias\npelo funcionário $funcionario\n")
    }

    fun vende(item: Item, cliente: Cliente, funcionario: Funcionario){
        when (item.estadoAtual) {
            EstadoAtualLivro.ALUGADO -> throw LivroAlugadoAnteriormenteException()
            EstadoAtualLivro.VENDIDO -> throw LivroVendidoAnteriormenteException()
            else -> item.estadoAtual = EstadoAtualLivro.VENDIDO
        }
        receitaVendidos += item.precoVenda
        cliente.historicoCompras.add(item)
        funcionario.historicoVendas.add(item)
        println("--------------------------------------")
        println("Item $item \nvendido para $cliente\npelo funcionário $funcionario\n")

    }

    fun verificaEstoque(){
        var vendidos = 0
        var alugados = 0
        cabecalho()
        acervo.forEach {
            println(it)
            if(it.estadoAtual == EstadoAtualLivro.ALUGADO){
                alugados++
            } else if(it.estadoAtual == EstadoAtualLivro.VENDIDO){
                vendidos++
            }
        }
        rodape(vendidos, alugados)
    }

    private fun rodape(vendidos: Int, alugados: Int) {
        println("\nNÚMEROS :");
        println("Vendidos: $vendidos. Alugados: $alugados. Disponíveis: ${acervo.size - (vendidos + alugados)}")
        println("Receita de Vendas: $receitaVendidos")
        println("Receita de Aluguéis: $receitaAlugueis")
        println("\n######################################")
    }

    private fun cabecalho() {
        println("############## RELATÓRIO ##############")
        println("\n ACERVO :")
    }

    override fun equals(other: Any?): Boolean {
        return (other as? Livroteca)?.let {
            codigo == it.codigo
        }?: false
    }

    override fun hashCode(): Int {
        return codigo.hashCode()
    }

    override fun toString(): String {
        return "Livraria $nome, criada em $dataCriacao"
    }

}