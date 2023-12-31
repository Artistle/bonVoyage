package com.hackaton.intercators_impl.module

import com.hackaton.core_di.getDeeps
import com.hackaton.core_di.nameDeep
import com.hackaton.core_di.qualifiers.PersistenceQualifiers
import com.hackaton.core_di.qualifiers.RepositoryQualifiers
import com.hackaton.core_di.qualifiers.UseCasesQualifiers
import com.hackaton.interactors.auth.userUseCases.CreateUserUseCase
import com.hackaton.interactors.auth.authUseCases.AuthStateUseCase
import com.hackaton.interactors.auth.authUseCases.AuthUseCase
import com.hackaton.interactors.auth.habitationUseCases.CreateHabitationUseCase
import com.hackaton.interactors.auth.habitationUseCases.GetHabitationsUseCase
import com.hackaton.interactors.auth.userUseCases.GetUserUseCase
import com.hackaton.interactors.auth.userUseCases.UploadUserDataUseCase
import com.hackaton.intercators_impl.authUseCases.AuthStateUseCaseImpl
import com.hackaton.intercators_impl.authUseCases.AuthUseCaseImpl
import com.hackaton.intercators_impl.habitationUseCases.CreateHabitationUseCaseImpl
import com.hackaton.intercators_impl.habitationUseCases.GetHabitationUseCaseImpl
import com.hackaton.intercators_impl.userUseCases.CreateUserUseCaseImpl
import com.hackaton.intercators_impl.userUseCases.GetUserUseCaseImpl
import com.hackaton.intercators_impl.userUseCases.UploadUserDataUseCaseImpl
import org.koin.dsl.module

object UseCaseModule {

    val useCaseModule = module {
        factory<AuthUseCase>(nameDeep(UseCasesQualifiers.AUTH_USE_CASE)) {
            AuthUseCaseImpl(getDeeps(RepositoryQualifiers.AUTH_REPOSITORY))
        }

        factory<AuthStateUseCase>(nameDeep(UseCasesQualifiers.AUTH_STATE_USE_CASE)) {
            AuthStateUseCaseImpl(getDeeps(PersistenceQualifiers.PREFERENCE_MANAGER))
        }

        factory<CreateUserUseCase>(nameDeep(UseCasesQualifiers.CREATE_USER_USE_CASE)) {
            CreateUserUseCaseImpl(getDeeps(RepositoryQualifiers.AUTH_REPOSITORY))
        }

        factory<UploadUserDataUseCase>(nameDeep(UseCasesQualifiers.UPLOAD_USER_DATA_USE_CASE)) {
            UploadUserDataUseCaseImpl(getDeeps(RepositoryQualifiers.USER_REPOSITORY))
        }

        factory<GetUserUseCase>(nameDeep(UseCasesQualifiers.USER_USE_CASE)) {
            GetUserUseCaseImpl(getDeeps(RepositoryQualifiers.USER_REPOSITORY))
        }

        factory<CreateHabitationUseCase>(nameDeep(UseCasesQualifiers.CREATE_HABITATION)) {
            CreateHabitationUseCaseImpl(getDeeps(RepositoryQualifiers.HABITATION_REPOSITORY))
        }

        factory<GetHabitationsUseCase>(nameDeep(UseCasesQualifiers.GET_HABITATION)) {
            GetHabitationUseCaseImpl(getDeeps(RepositoryQualifiers.HABITATION_REPOSITORY))
        }
    }
}