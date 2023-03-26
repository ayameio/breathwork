package dev.ayameio.breathwork.ui.session

enum class SessionStage {
    Breathing,
    Retention,
    RoundBreak,
    SessionOver
}
data class SessionUiState (
    val currentStage: SessionStage
)