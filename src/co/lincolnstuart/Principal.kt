package co.lincolnstuart

import co.lincolnstuart.Exceptions.LivroException
import co.lincolnstuart.Models.*

val seboDoLincoln = Livroteca("Sebo do Lincoln", "01/01/2000")
val lincoln = Funcionario("111.111-1", "Lincoln")
val eduardo = Cliente("222.222-3", "Eduardo")
val cesar = Cliente("333.333-3", "Cesar")
val clubeDaLuta = Livro("1", "Clube da Luta", "Chuck Palahniuk", 1994, 20.0, 2.0)
val aprendendoKotlin = Livro("2", "Aprendendo Kotlin", "Cesar", 2020, 40.0, 2.5)
val primeirosPassosAndroid = Livro("3", "Primeiros passos com Android", "Eduardo", 2020, 45.0, 3.0)
val colecaoGeorgeOrwell = ColecaoDeLivros("4",
    "George Orwell",
    listOf(
        Livro("5", "1984", "George Orwell", 1948, 25.0, 1.5),

        Livro("5", "A Revolução dos Bichos", "George Orwell", 1950, 25.0, 1.5)),
    45.0,
    2.5
    )

fun main(){
    cadastraLivros()
    consultaLivros()
    alugaLivros()
    vendeLivros()
    seboDoLincoln.verificaEstoque()
}

private fun vendeLivros() {
    try{
        seboDoLincoln.vende(aprendendoKotlin, eduardo, lincoln)
    } catch (exception: LivroException){
        println(exception.message)
    }
    try{
        seboDoLincoln.vende(aprendendoKotlin, cesar, lincoln)
    } catch (exception: LivroException){
        println(exception.message)
    }
}

private fun alugaLivros() {
    //fiz blocos de try catch separados para tentar pegar o erro de cada linha
    try {
        seboDoLincoln.aluga(clubeDaLuta, 2, cesar, lincoln)
    } catch (exception: LivroException){
        println(exception.message)
    }
    try{
    seboDoLincoln.aluga(primeirosPassosAndroid, 5, cesar, lincoln)
    } catch (exception: LivroException){
        println(exception.message)
    }
    try{
    seboDoLincoln.aluga(clubeDaLuta, 2, cesar, lincoln)
    } catch (exception: LivroException){
        println(exception.message)
    }
}

private fun consultaLivros() {
    try {
        println("Livro encontrado: ${seboDoLincoln.consulta("1")}")
        println("Livro encontrado: ${seboDoLincoln.consulta("Qualquer coisa")}")
    } catch (exception: Exception) {
        println(exception.message)
    }
}

private fun cadastraLivros() {
    seboDoLincoln.cadastra(clubeDaLuta)
    seboDoLincoln.cadastra(aprendendoKotlin)
    seboDoLincoln.cadastra(primeirosPassosAndroid)
    seboDoLincoln.cadastra(colecaoGeorgeOrwell)
}