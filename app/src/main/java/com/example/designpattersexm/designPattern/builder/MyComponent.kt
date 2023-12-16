package com.example.designpattersexm.designPattern.builder

class MyComponent private constructor(builder: Builder) {
    var name: String? = null
    var id: Int? = null
    var isVisible: Boolean? = null

    class Builder {
        var name: String? = null
        var id: Int? = null
        var isVisible: Boolean? = null

        fun setName(name: String) = apply { this.name = name }
        fun setId(id: Int) = apply { this.id = id }
        fun setVisibility(visible: Boolean) = apply { this.isVisible = visible }
        fun build() = MyComponent(this)
        fun getName() = name
        fun getId() = id
        fun getIsVisible() = isVisible
    }
    init {
        name = builder.getName()
        id = builder.getId()
        isVisible = builder.getIsVisible()
    }
}



data class MyComponent2(
    var name: String? = null,
    var id: Int? = null,
    var isVisible: Boolean? = null
) {
    class Builder {
        var name: String? = null
        var id: Int? = null
        var isVisible: Boolean? = null

        fun build() = MyComponent2(name, id, isVisible)
    }
}


//Too long; didn't read (TLDR)
//For most use cases you don't need a Builder pattern in Kotlin and are fine just using a constructor
// with named arguments and default parameters.

//In case you have a complex object and/or have a stateful configuration that
// you want to pass around until you have build the complete object, a Builder is useful.
//For even complex use cases you can use a type-safe builder to create a custom DSL to ease builder usage

data class MyComponent3(
    val name: String,
    val id: Int,
    val isVisible: Boolean,
    val height: Float?= null,
    val weight: Float? =null
)
