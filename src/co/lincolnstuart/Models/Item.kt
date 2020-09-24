package co.lincolnstuart.Models

import co.lincolnstuart.Enums.EstadoAtualLivro

abstract class Item(var precoVenda: Double,
    var precoAluguel: Double,
    var estadoAtual: EstadoAtualLivro) { }