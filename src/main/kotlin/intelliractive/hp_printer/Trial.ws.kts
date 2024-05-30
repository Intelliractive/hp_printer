import intelliractive.hp_printer.Picture


Picture.entries.forEach {
    println(it.materials.map { it.toString().lowercase() })
    println(it.materials.size)
}

println("•".repeat(3))