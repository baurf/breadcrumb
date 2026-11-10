package org.example.kotlin

data class Entry(
    val name: String,
    val entries: List<Entry>?
) {
    constructor(name: String) : this(name, null)
}
