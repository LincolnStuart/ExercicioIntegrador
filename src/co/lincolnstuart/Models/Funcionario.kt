package co.lincolnstuart.Models

class Funcionario (rg: String, nome: String): Pessoa(rg, nome){
    val historicoAlugueis = mutableListOf<Item>()
    val historicoVendas = mutableListOf<Item>()

    override fun equals(other: Any?): Boolean {
        return (other as? Funcionario)?.let {
            rg == it.rg
        }?: false
    }

    override fun hashCode(): Int {
        return rg.hashCode()
    }

    override fun toString(): String {
        return "Funcionario $nome com RG $rg"
    }
}