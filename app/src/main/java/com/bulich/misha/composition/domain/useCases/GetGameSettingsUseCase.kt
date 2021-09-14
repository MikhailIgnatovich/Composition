package com.bulich.misha.composition.domain.useCases

import com.bulich.misha.composition.domain.entity.GameSettings
import com.bulich.misha.composition.domain.entity.Level
import com.bulich.misha.composition.domain.repository.GameRepository

class GetGameSettingsUseCase(private val repository: GameRepository) {

    operator fun invoke(level: Level): GameSettings {
        return repository.getGameSettings(level)
    }
}