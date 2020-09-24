package co.lincolnstuart.Exceptions

class LivroNaoEncontradoException(msg: String = "O livro não foi encontrado no acervo :/")
    : LivroException(msg) { }