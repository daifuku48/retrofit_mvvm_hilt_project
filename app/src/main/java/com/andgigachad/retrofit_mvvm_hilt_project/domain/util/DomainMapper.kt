package com.andgigachad.retrofit_mvvm_hilt_project.domain.util

interface DomainMapper<Model, DomainModel> {

    fun mapToDomainModel(model: Model) : DomainModel

    fun mapToModel(domainModel: DomainModel) : Model
}