package co.lincolnstuart.Models

class Cliente (rg: String, nome: String) : Pessoa(rg, nome){
    val historicoAlugueis = mutableListOf<Item>()
    val historicoCompras = mutableListOf<Item>()
    val listaDesejo = mutableListOf<Item>()

    override fun equals(other: Any?): Boolean {
        return (other as? Cliente)?.let{
            rg == it.rg
        }?: false
    }

    override fun hashCode(): Int {
        return rg.hashCode()
    }

    override fun toString(): String {
        return "Cliente $nome com RG $rg"
    }
}