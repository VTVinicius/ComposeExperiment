package uikit.compose.masks

fun String.unmask() = this.replace("[^\\d]".toRegex(), "")