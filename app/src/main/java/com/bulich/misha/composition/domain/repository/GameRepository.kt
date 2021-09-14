package com.bulich.misha.composition.domain.repository

import com.bulich.misha.composition.domain.entity.GameSettings
import com.bulich.misha.composition.domain.entity.Level
import com.bulich.misha.composition.domain.entity.Question

interface GameRepository {

    fun generateQuestion(
        maxSumValue: Int,
        countOfOptions: Int
    ): Question

    fun getGameSettings(level: Level): GameSettings
}