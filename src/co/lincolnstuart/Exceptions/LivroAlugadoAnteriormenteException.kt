package co.lincolnstuart.Exceptions

class LivroAlugadoAnteriormenteException(msg: String = "O livro encontra-se alugado :/")
    : LivroException(msg) { }