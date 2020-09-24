package co.lincolnstuart.Exceptions

class LivroVendidoAnteriormenteException(msg: String = "O livro já foi vendido :/")
    : LivroException(msg) { }