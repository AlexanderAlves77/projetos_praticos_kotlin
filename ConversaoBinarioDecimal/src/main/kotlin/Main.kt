package org.example

fun main(args: Array<String>) {
    var numeroBinario: Long = 11111111
    var numeroDecimal: Int = conversaoBinarioDecimal(numeroBinario)
    println("Número Binário $numeroBinario é igual o número decimal $numeroDecimal.")
}

fun conversaoBinarioDecimal(numeroBinario: Long): Int {
    var numero = numeroBinario
    var decimal = 0
    var i = 0
    var temporario: Long

    while (numero.toInt() != 0) {
        temporario = numero % 10
        numero /= 10
        decimal += (temporario * Math.pow(2.0, i.toDouble())).toInt()
        ++i
    }

    return decimal
}