package dev.ayameio.breathwork.ui.session

enum class Phase {
    Breathing,
    Retention,
    Break,
    Finished
}
data class SessionState (
    val phase: Phase
)